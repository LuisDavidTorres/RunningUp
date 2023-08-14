package com.human.runningup;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;

public class Mi_Cuenta extends AppCompatActivity {
    Button BTNN;
    Button BTN_Actualizar_Datos;
    Button BTN_Cerrar_Sesion;
    TextView Correo_MiCuenta;
    ImageView ImagenUsuario;
    TextView Nombre_MiCuenta;
    EditText Nuevo_Correo;
    EditText Nuevo_Nombre;
    /* access modifiers changed from: private */
    public FirebaseUser User;
    private DatabaseReference databaseReference;
    private FirebaseAuth firebaseAuth;
    FirebaseStorage storage;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) C1308R.layout.activity_mi_cuenta);
        this.Nombre_MiCuenta = (TextView) findViewById(C1308R.C1311id.Nombre_MICuenta);
        this.Correo_MiCuenta = (TextView) findViewById(C1308R.C1311id.txtCorreo);
        this.ImagenUsuario = (ImageView) findViewById(C1308R.C1311id.IMG_Usuario);
        Button button = (Button) findViewById(C1308R.C1311id.BTNNN);
        this.BTNN = button;
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
            }
        });
        this.storage = FirebaseStorage.getInstance();
        this.Nuevo_Nombre = (EditText) findViewById(C1308R.C1311id.Nuevo_Nombre);
        this.Nuevo_Correo = (EditText) findViewById(C1308R.C1311id.Nuevo_Correo);
        this.ImagenUsuario.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
            }
        });
        this.BTN_Actualizar_Datos = (Button) findViewById(C1308R.C1311id.BTN_Actualizar_Datos);
        this.BTN_Cerrar_Sesion = (Button) findViewById(C1308R.C1311id.BTN_Cerrar_Sesion);
        FirebaseAuth instance = FirebaseAuth.getInstance();
        this.firebaseAuth = instance;
        this.User = instance.getCurrentUser();
        this.databaseReference = FirebaseDatabase.getInstance().getReference("Usuario");
        Recuperar_Usuario();
        this.BTN_Actualizar_Datos.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Mi_Cuenta.this.startActivity(new Intent(Mi_Cuenta.this.getApplicationContext(), Activity_Actualizar_Datos.class));
            }
        });
        this.BTN_Cerrar_Sesion.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Mi_Cuenta.this.startActivity(new Intent(Mi_Cuenta.this.getApplicationContext(), MainActivity.class));
            }
        });
    }

    public void Volver(View view) {
        startActivity(new Intent(this, Menu_Inicial.class));
        finish();
    }

    public void Recuperar_Usuario() {
        this.databaseReference.child(this.User.getUid()).addValueEventListener(new ValueEventListener() {
            public void onCancelled(DatabaseError databaseError) {
            }

            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    String str = "" + dataSnapshot.child("nombre").getValue();
                    String str2 = "" + dataSnapshot.child("imagen").getValue();
                    Mi_Cuenta.this.Nombre_MiCuenta.setText(str);
                    Mi_Cuenta.this.Correo_MiCuenta.setText(Mi_Cuenta.this.User.getEmail());
                    if (str2 != null) {
                        Glide.with(Mi_Cuenta.this.getApplicationContext()).load(str2).into(Mi_Cuenta.this.ImagenUsuario);
                    }
                }
            }
        });
    }
}
