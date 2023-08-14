package com.human.runningup;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button BTN_F_REGISTRARSE;
    Button BTN_INGRESAR;
    TextInputEditText Correo;

    /* renamed from: LayoutContraseña  reason: contains not printable characters */
    TextInputLayout f199LayoutContrasea;
    TextInputLayout LayoutCorreo;
    TextInputEditText Password;
    private DatabaseReference databaseReference;
    private FirebaseAuth mAuth;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) C1308R.layout.activity_main);
        this.LayoutCorreo = (TextInputLayout) findViewById(C1308R.C1311id.Layout_Email);
        this.f199LayoutContrasea = (TextInputLayout) findViewById(C1308R.C1311id.Layout_Password);
        this.Correo = (TextInputEditText) findViewById(C1308R.C1311id.Correo_Login);
        this.Password = (TextInputEditText) findViewById(C1308R.C1311id.Password_Login);
        this.mAuth = FirebaseAuth.getInstance();
        this.BTN_INGRESAR = (Button) findViewById(C1308R.C1311id.btn_Ingresar);
        this.BTN_F_REGISTRARSE = (Button) findViewById(C1308R.C1311id.btn_F_Crear_C);
        this.BTN_INGRESAR.setOnClickListener(this);
        this.BTN_F_REGISTRARSE.setOnClickListener(this);
        this.databaseReference = FirebaseDatabase.getInstance().getReference();
        if (FirebaseAuth.getInstance().getCurrentUser() != null) {
            startActivity(new Intent(getApplicationContext(), Menu_Inicial.class));
            finish();
        }
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case C1308R.C1311id.btn_F_Crear_C /*2131296473*/:
                startActivity(new Intent(this, CrearCuenta.class));
                return;
            case C1308R.C1311id.btn_Ingresar /*2131296474*/:
                Validar();
                return;
            default:
                return;
        }
    }

    public void Validar() {
        String trim = this.Correo.getText().toString().trim();
        String trim2 = this.Password.getText().toString().trim();
        if (trim.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(trim).matches()) {
            this.LayoutCorreo.setHelperText("Correo invalido");
        } else {
            this.LayoutCorreo.setHelperText((CharSequence) null);
        }
        if (trim2.isEmpty() || this.Password.length() < 8) {
            this.f199LayoutContrasea.setHelperText("Se necesitan 8 caracteres");
            return;
        }
        this.f199LayoutContrasea.setHelperText((CharSequence) null);
        IniciarSesion(trim, trim2);
    }

    public void IniciarSesion(String str, String str2) {
        this.mAuth.signInWithEmailAndPassword(str, str2).addOnCompleteListener((Activity) this, new OnCompleteListener<AuthResult>() {
            public void onComplete(Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    MainActivity.this.startActivity(new Intent(MainActivity.this.getApplicationContext(), Menu_Inicial.class));
                    MainActivity.this.finish();
                    return;
                }
                Toast.makeText(MainActivity.this.getApplicationContext(), "Credenciales Incorrectas" + task.getException(), 1).show();
            }
        });
    }
}
