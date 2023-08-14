package com.human.runningup;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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
import com.human.runningup.Adaptadores.AdaptadorGimnasios;
import com.human.runningup.Fragments.Gimnasio_Fragment;
import com.human.runningup.Objetos.Gimnasio;
import java.util.ArrayList;
import java.util.Iterator;

public class Lista_Gimnasios extends Fragment {
    AdaptadorGimnasios Adaptador;
    ImageView IMAGEN;
    ArrayList<Gimnasio> ListaGimnasios;
    SearchView buscador_gimnasios;
    private DatabaseReference databaseReference;
    RecyclerView recyclerView;

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(C1308R.layout.fragment_lista__gimnasios, viewGroup, false);
        this.buscador_gimnasios = (SearchView) inflate.findViewById(C1308R.C1311id.SearchView_gimnasios);
        this.databaseReference = FirebaseDatabase.getInstance().getReference("Gimnasio");
        this.IMAGEN = (ImageView) inflate.findViewById(C1308R.C1311id.Card_imagen_Gimnasio);
        this.buscador_gimnasios.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            public boolean onQueryTextSubmit(String str) {
                return false;
            }

            public boolean onQueryTextChange(String str) {
                Lista_Gimnasios.this.filter(str);
                return false;
            }
        });
        this.recyclerView = (RecyclerView) inflate.findViewById(C1308R.C1311id.RecyclerView_Gimnasios);
        this.ListaGimnasios = new ArrayList<>();
        CargarLista();
        MostrarData();
        return inflate;
    }

    /* access modifiers changed from: private */
    public void filter(String str) {
        ArrayList arrayList = new ArrayList();
        Iterator<Gimnasio> it = this.ListaGimnasios.iterator();
        while (it.hasNext()) {
            Gimnasio next = it.next();
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
                    Lista_Gimnasios.this.ListaGimnasios.add((Gimnasio) value.getValue(Gimnasio.class));
                }
                Lista_Gimnasios.this.Adaptador.notifyDataSetChanged();
            }
        });
    }

    public void MostrarData() {
        this.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        AdaptadorGimnasios adaptadorGimnasios = new AdaptadorGimnasios(this.ListaGimnasios, getContext(), new AdaptadorGimnasios.OnItemClickListener() {
            public void onItemclick(Gimnasio gimnasio) {
                Lista_Gimnasios.this.moveToDescripction(gimnasio);
            }
        });
        this.Adaptador = adaptadorGimnasios;
        this.recyclerView.setAdapter(adaptadorGimnasios);
    }

    public void moveToDescripction(Gimnasio gimnasio) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("Gimnasio", gimnasio);
        Gimnasio_Fragment gimnasio_Fragment = new Gimnasio_Fragment();
        gimnasio_Fragment.setArguments(bundle);
        FragmentTransaction beginTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        beginTransaction.replace(C1308R.C1311id.Contenedor_Fragment, gimnasio_Fragment).commit();
        beginTransaction.addToBackStack((String) null);
    }
}
