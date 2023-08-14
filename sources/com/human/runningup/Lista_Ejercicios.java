package com.human.runningup;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.human.runningup.Adaptadores.AdaptadorEjercicios;
import com.human.runningup.Fragments.Ejercicio_Fragment;
import com.human.runningup.Objetos.Ejercicio;
import java.util.ArrayList;
import java.util.Iterator;

public class Lista_Ejercicios extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    AdaptadorEjercicios Adaptador;
    SearchView Buscador_Ejercicios;
    ArrayList<Ejercicio> ListaEjercicios;
    private DatabaseReference databaseReference;
    private String mParam1;
    private String mParam2;
    RecyclerView recyclerView;

    public static Lista_Ejercicios newInstance(String str, String str2) {
        Lista_Ejercicios lista_Ejercicios = new Lista_Ejercicios();
        Bundle bundle = new Bundle();
        bundle.putString(ARG_PARAM1, str);
        bundle.putString(ARG_PARAM2, str2);
        lista_Ejercicios.setArguments(bundle);
        return lista_Ejercicios;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.mParam1 = getArguments().getString(ARG_PARAM1);
            this.mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(C1308R.layout.fragment_lista__ejercicios, viewGroup, false);
        this.Buscador_Ejercicios = (SearchView) inflate.findViewById(C1308R.C1311id.SearchView_Ejercicios);
        this.databaseReference = FirebaseDatabase.getInstance().getReference("Ejercicio");
        this.recyclerView = (RecyclerView) inflate.findViewById(C1308R.C1311id.RecyclerView_Ejercicios);
        this.ListaEjercicios = new ArrayList<>();
        this.Buscador_Ejercicios.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            public boolean onQueryTextSubmit(String str) {
                return false;
            }

            public boolean onQueryTextChange(String str) {
                Lista_Ejercicios.this.filter(str);
                return false;
            }
        });
        CargarLista();
        MostrarLista();
        return inflate;
    }

    /* access modifiers changed from: private */
    public void filter(String str) {
        ArrayList arrayList = new ArrayList();
        Iterator<Ejercicio> it = this.ListaEjercicios.iterator();
        while (it.hasNext()) {
            Ejercicio next = it.next();
            if (next.getNombre().toLowerCase().contains(str.toLowerCase())) {
                arrayList.add(next);
            }
            this.Adaptador.filterlist(arrayList);
        }
    }

    public void CargarLista() {
        this.databaseReference.addValueEventListener(new ValueEventListener() {
            public void onCancelled(DatabaseError databaseError) {
            }

            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot value : dataSnapshot.getChildren()) {
                    Lista_Ejercicios.this.ListaEjercicios.add((Ejercicio) value.getValue(Ejercicio.class));
                }
                Lista_Ejercicios.this.Adaptador.notifyDataSetChanged();
            }
        });
    }

    public void MostrarLista() {
        this.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        AdaptadorEjercicios adaptadorEjercicios = new AdaptadorEjercicios(this.ListaEjercicios, getContext(), new AdaptadorEjercicios.OnItemClickListener() {
            public void onItemclick(Ejercicio ejercicio) {
                Lista_Ejercicios.this.moveToDescription(ejercicio);
            }
        });
        this.Adaptador = adaptadorEjercicios;
        this.recyclerView.setAdapter(adaptadorEjercicios);
    }

    public void moveToDescription(Ejercicio ejercicio) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("Ejercicio", ejercicio);
        Ejercicio_Fragment ejercicio_Fragment = new Ejercicio_Fragment();
        ejercicio_Fragment.setArguments(bundle);
        FragmentTransaction beginTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        beginTransaction.replace(C1308R.C1311id.Contenedor_Fragment, ejercicio_Fragment).commit();
        beginTransaction.addToBackStack((String) null);
    }
}
