package com.human.runningup;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.human.runningup.Adaptadores.AdaptadorComentarios;
import com.human.runningup.Adaptadores.AdaptadorUsuarios;
import com.human.runningup.Objetos.Comentario;
import com.human.runningup.Objetos.Usuario;
import com.jintin.mixadapter.MixAdapter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Activity_comentarios extends AppCompatActivity {
    AdaptadorComentarios Adaptador;
    AdaptadorUsuarios AdaptadorUsers;
    Button BTN_Calificar;
    int CA_1 = 0;
    int CA_2 = 0;
    int CA_3 = 0;
    int CA_4 = 0;
    int CA_5 = 0;
    EditText Comentario_Descripcion;
    ImageView ImagenUsuario;
    ImageView ImagenUsuarioComentario;
    ArrayList<Comentario> ListaComentarios;
    ArrayList<Usuario> ListaUsuarios;
    TextView NombreUsuario;
    RatingBar Rating_Calificacion;
    FirebaseUser User;
    DatabaseReference databaseReference;
    FirebaseAuth firebaseAuth;
    RecyclerView recyclerView;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) C1308R.layout.activity_comentarios);
        this.recyclerView = (RecyclerView) findViewById(C1308R.C1311id.RecyclerView_Comentarios);
        this.ListaComentarios = new ArrayList<>();
        this.ListaUsuarios = new ArrayList<>();
        this.NombreUsuario = (TextView) findViewById(C1308R.C1311id.Nombre_usuario_Header);
        this.ImagenUsuario = (ImageView) findViewById(C1308R.C1311id.Imagen_perfil);
        this.ImagenUsuarioComentario = (ImageView) findViewById(C1308R.C1311id.Imagen_perfil_Comentario);
        this.databaseReference = FirebaseDatabase.getInstance().getReference();
        FirebaseAuth instance = FirebaseAuth.getInstance();
        this.firebaseAuth = instance;
        this.User = instance.getCurrentUser();
        this.Comentario_Descripcion = (EditText) findViewById(C1308R.C1311id.Comentario_Usuario);
        this.BTN_Calificar = (Button) findViewById(C1308R.C1311id.BTN_Calificar);
        this.Rating_Calificacion = (RatingBar) findViewById(C1308R.C1311id.RatingBar_Calificacion);
        this.BTN_Calificar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Activity_comentarios.this.VerificarComentario();
            }
        });
        Recuperar_Usuario();
        CargarLista();
        MostrarData();
    }

    public void Recuperar_Usuario() {
        this.databaseReference.child("Usuario").child(this.User.getUid()).addValueEventListener(new ValueEventListener() {
            public void onCancelled(DatabaseError databaseError) {
            }

            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    String str = "" + dataSnapshot.child("nombre").getValue();
                    String str2 = "" + dataSnapshot.child("imagen").getValue();
                    Activity_comentarios.this.NombreUsuario.setText(str);
                    if (str2 != null) {
                        Glide.with(Activity_comentarios.this.getApplicationContext()).load(str2).into(Activity_comentarios.this.ImagenUsuario);
                        return;
                    }
                    return;
                }
                Toast.makeText(Activity_comentarios.this.getApplicationContext(), "NO existe", 0).show();
            }
        });
    }

    public void VerificarComentario() {
        String obj = this.Comentario_Descripcion.getText().toString();
        if (this.Comentario_Descripcion.equals("")) {
            Toast.makeText(getApplicationContext(), "Ingrese una reseña", 0).show();
        } else {
            this.Comentario_Descripcion.setError((CharSequence) null);
        }
        if (this.Rating_Calificacion.getRating() == 0.0f) {
            Toast.makeText(getApplicationContext(), "Almenos ingrese una estrella", 0).show();
        } else {
            AgregarComentario(obj, (int) this.Rating_Calificacion.getRating(), Fecha());
        }
    }

    public void MostrarData() {
        this.recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        this.Adaptador = new AdaptadorComentarios(this.ListaComentarios, getApplicationContext());
        this.AdaptadorUsers = new AdaptadorUsuarios(this.ListaUsuarios, getApplicationContext());
        MixAdapter mixAdapter = new MixAdapter();
        mixAdapter.addAdapter(this.Adaptador);
        this.recyclerView.setAdapter(mixAdapter);
    }

    public String Fecha() {
        return new SimpleDateFormat("dd-MM-yyyy").format(new Date());
    }

    public void AgregarComentario(String str, int i, String str2) {
        final String charSequence = this.NombreUsuario.getText().toString();
        final String string = getIntent().getExtras().getString("IDGIM");
        final String str3 = str;
        final int i2 = i;
        final String str4 = str2;
        this.databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            public void onCancelled(DatabaseError databaseError) {
            }

            public void onDataChange(DataSnapshot dataSnapshot) {
                Usuario usuario = new Usuario();
                usuario.setNombre(charSequence);
                usuario.setImagen("https://i.ibb.co/yp64wrx/icono-del-s-lido-negro-avatar-perfil-de-usuario-121102166.jpg");
                Activity_comentarios.this.databaseReference.child("Gimnasio").child(string).child("Comentario").child(Activity_comentarios.this.User.getUid()).setValue(new Comentario(usuario, str3, i2, str4));
            }
        });
    }

    public void CargarLista() {
        this.databaseReference.child("Gimnasio").child(getIntent().getExtras().getString("IDGIM")).child("Comentario").addValueEventListener(new ValueEventListener() {
            public void onCancelled(DatabaseError databaseError) {
            }

            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot value : dataSnapshot.getChildren()) {
                    Activity_comentarios.this.ListaComentarios.add((Comentario) value.getValue(Comentario.class));
                }
                Activity_comentarios.this.Adaptador.notifyDataSetChanged();
                Activity_comentarios.this.mo23818C();
            }
        });
    }

    /* renamed from: C */
    public void mo23818C() {
        int size = this.ListaComentarios.size();
        for (int i = 0; i < size; i++) {
            int calificaion = this.ListaComentarios.get(i).getCalificaion();
            if (this.ListaComentarios.get(i).getCalificaion() == 5) {
                this.CA_5++;
            }
            if (calificaion == 1) {
                this.CA_1++;
            } else if (calificaion == 2) {
                this.CA_2++;
            } else if (calificaion == 3) {
                this.CA_3++;
            } else if (calificaion == 4) {
                this.CA_4++;
            } else if (calificaion == 5) {
                this.CA_5++;
            }
            CalcularCalificacion();
        }
    }

    public void CalcularCalificacion() {
        int i = this.CA_5;
        int i2 = this.CA_4;
        int i3 = this.CA_3;
        int i4 = this.CA_2;
        int i5 = this.CA_1;
        final double d = (double) ((((((i * 5) + (i2 * 4)) + (i3 * 3)) + (i4 * 2)) + (i5 * 1)) / ((((i + i2) + i3) + i4) + i5));
        final String string = getIntent().getExtras().getString("IDGIM");
        this.databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            public void onCancelled(DatabaseError databaseError) {
            }

            public void onDataChange(DataSnapshot dataSnapshot) {
                Activity_comentarios.this.databaseReference.child("Gimnasio").child(string).child("calificacion").setValue(Double.valueOf(d));
            }
        });
    }
}
