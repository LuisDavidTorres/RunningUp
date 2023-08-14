package com.human.runningup;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.human.runningup.Objetos.Usuario;

public class CrearCuenta extends AppCompatActivity {
    Button BTN_Registrarse;
    FloatingActionButton BTN_Volver;

    /* renamed from: Contraseña  reason: contains not printable characters */
    private TextInputEditText f194Contrasea;

    /* renamed from: Contraseña_V  reason: contains not printable characters */
    private TextInputEditText f195Contrasea_V;
    private TextInputEditText Correo;

    /* renamed from: LayoutContraseña  reason: contains not printable characters */
    TextInputLayout f196LayoutContrasea;

    /* renamed from: LayoutContraseña_V  reason: contains not printable characters */
    TextInputLayout f197LayoutContrasea_V;
    TextInputLayout LayoutCorreo;
    TextInputLayout LayoutNombre;
    private TextInputEditText Nombre;
    /* access modifiers changed from: private */
    public DatabaseReference databaseReference;
    FirebaseAuth firebaseAuth;
    TextInputLayout textInputLayout;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) C1308R.layout.activity_crear_cuenta);
        this.LayoutNombre = (TextInputLayout) findViewById(C1308R.C1311id.Layout_Nombre);
        this.LayoutCorreo = (TextInputLayout) findViewById(C1308R.C1311id.Layout_Correo);
        this.f196LayoutContrasea = (TextInputLayout) findViewById(C1308R.C1311id.f203Layout_Contrasea);
        this.f197LayoutContrasea_V = (TextInputLayout) findViewById(C1308R.C1311id.f204Layout_Contrasea_V);
        this.firebaseAuth = FirebaseAuth.getInstance();
        this.databaseReference = FirebaseDatabase.getInstance().getReference();
        this.BTN_Volver = (FloatingActionButton) findViewById(C1308R.C1311id.BTN_VOLVER);
        this.Nombre = (TextInputEditText) findViewById(C1308R.C1311id.Nombre_Registro);
        this.Correo = (TextInputEditText) findViewById(C1308R.C1311id.Correo_Registro);
        this.f194Contrasea = (TextInputEditText) findViewById(C1308R.C1311id.f201Contrasea_Registro);
        this.f195Contrasea_V = (TextInputEditText) findViewById(C1308R.C1311id.f202Contrasea_Registro_V);
        Button button = (Button) findViewById(C1308R.C1311id.BTN_Registro);
        this.BTN_Registrarse = button;
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                CrearCuenta.this.Validar();
            }
        });
    }

    public void Validar() {
        String trim = this.Nombre.getText().toString().trim();
        String trim2 = this.Correo.getText().toString().trim();
        String trim3 = this.f194Contrasea.getText().toString().trim();
        String trim4 = this.f195Contrasea_V.getText().toString().trim();
        if (trim2.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(trim2).matches()) {
            this.LayoutCorreo.setHelperText("Correo invalido");
        } else {
            this.LayoutCorreo.setHelperText((CharSequence) null);
        }
        if (trim.isEmpty()) {
            this.LayoutNombre.setHelperText("Ingrese un nombre");
        } else {
            this.LayoutNombre.setHelperText((CharSequence) null);
        }
        if (trim3.isEmpty() || trim3.length() < 8) {
            this.f196LayoutContrasea.setHelperText("Se necesitan 8 caracteres");
            return;
        }
        this.f196LayoutContrasea.setHelperText((CharSequence) null);
        if (!trim4.equals(trim3)) {
            this.f197LayoutContrasea_V.setHelperText("Las contraseñas no coinciden");
        } else {
            Registrar(trim2, trim3, trim);
        }
    }

    public void Volver(View view) {
        startActivity(new Intent(this, MainActivity.class));
    }

    public void Registrar(final String str, final String str2, final String str3) {
        this.firebaseAuth.createUserWithEmailAndPassword(str, str2).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            public void onComplete(Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    String uid = CrearCuenta.this.firebaseAuth.getCurrentUser().getUid();
                    CrearCuenta.this.databaseReference.child("Usuario").child(uid).setValue(new Usuario(str3, str, str2, "https://i.ibb.co/yp64wrx/icono-del-s-lido-negro-avatar-perfil-de-usuario-121102166.jpg"));
                    CrearCuenta.this.startActivity(new Intent(CrearCuenta.this.getApplicationContext(), Menu_Inicial.class));
                    return;
                }
                Toast.makeText(CrearCuenta.this.getApplicationContext(), "Intente cambiar el correo", 0).show();
            }
        });
    }
}
