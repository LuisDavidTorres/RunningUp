package com.human.runningup;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.human.runningup.Adaptadores.AdaptadorEjerciciosFavoritos;
import com.human.runningup.Fragments.Ejercicio_Fragment;
import com.human.runningup.Objetos.Ejercicio;
import java.util.ArrayList;
import java.util.Iterator;

public class Lista_Ejercicios_Favoritos extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    AdaptadorEjerciciosFavoritos Adaptador;
    ArrayList<Ejercicio> ListaEjerciciosFavoritos;
    DbHelper dbHelper;
    private String mParam1;
    private String mParam2;
    RecyclerView recyclerView;
    SearchView searchView;

    public static Lista_Ejercicios_Favoritos newInstance(String str, String str2) {
        Lista_Ejercicios_Favoritos lista_Ejercicios_Favoritos = new Lista_Ejercicios_Favoritos();
        Bundle bundle = new Bundle();
        bundle.putString(ARG_PARAM1, str);
        bundle.putString(ARG_PARAM2, str2);
        lista_Ejercicios_Favoritos.setArguments(bundle);
        return lista_Ejercicios_Favoritos;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.mParam1 = getArguments().getString(ARG_PARAM1);
            this.mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(C1308R.layout.fragment_lista__ejercicios__favoritos, viewGroup, false);
        this.dbHelper = new DbHelper(getActivity());
        this.recyclerView = (RecyclerView) inflate.findViewById(C1308R.C1311id.RecyclerView_Ejercicios_Favoritos);
        this.searchView = (SearchView) inflate.findViewById(C1308R.C1311id.SearchView_Ejercicios_Favoritos);
        this.ListaEjerciciosFavoritos = new ArrayList<>();
        CargarLista();
        MostrarLista();
        this.searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            public boolean onQueryTextSubmit(String str) {
                return false;
            }

            public boolean onQueryTextChange(String str) {
                Lista_Ejercicios_Favoritos.this.filter(str);
                return false;
            }
        });
        return inflate;
    }

    private void CargarLista() {
        SQLiteDatabase readableDatabase = this.dbHelper.getReadableDatabase();
        Cursor select_favoritos_list = this.dbHelper.select_favoritos_list();
        if (select_favoritos_list.moveToLast()) {
            do {
                Ejercicio ejercicio = new Ejercicio();
                ejercicio.setID(select_favoritos_list.getString(0));
                ejercicio.setNombre(select_favoritos_list.getString(1));
                ejercicio.setCategoria(select_favoritos_list.getString(2));
                ejercicio.setTiempo(select_favoritos_list.getInt(3));
                ejercicio.setImagen(select_favoritos_list.getString(4));
                ejercicio.setDescripcion(select_favoritos_list.getString(6));
                this.ListaEjerciciosFavoritos.add(ejercicio);
            } while (select_favoritos_list.moveToPrevious());
        }
        readableDatabase.close();
    }

    public void MostrarLista() {
        this.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        AdaptadorEjerciciosFavoritos adaptadorEjerciciosFavoritos = new AdaptadorEjerciciosFavoritos(this.ListaEjerciciosFavoritos, getContext(), new AdaptadorEjerciciosFavoritos.OnItemClickListener() {
            public void onItemclick(Ejercicio ejercicio) {
                Lista_Ejercicios_Favoritos.this.moveToDescription(ejercicio);
            }
        });
        this.Adaptador = adaptadorEjerciciosFavoritos;
        this.recyclerView.setAdapter(adaptadorEjerciciosFavoritos);
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

    /* access modifiers changed from: private */
    public void filter(String str) {
        ArrayList arrayList = new ArrayList();
        Iterator<Ejercicio> it = this.ListaEjerciciosFavoritos.iterator();
        while (it.hasNext()) {
            Ejercicio next = it.next();
            if (next.getNombre().toLowerCase().contains(str.toLowerCase())) {
                arrayList.add(next);
            }
            this.Adaptador.filterlist(arrayList);
        }
    }
}
