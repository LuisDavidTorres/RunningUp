package com.human.runningup.Fragments;

import android.database.sqlite.SQLiteDatabase;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.bumptech.glide.Glide;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.human.runningup.C1308R;
import com.human.runningup.DbHelper;
import com.human.runningup.Objetos.Ejercicio;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class Ejercicio_Fragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    FloatingActionButton BTN_FAVORITO;
    Button BTN_INICIAR_EJERCICIO;
    TextView Descripcion_Ejercicio;
    long Duracion = TimeUnit.MINUTES.toMillis((long) this.DuracionMinutos);
    int DuracionMinutos = 2;
    ImageView Imagen_Ejercicio;
    TextView Nombre_Ejercicio;
    MediaPlayer Sonido;
    TextView Tiempo_Visualizado;
    CountDownTimer countDownTimer;
    SQLiteDatabase database;
    DbHelper dbHelper;
    private String mParam1;
    private String mParam2;

    public static Ejercicio_Fragment newInstance(String str, String str2) {
        Ejercicio_Fragment ejercicio_Fragment = new Ejercicio_Fragment();
        Bundle bundle = new Bundle();
        bundle.putString(ARG_PARAM1, str);
        bundle.putString(ARG_PARAM2, str2);
        ejercicio_Fragment.setArguments(bundle);
        return ejercicio_Fragment;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.mParam1 = getArguments().getString(ARG_PARAM1);
            this.mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(C1308R.layout.fragment_ejercicio_, viewGroup, false);
        this.Nombre_Ejercicio = (TextView) inflate.findViewById(C1308R.C1311id.Nombre_Ejercicio);
        this.Imagen_Ejercicio = (ImageView) inflate.findViewById(C1308R.C1311id.Imagen_Ejercicio);
        this.Descripcion_Ejercicio = (TextView) inflate.findViewById(C1308R.C1311id.Descripcion_Ejercicio);
        Recupear_Ejercicio();
        this.Sonido = MediaPlayer.create(getContext(), C1308R.raw.alarma);
        this.Tiempo_Visualizado = (TextView) inflate.findViewById(C1308R.C1311id.mostrar);
        Button button = (Button) inflate.findViewById(C1308R.C1311id.btn_Iniciar_Ejercicio);
        this.BTN_INICIAR_EJERCICIO = button;
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Ejercicio_Fragment.this.countDownTimer = new CountDownTimer(Ejercicio_Fragment.this.Duracion, 1000) {
                    public void onTick(long j) {
                        Ejercicio_Fragment.this.Duracion = j;
                        Ejercicio_Fragment.this.ActualizarText();
                    }

                    public void onFinish() {
                        if (Ejercicio_Fragment.this.Sonido != null) {
                            Ejercicio_Fragment.this.Sonido.start();
                        }
                    }
                }.start();
            }
        });
        return inflate;
    }

    public void Recupear_Ejercicio() {
        Ejercicio ejercicio = (Ejercicio) getArguments().getSerializable("Ejercicio");
        this.Nombre_Ejercicio.setText(ejercicio.getNombre());
        Glide.with((Fragment) this).load(ejercicio.getImagen()).into(this.Imagen_Ejercicio);
        this.Descripcion_Ejercicio.setText(ejercicio.getDescripcion());
    }

    public void ActualizarText() {
        long j = this.Duracion;
        this.Tiempo_Visualizado.setText(String.format(Locale.getDefault(), "%02d:%02d", new Object[]{Integer.valueOf(((int) (j / 1000)) / 60), Integer.valueOf(((int) (j / 1000)) % 60)}));
    }
}
