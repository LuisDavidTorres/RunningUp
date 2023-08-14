package com.human.runningup;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.EmailAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Activity_Actualizar_Datos extends AppCompatActivity {
    Button BTN;

    /* renamed from: Contraseña  reason: contains not printable characters */
    EditText f193Contrasea;
    EditText NuevoCorreo;
    EditText NuevoNombre;
    /* access modifiers changed from: private */
    public FirebaseUser User;
    private DatabaseReference databaseReference;
    FirebaseAuth firebaseAuth;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) C1308R.layout.activity_actualizar_datos);
        this.NuevoCorreo = (EditText) findViewById(C1308R.C1311id.Nuevo_Correo);
        this.NuevoNombre = (EditText) findViewById(C1308R.C1311id.Nuevo_Nombre);
        this.BTN = (Button) findViewById(C1308R.C1311id.BTN_Actualizar);
        this.f193Contrasea = (EditText) findViewById(C1308R.C1311id.Confim_Password);
        this.BTN.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (!Activity_Actualizar_Datos.this.NuevoNombre.getText().toString().equals("")) {
                    Activity_Actualizar_Datos activity_Actualizar_Datos = Activity_Actualizar_Datos.this;
                    activity_Actualizar_Datos.ActualizarNombre(activity_Actualizar_Datos.NuevoNombre.getText().toString());
                }
                if (!Activity_Actualizar_Datos.this.NuevoCorreo.getText().toString().equals("") && !Activity_Actualizar_Datos.this.f193Contrasea.getText().toString().equals("")) {
                    Activity_Actualizar_Datos.this.ActualizarCorreo();
                }
            }
        });
        FirebaseAuth instance = FirebaseAuth.getInstance();
        this.firebaseAuth = instance;
        this.User = instance.getCurrentUser();
        this.databaseReference = FirebaseDatabase.getInstance().getReference("Usuario");
    }

    public void ActualizarNombre(String str) {
        this.databaseReference.child(this.User.getUid()).child("nombre").setValue(str);
        Toast.makeText(getApplicationContext(), "Nombre Actualizado", 0).show();
    }

    public void ActualizarCorreo() {
        this.User.reauthenticate(EmailAuthProvider.getCredential(this.User.getEmail(), this.f193Contrasea.getText().toString())).addOnCompleteListener(new OnCompleteListener<Void>() {
            public void onComplete(Task<Void> task) {
                if (task.isSuccessful()) {
                    Activity_Actualizar_Datos.this.User.updateEmail(Activity_Actualizar_Datos.this.NuevoCorreo.getText().toString()).addOnCompleteListener(new OnCompleteListener<Void>() {
                        public void onComplete(Task<Void> task) {
                            if (task.isSuccessful()) {
                                Activity_Actualizar_Datos.this.ActualizarCorreoRT(Activity_Actualizar_Datos.this.NuevoCorreo.getText().toString());
                                Toast.makeText(Activity_Actualizar_Datos.this.getApplicationContext(), "Correo Actualizado", 0).show();
                                return;
                            }
                            Toast.makeText(Activity_Actualizar_Datos.this.getApplicationContext(), "Este correo ya esta en uso, intenta cambiarlo", 0).show();
                        }
                    });
                } else {
                    Toast.makeText(Activity_Actualizar_Datos.this.getApplicationContext(), "Para actualizar tu correo debes ingresar tu contraseña actual y un nuevo correo valido", 0).show();
                }
            }
        });
    }

    public void ActualizarCorreoRT(String str) {
        this.databaseReference.child(this.User.getUid()).child("correo").setValue(str);
    }
}
