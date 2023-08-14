package com.human.runningup;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.human.runningup.Objetos.Recorrido;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MapaFragment extends Fragment {
    FloatingActionButton BTN_Terminar;
    ExtendedFloatingActionButton Boton_Iniciar;
    boolean CarreraStart = false;
    boolean CarreraTerminada = true;
    TextView Cronomet;
    String MetrosRecorridos;
    int PermisoAceptado = 1;
    Timer Tiempo;
    TextView TxtMetros;
    /* access modifiers changed from: private */
    public FirebaseUser User;
    private OnMapReadyCallback callback = new OnMapReadyCallback() {
        public void onMapReady(GoogleMap googleMap) {
            MapaFragment.this.mMap = googleMap;
            Bundle arguments = MapaFragment.this.getArguments();
            if (arguments != null) {
                double d = arguments.getDouble("Latitud");
                double d2 = arguments.getDouble("Longitud");
                String string = arguments.getString("NombreGIM");
                LatLng latLng = new LatLng(d, d2);
                MapaFragment.this.mMap.addMarker(new MarkerOptions().position(latLng).title(string));
                MapaFragment.this.mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 9.0f));
            }
            MapaFragment.this.VerificarPermisos();
        }
    };
    /* access modifiers changed from: private */
    public DatabaseReference databaseReference;
    private FirebaseAuth firebaseAuth;
    double latitud_Cambiada;
    double latitud_Inicial;
    LocationManager locationManager;
    double longitud_Cambiada;
    double longitud_Inicial;
    GoogleMap mMap;
    Polyline polyline = null;
    double time = 0.0d;
    TimerTask timerTask;

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(C1308R.layout.fragment_mapa, viewGroup, false);
        this.Cronomet = (TextView) inflate.findViewById(C1308R.C1311id.Cronometro);
        this.TxtMetros = (TextView) inflate.findViewById(C1308R.C1311id.Kilometros_Recorridos_Mapa);
        FirebaseAuth instance = FirebaseAuth.getInstance();
        this.firebaseAuth = instance;
        this.User = instance.getCurrentUser();
        this.databaseReference = FirebaseDatabase.getInstance().getReference("Usuario");
        this.Boton_Iniciar = (ExtendedFloatingActionButton) inflate.findViewById(C1308R.C1311id.BTN_Iniciar);
        this.BTN_Terminar = (FloatingActionButton) inflate.findViewById(C1308R.C1311id.BTN_Detenerse);
        this.Tiempo = new Timer();
        this.Boton_Iniciar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (MapaFragment.this.checkIfLocationOpened()) {
                    MapaFragment.this.starStopCarrera();
                    if (MapaFragment.this.CarreraTerminada) {
                        MapaFragment.this.CarreraTerminada = false;
                        MapaFragment.this.CoordenadasIniciales();
                        return;
                    }
                    return;
                }
                Toast.makeText(MapaFragment.this.getContext(), "Enciende tu ubicación  por favor", 0).show();
            }
        });
        this.BTN_Terminar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MapaFragment.this.TerminarRunnig();
            }
        });
        return inflate;
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        SupportMapFragment supportMapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(C1308R.C1311id.map);
        if (supportMapFragment != null) {
            supportMapFragment.getMapAsync(this.callback);
        }
    }

    public void VerificarPermisos() {
        if (ContextCompat.checkSelfPermission(getContext(), "android.permission.ACCESS_FINE_LOCATION") == -1) {
            requestPermissions(new String[]{"android.permission.ACCESS_FINE_LOCATION"}, this.PermisoAceptado);
        } else {
            this.mMap.setMyLocationEnabled(true);
        }
    }

    public void starStopCarrera() {
        if (!this.CarreraStart) {
            this.CarreraStart = true;
            this.BTN_Terminar.setVisibility(4);
            this.Boton_Iniciar.setText("Detenerse");
            starTimempo();
            return;
        }
        this.CarreraStart = false;
        this.Boton_Iniciar.setText("Continuar");
        this.BTN_Terminar.setVisibility(0);
        this.BTN_Terminar.setVisibility(0);
        this.timerTask.cancel();
    }

    public void CoordenadasIniciales() {
        if (checkIfLocationOpened()) {
            LocationManager locationManager2 = (LocationManager) getActivity().getSystemService(FirebaseAnalytics.Param.LOCATION);
            this.locationManager = locationManager2;
            try {
                Location lastKnownLocation = locationManager2.getLastKnownLocation("gps");
                this.longitud_Inicial = lastKnownLocation.getLongitude();
                this.latitud_Inicial = lastKnownLocation.getLatitude();
                LatLng latLng = new LatLng(this.latitud_Inicial, this.longitud_Inicial);
                this.mMap.addMarker(new MarkerOptions().position(latLng).title("Mi ubicación"));
                this.mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 14.0f));
                this.locationManager.requestLocationUpdates("gps", 2000, 0.0f, new Localizacion());
            } catch (Exception e) {
                Toast.makeText(getContext(), "" + e.getLocalizedMessage(), 0).show();
            }
        }
    }

    private void starTimempo() {
        C12954 r1 = new TimerTask() {
            public void run() {
                if (MapaFragment.this.getActivity() != null) {
                    MapaFragment.this.getActivity().runOnUiThread(new Runnable() {
                        public void run() {
                            MapaFragment.this.time += 1.0d;
                            MapaFragment.this.Cronomet.setText(MapaFragment.this.getTiempoTxt());
                        }
                    });
                }
            }
        };
        this.timerTask = r1;
        this.Tiempo.scheduleAtFixedRate(r1, 0, 1000);
    }

    /* access modifiers changed from: private */
    public String getTiempoTxt() {
        int round = ((int) Math.round(this.time)) % 86400;
        int i = round % 3600;
        return formatoCronometro(i % 60, i / 60, round / 3600);
    }

    public String Fecha() {
        return new SimpleDateFormat("dd-MM-yyyy").format(new Date());
    }

    /* access modifiers changed from: private */
    public String formatoCronometro(int i, int i2, int i3) {
        return String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, new Object[]{Integer.valueOf(i3)}) + ":" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, new Object[]{Integer.valueOf(i2)}) + ":" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, new Object[]{Integer.valueOf(i)});
    }

    public void TerminarRunnig() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Terminar Carrera");
        builder.setMessage("¿Estás seguro de que quieres terminar la carrera?");
        builder.setPositiveButton("Terminar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                if (MapaFragment.this.timerTask != null) {
                    MapaFragment.this.timerTask.cancel();
                    MapaFragment.this.time = 0.0d;
                    MapaFragment.this.CarreraTerminada = true;
                    MapaFragment mapaFragment = MapaFragment.this;
                    mapaFragment.Guardar_carrera(mapaFragment.Cronomet.getText().toString(), MapaFragment.this.MetrosRecorridos, MapaFragment.this.Fecha());
                    MapaFragment.this.BTN_Terminar.setVisibility(8);
                    MapaFragment.this.Cronomet.setText(MapaFragment.this.formatoCronometro(0, 0, 0));
                    MapaFragment.this.Boton_Iniciar.setText("Iniciar");
                    MapaFragment.this.TxtMetros.setText("0");
                }
            }
        });
        builder.setNeutralButton("Cancelar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        builder.show();
    }

    public class Localizacion implements LocationListener {
        public void onFlushComplete(int i) {
        }

        public void onLocationChanged(List<Location> list) {
        }

        public void onProviderDisabled(String str) {
        }

        public void onProviderEnabled(String str) {
        }

        public void onStatusChanged(String str, int i, Bundle bundle) {
        }

        public Localizacion() {
        }

        public void onLocationChanged(Location location) {
            MapaFragment.this.distancia(location.getLatitude(), location.getLongitude());
        }
    }

    public void distancia(double d, double d2) {
        if (this.CarreraStart) {
            Location location = new Location("punto A");
            location.setLatitude(this.latitud_Inicial);
            location.setLongitude(this.longitud_Inicial);
            Location location2 = new Location("punto B");
            location2.setLatitude(d);
            location2.setLongitude(d2);
            String format = new DecimalFormat("#.##").format((double) location2.distanceTo(location));
            this.MetrosRecorridos = format;
            this.TxtMetros.setText(format + " MTS");
        }
    }

    /* access modifiers changed from: private */
    public boolean checkIfLocationOpened() {
        String string = Settings.Secure.getString(getActivity().getContentResolver(), "location_providers_allowed");
        return string.contains("gps") || string.contains("network");
    }

    public void Guardar_carrera(final String str, final String str2, final String str3) {
        this.databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            public void onCancelled(DatabaseError databaseError) {
            }

            public void onDataChange(DataSnapshot dataSnapshot) {
                MapaFragment.this.databaseReference.child(MapaFragment.this.User.getUid()).child("Recorrido").push().setValue(new Recorrido(str3, str2, str));
            }
        });
    }
}
