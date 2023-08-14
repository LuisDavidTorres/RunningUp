package com.human.runningup.Fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.bumptech.glide.Glide;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.human.runningup.Activity_comentarios;
import com.human.runningup.C1308R;
import com.human.runningup.MapaFragment;
import com.human.runningup.Objetos.Comentario;
import com.human.runningup.Objetos.Gimnasio;
import java.util.ArrayList;

public class Gimnasio_Fragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    ArrayList<Comentario> ArrayComentarios;
    int CA_1 = 0;
    int CA_2 = 0;
    int CA_3 = 0;
    int CA_4 = 0;
    int CA_5 = 0;
    TextView Correo_Gimnasio;
    TextView Descripcion_Gimnasio;
    TextView Direccion_Gimnasio;
    Animation FAB_CLOSE;
    Animation FAB_OPEN;
    boolean Floating = false;
    ImageView Imagen_Gimnasio;
    TextView Nombre_Gimnasio;
    TextView Precio_Gimnasio;
    Animation ROTACION_ADELANTE;
    Animation ROTACION_ATRAS;
    RatingBar Rating_GIM;
    TextView Telefono_Gimnasio;
    TextView Texto_Calificacion;
    CardView cardView;
    DatabaseReference databaseReference;
    FloatingActionButton floatingB_Correo;
    FloatingActionButton floatingB_Llamada;
    FloatingActionButton floatingB_Principal;
    private String mParam1;
    private String mParam2;

    public static Gimnasio_Fragment newInstance(String str, String str2) {
        Gimnasio_Fragment gimnasio_Fragment = new Gimnasio_Fragment();
        Bundle bundle = new Bundle();
        bundle.putString(ARG_PARAM1, str);
        bundle.putString(ARG_PARAM2, str2);
        gimnasio_Fragment.setArguments(bundle);
        return gimnasio_Fragment;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.mParam1 = getArguments().getString(ARG_PARAM1);
            this.mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(C1308R.layout.fragment_gimnasio_, viewGroup, false);
        this.Imagen_Gimnasio = (ImageView) inflate.findViewById(C1308R.C1311id.Imagen_Gimnasio);
        this.Nombre_Gimnasio = (TextView) inflate.findViewById(C1308R.C1311id.Nombre_Gimnasio);
        this.Precio_Gimnasio = (TextView) inflate.findViewById(C1308R.C1311id.Precio_Gimnasio);
        this.Direccion_Gimnasio = (TextView) inflate.findViewById(C1308R.C1311id.Direccion_Gimnasio);
        this.Correo_Gimnasio = (TextView) inflate.findViewById(C1308R.C1311id.Correo_Gimnasio);
        this.Telefono_Gimnasio = (TextView) inflate.findViewById(C1308R.C1311id.Telefono_Gimnasio);
        this.Descripcion_Gimnasio = (TextView) inflate.findViewById(C1308R.C1311id.Descripcion_Gimnasio);
        this.Texto_Calificacion = (TextView) inflate.findViewById(C1308R.C1311id.Texto_Calificacion);
        this.Rating_GIM = (RatingBar) inflate.findViewById(C1308R.C1311id.RatingBar_Gimnasio_general);
        this.databaseReference = FirebaseDatabase.getInstance().getReference();
        this.cardView = (CardView) inflate.findViewById(C1308R.C1311id.Card_Calificacion);
        this.ArrayComentarios = new ArrayList<>();
        this.cardView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Gimnasio_Fragment.this.Comentarios_Init();
            }
        });
        this.floatingB_Principal = (FloatingActionButton) inflate.findViewById(C1308R.C1311id.FAB);
        this.floatingB_Correo = (FloatingActionButton) inflate.findViewById(C1308R.C1311id.FAB_CORREO);
        this.floatingB_Llamada = (FloatingActionButton) inflate.findViewById(C1308R.C1311id.FAB_LLAMAR);
        this.FAB_OPEN = AnimationUtils.loadAnimation(getContext(), C1308R.anim.fab_open);
        this.FAB_CLOSE = AnimationUtils.loadAnimation(getContext(), C1308R.anim.fab_close);
        this.ROTACION_ADELANTE = AnimationUtils.loadAnimation(getContext(), C1308R.anim.rotacion_adelante);
        this.ROTACION_ATRAS = AnimationUtils.loadAnimation(getContext(), C1308R.anim.rotacion_atras);
        this.floatingB_Principal.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Gimnasio_Fragment.this.AnimationFab();
            }
        });
        this.floatingB_Correo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Gimnasio_Fragment.this.CoordenadasGimnasio();
            }
        });
        this.floatingB_Llamada.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (ContextCompat.checkSelfPermission(Gimnasio_Fragment.this.getContext(), "android.permission.CALL_PHONE") == 0) {
                    Gimnasio_Fragment.this.startActivity(new Intent("android.intent.action.CALL", Uri.parse("tel:" + Gimnasio_Fragment.this.Telefono_Gimnasio.getText().toString())));
                    return;
                }
                Gimnasio_Fragment.this.requestPermissions(new String[]{"android.permission.CALL_PHONE"}, 1);
            }
        });
        Recuperar_Gimnasio();
        Recuperar_Calificacion();
        return inflate;
    }

    public void Recuperar_Gimnasio() {
        Gimnasio gimnasio = (Gimnasio) getArguments().getSerializable("Gimnasio");
        this.Nombre_Gimnasio.setText(gimnasio.getNombre());
        Glide.with((Fragment) this).load(gimnasio.getImagen()).into(this.Imagen_Gimnasio);
        this.Precio_Gimnasio.setText(String.valueOf(gimnasio.getPrecio()));
        this.Direccion_Gimnasio.setText(gimnasio.getDireccion());
        this.Correo_Gimnasio.setText(gimnasio.getCorreo());
        this.Telefono_Gimnasio.setText(gimnasio.getTelefono());
        this.Descripcion_Gimnasio.setText(gimnasio.getDescripcion());
    }

    public void AnimationFab() {
        if (this.Floating) {
            this.floatingB_Principal.startAnimation(this.ROTACION_ATRAS);
            this.floatingB_Llamada.startAnimation(this.FAB_CLOSE);
            this.floatingB_Correo.startAnimation(this.FAB_CLOSE);
            this.Floating = false;
            return;
        }
        this.floatingB_Principal.startAnimation(this.ROTACION_ADELANTE);
        this.floatingB_Llamada.startAnimation(this.FAB_OPEN);
        this.floatingB_Correo.startAnimation(this.FAB_OPEN);
        this.Floating = true;
    }

    public void Comentarios_Init() {
        Intent intent = new Intent(getContext(), Activity_comentarios.class);
        intent.putExtra("IDGIM", ((Gimnasio) getArguments().getSerializable("Gimnasio")).getID());
        startActivity(intent);
    }

    public void CoordenadasGimnasio() {
        Gimnasio gimnasio = (Gimnasio) getArguments().getSerializable("Gimnasio");
        Bundle bundle = new Bundle();
        bundle.putDouble("Latitud", (double) gimnasio.getLatitud());
        bundle.putDouble("Longitud", (double) gimnasio.getLongitud());
        bundle.putString("NombreGIM", gimnasio.getNombre());
        MapaFragment mapaFragment = new MapaFragment();
        mapaFragment.setArguments(bundle);
        FragmentTransaction beginTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        beginTransaction.replace(C1308R.C1311id.Contenedor_Fragment, mapaFragment);
        beginTransaction.addToBackStack((String) null);
        beginTransaction.commit();
    }

    public void Recuperar_Calificacion() {
        this.databaseReference.child("Gimnasio").child(((Gimnasio) getArguments().getSerializable("Gimnasio")).getID()).addValueEventListener(new ValueEventListener() {
            public void onCancelled(DatabaseError databaseError) {
            }

            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    Float valueOf = Float.valueOf(Float.parseFloat(String.valueOf(((Long) dataSnapshot.child("calificacion").getValue()).longValue())));
                    Gimnasio_Fragment.this.Rating_GIM.setRating(valueOf.floatValue());
                    Gimnasio_Fragment.this.Texto_Calificacion.setText("" + valueOf);
                }
            }
        });
    }
}
