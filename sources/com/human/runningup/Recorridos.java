package com.human.runningup;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.human.runningup.Adaptadores.AdaptadorRecorrido;
import com.human.runningup.Objetos.Recorrido;
import java.util.ArrayList;

public class Recorridos extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    AdaptadorRecorrido Adaptador;
    ArrayList<Recorrido> ListaRecorridos;
    private FirebaseUser User;
    private DatabaseReference databaseReference;
    private FirebaseAuth firebaseAuth;
    private String mParam1;
    private String mParam2;
    RecyclerView recyclerView;

    public static Recorridos newInstance(String str, String str2) {
        Recorridos recorridos = new Recorridos();
        Bundle bundle = new Bundle();
        bundle.putString(ARG_PARAM1, str);
        bundle.putString(ARG_PARAM2, str2);
        recorridos.setArguments(bundle);
        return recorridos;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.mParam1 = getArguments().getString(ARG_PARAM1);
            this.mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(C1308R.layout.fragment_recorridos, viewGroup, false);
        this.databaseReference = FirebaseDatabase.getInstance().getReference("Usuario");
        FirebaseAuth instance = FirebaseAuth.getInstance();
        this.firebaseAuth = instance;
        this.User = instance.getCurrentUser();
        this.recyclerView = (RecyclerView) inflate.findViewById(C1308R.C1311id.RecyclerView_Recorridos);
        this.ListaRecorridos = new ArrayList<>();
        CargarLista();
        MostrarData();
        return inflate;
    }

    public void CargarLista() {
        this.databaseReference.child(this.User.getUid()).child("Recorrido").addValueEventListener(new ValueEventListener() {
            public void onCancelled(DatabaseError databaseError) {
            }

            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot value : dataSnapshot.getChildren()) {
                    Recorridos.this.ListaRecorridos.add((Recorrido) value.getValue(Recorrido.class));
                }
                Recorridos.this.Adaptador.notifyDataSetChanged();
            }
        });
    }

    public void MostrarData() {
        this.recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        AdaptadorRecorrido adaptadorRecorrido = new AdaptadorRecorrido(this.ListaRecorridos, getContext());
        this.Adaptador = adaptadorRecorrido;
        this.recyclerView.setAdapter(adaptadorRecorrido);
    }
}
