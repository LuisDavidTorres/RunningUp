package com.human.runningup;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.bumptech.glide.Glide;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.human.runningup.Fragments.IMC_Fragment;

public class Menu_Inicial extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    ImageView Imagen_Navegation_Usuario;
    TextView Nombre_Usuario;
    private FirebaseUser User;
    private DatabaseReference databaseReference;
    DrawerLayout drawer;
    private FirebaseAuth firebaseAuth;
    NavigationView navigationView;
    ActionBarDrawerToggle toggle;
    Toolbar toolbar;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) C1308R.layout.activity_menu_inicial);
        this.drawer = (DrawerLayout) findViewById(C1308R.C1311id.drawer_layout);
        this.navigationView = (NavigationView) findViewById(C1308R.C1311id.nav_view);
        this.toolbar = (Toolbar) findViewById(C1308R.C1311id.toolbar_main);
        FirebaseAuth instance = FirebaseAuth.getInstance();
        this.firebaseAuth = instance;
        this.User = instance.getCurrentUser();
        this.Nombre_Usuario = (TextView) this.navigationView.getHeaderView(0).findViewById(C1308R.C1311id.Nombre_usuario_Header);
        this.Imagen_Navegation_Usuario = (ImageView) this.navigationView.getHeaderView(0).findViewById(C1308R.C1311id.Imagen_Perfil);
        this.databaseReference = FirebaseDatabase.getInstance().getReference("Usuario");
        RecuperarDatos();
        getSupportFragmentManager().beginTransaction().add((int) C1308R.C1311id.Contenedor_Fragment, (Fragment) new MapaFragment()).commit();
        setTitle("Recorrer");
        setSupportActionBar(this.toolbar);
        this.drawer.addDrawerListener(this.toggle);
        this.navigationView.setNavigationItemSelectedListener(this);
        this.toggle = new ActionBarDrawerToggle(this, this.drawer, this.toolbar, C1308R.string.Nav_drawer_open, C1308R.string.Nav_drawer_close);
    }

    public boolean onNavigationItemSelected(MenuItem menuItem) {
        Fragment_inst(menuItem);
        return false;
    }

    private void Fragment_inst(MenuItem menuItem) {
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        switch (menuItem.getItemId()) {
            case C1308R.C1311id.Ejercicios /*2131296305*/:
                beginTransaction.replace(C1308R.C1311id.Contenedor_Fragment, new Lista_Ejercicios()).commit();
                beginTransaction.addToBackStack((String) null);
                break;
            case C1308R.C1311id.Favoritos /*2131296310*/:
                beginTransaction.replace(C1308R.C1311id.Contenedor_Fragment, new Lista_Ejercicios_Favoritos()).commit();
                beginTransaction.addToBackStack((String) null);
                break;
            case C1308R.C1311id.Gimnasios /*2131296312*/:
                beginTransaction.replace(C1308R.C1311id.Contenedor_Fragment, new Lista_Gimnasios()).commit();
                beginTransaction.addToBackStack((String) null);
                break;
            case C1308R.C1311id.IMC_Calculado /*2131296314*/:
                beginTransaction.replace(C1308R.C1311id.Contenedor_Fragment, new IMC_Fragment()).commit();
                beginTransaction.addToBackStack((String) null);
                break;
            case C1308R.C1311id.MICuenta /*2131296336*/:
                startActivity(new Intent(this, Mi_Cuenta.class));
                break;
            case C1308R.C1311id.Maps /*2131296337*/:
                beginTransaction.replace(C1308R.C1311id.Contenedor_Fragment, new MapaFragment()).commit();
                beginTransaction.addToBackStack((String) null);
                break;
            case C1308R.C1311id.Recorridos /*2131296354*/:
                beginTransaction.replace(C1308R.C1311id.Contenedor_Fragment, new Recorridos()).commit();
                beginTransaction.addToBackStack((String) null);
                break;
        }
        beginTransaction.addToBackStack((String) null);
        setTitle(menuItem.getTitle());
        this.drawer.closeDrawers();
    }

    public void RecuperarDatos() {
        this.databaseReference.child(this.User.getUid()).addValueEventListener(new ValueEventListener() {
            public void onCancelled(DatabaseError databaseError) {
            }

            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    String str = "" + dataSnapshot.child("nombre").getValue();
                    String str2 = "" + dataSnapshot.child("imagen").getValue();
                    Menu_Inicial.this.Nombre_Usuario.setText(str);
                    if (str2 != null) {
                        Glide.with(Menu_Inicial.this.getApplicationContext()).load(str2).into(Menu_Inicial.this.Imagen_Navegation_Usuario);
                        return;
                    }
                    return;
                }
                Toast.makeText(Menu_Inicial.this.getApplicationContext(), "No existe", 0).show();
            }
        });
    }
}
