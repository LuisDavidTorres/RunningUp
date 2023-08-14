package com.human.runningup;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.human.runningup.Adaptadores.AdaptadorIMC;
import com.human.runningup.Objetos.IMC;
import java.util.ArrayList;

public class Listado_IMC extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    ArrayList<IMC> ListaIMC = new ArrayList<>();
    RecyclerView Recycler_IMC;
    private FirebaseUser User;
    SQLiteDatabase database;
    DbHelper dbHelper;
    private FirebaseAuth firebaseAuth;
    private String mParam1;
    private String mParam2;

    public static Listado_IMC newInstance(String str, String str2) {
        Listado_IMC listado_IMC = new Listado_IMC();
        Bundle bundle = new Bundle();
        bundle.putString(ARG_PARAM1, str);
        bundle.putString(ARG_PARAM2, str2);
        listado_IMC.setArguments(bundle);
        return listado_IMC;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.mParam1 = getArguments().getString(ARG_PARAM1);
            this.mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(C1308R.layout.fragment_listado__i_m_c, viewGroup, false);
        AdaptadorIMC adaptadorIMC = new AdaptadorIMC(this.ListaIMC, getContext());
        RecyclerView recyclerView = (RecyclerView) inflate.findViewById(C1308R.C1311id.RecyclerView_IMC);
        this.Recycler_IMC = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        ActualizarLista(FirebaseAuth.getInstance().getCurrentUser().getUid());
        this.Recycler_IMC.setAdapter(adaptadorIMC);
        FirebaseAuth instance = FirebaseAuth.getInstance();
        this.firebaseAuth = instance;
        this.User = instance.getCurrentUser();
        return inflate;
    }

    public void ActualizarLista(String str) {
        DbHelper dbHelper2 = new DbHelper(getActivity());
        this.dbHelper = dbHelper2;
        SQLiteDatabase writableDatabase = dbHelper2.getWritableDatabase();
        this.database = writableDatabase;
        Cursor rawQuery = writableDatabase.rawQuery("SELECT * FROM IMC WHERE ID_USUARIO ='" + str + "'", (String[]) null);
        if (rawQuery.moveToLast()) {
            do {
                IMC imc = new IMC();
                imc.setID(rawQuery.getInt(0));
                imc.setFecha(rawQuery.getString(1));
                imc.setCalificacion(rawQuery.getString(2));
                imc.setAltura(rawQuery.getString(3));
                imc.setPeso(rawQuery.getInt(4));
                imc.setEvaluacion(rawQuery.getString(5));
                this.ListaIMC.add(imc);
            } while (rawQuery.moveToPrevious());
        }
        this.database.close();
    }
}
