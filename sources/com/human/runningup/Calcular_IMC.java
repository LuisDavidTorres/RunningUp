package com.human.runningup;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Calcular_IMC extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    EditText Altura;
    Button BTN_CALCULAR_IMC;
    TextView Evaluacion_IMC;
    TextView IMC;
    EditText Peso;
    SeekBar SeekBar_Peso;
    SeekBar Seekbar_Altura;
    private FirebaseUser User;
    SQLiteDatabase database;
    DbHelper dbHelper;
    private FirebaseAuth firebaseAuth;
    private String mParam1;
    private String mParam2;

    public String Evaluacion_IMC(double d) {
        return d < 18.5d ? "Bajo peso" : (d <= 18.5d || d >= 24.9d) ? (d <= 24.9d || d >= 29.9d) ? "Obesidad" : "Sobrepeso" : "Peso normal";
    }

    public static Calcular_IMC newInstance(String str, String str2) {
        Calcular_IMC calcular_IMC = new Calcular_IMC();
        Bundle bundle = new Bundle();
        bundle.putString(ARG_PARAM1, str);
        bundle.putString(ARG_PARAM2, str2);
        calcular_IMC.setArguments(bundle);
        return calcular_IMC;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.mParam1 = getArguments().getString(ARG_PARAM1);
            this.mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(C1308R.layout.fragment_calcular__i_m_c, viewGroup, false);
        this.Evaluacion_IMC = (TextView) inflate.findViewById(C1308R.C1311id.IMC_Evaluacion);
        this.IMC = (TextView) inflate.findViewById(C1308R.C1311id.IMC_Calculado);
        FirebaseAuth instance = FirebaseAuth.getInstance();
        this.firebaseAuth = instance;
        this.User = instance.getCurrentUser();
        this.SeekBar_Peso = (SeekBar) inflate.findViewById(C1308R.C1311id.SeekBar_Peso_IMC);
        this.Seekbar_Altura = (SeekBar) inflate.findViewById(C1308R.C1311id.SeekBar_Altura_IMC);
        this.Peso = (EditText) inflate.findViewById(C1308R.C1311id.Peso_IMC);
        this.Altura = (EditText) inflate.findViewById(C1308R.C1311id.Altura_IMC);
        Button button = (Button) inflate.findViewById(C1308R.C1311id.btn_Calcular_IMC);
        this.BTN_CALCULAR_IMC = button;
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                float parseFloat = Float.parseFloat(Calcular_IMC.this.Altura.getText().toString());
                int parseInt = Integer.parseInt(Calcular_IMC.this.Peso.getText().toString());
                double d = (double) (((float) parseInt) / (parseFloat * parseFloat));
                String Evaluacion_IMC = Calcular_IMC.this.Evaluacion_IMC(d);
                String format = new DecimalFormat("#.##").format(d);
                Calcular_IMC.this.IMC.setText(format);
                Calcular_IMC.this.Evaluacion_IMC.setText(Evaluacion_IMC);
                Calcular_IMC.this.Registrar_IMC(Float.valueOf(parseFloat), parseInt, format, Evaluacion_IMC);
            }
        });
        this.SeekBar_Peso.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
            }

            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                Calcular_IMC.this.Peso.setText("" + (i + 40));
            }
        });
        this.Seekbar_Altura.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
            }

            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                Calcular_IMC.this.Altura.setText("" + ((float) ((((double) i) / 100.0d) + 1.3d)));
            }
        });
        return inflate;
    }

    public void Registrar_IMC(Float f, int i, String str, String str2) {
        DbHelper dbHelper2 = new DbHelper(getContext());
        this.dbHelper = dbHelper2;
        this.database = dbHelper2.getWritableDatabase();
        String f2 = Float.toString(f.floatValue());
        ContentValues contentValues = new ContentValues();
        String uid = this.User.getUid();
        contentValues.put("Fecha", Fecha());
        contentValues.put("Calificación", str);
        contentValues.put("Altura", f2);
        contentValues.put("Peso", Integer.valueOf(i));
        contentValues.put("ID_USUARIO", uid);
        contentValues.put("Evaluación", str2);
        this.database.insert(DbHelper.TABLA_IMC, (String) null, contentValues);
        this.database.close();
    }

    public String Fecha() {
        return new SimpleDateFormat("dd-MM-yyyy").format(new Date());
    }
}
