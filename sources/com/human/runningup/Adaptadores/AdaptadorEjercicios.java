package com.human.runningup.Adaptadores;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.core.internal.view.SupportMenu;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.human.runningup.C1308R;
import com.human.runningup.DbHelper;
import com.human.runningup.Objetos.Ejercicio;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AdaptadorEjercicios extends RecyclerView.Adapter<ViewHolder> {
    private LayoutInflater Inflater;
    /* access modifiers changed from: private */
    public ArrayList<Ejercicio> Lista;
    private ArrayList<Ejercicio> ListaOriginal;
    /* access modifiers changed from: private */
    public Context context;
    /* access modifiers changed from: private */
    public DbHelper dbHelper;
    final OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemclick(Ejercicio ejercicio);
    }

    public AdaptadorEjercicios(ArrayList<Ejercicio> arrayList, Context context2, OnItemClickListener onItemClickListener) {
        this.Inflater = LayoutInflater.from(context2);
        this.context = context2;
        this.Lista = arrayList;
        this.listener = onItemClickListener;
        ArrayList<Ejercicio> arrayList2 = new ArrayList<>();
        this.ListaOriginal = arrayList2;
        arrayList2.addAll(arrayList);
    }

    public int getItemCount() {
        return this.Lista.size();
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        this.dbHelper = new DbHelper(this.context);
        if (this.context.getSharedPreferences("prefs", 0).getBoolean("firstStart", true)) {
            CREARTABLA();
        }
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(C1308R.layout.lista_ejercicios, viewGroup, false));
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        LeerCursor(this.Lista.get(i), viewHolder);
        viewHolder.cardView.setAnimation(AnimationUtils.loadAnimation(this.context, C1308R.anim.fade_transaccion));
        viewHolder.bindData(this.Lista.get(i));
    }

    public void setItems(ArrayList<Ejercicio> arrayList) {
        this.Lista = arrayList;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView Dificultad;
        ImageView ImagenEjercicio;
        TextView Nombre;
        TextView Tiempo;
        CardView cardView;
        Button favBtn;

        ViewHolder(View view) {
            super(view);
            this.ImagenEjercicio = (ImageView) view.findViewById(C1308R.C1311id.Card_imagen_Ejercicio);
            this.Nombre = (TextView) view.findViewById(C1308R.C1311id.Card_nombre_Ejercicio);
            this.Dificultad = (TextView) view.findViewById(C1308R.C1311id.Card_dificultad_Ejercicio);
            this.Tiempo = (TextView) view.findViewById(C1308R.C1311id.Card_Tiempo_Ejercicio);
            Button button = (Button) view.findViewById(C1308R.C1311id.favBtn);
            this.favBtn = button;
            button.setOnClickListener(new View.OnClickListener(AdaptadorEjercicios.this) {
                public void onClick(View view) {
                    Ejercicio ejercicio = (Ejercicio) AdaptadorEjercicios.this.Lista.get(ViewHolder.this.getAdapterPosition());
                    if (ejercicio.getFavStatus().equals("0")) {
                        ejercicio.setFavStatus("1");
                        AdaptadorEjercicios.this.dbHelper.insertIntoTheDatabase(ejercicio.getNombre(), ejercicio.getImagen(), ejercicio.getID(), ejercicio.getFavStatus(), ejercicio.getDescripcion(), ejercicio.getCategoria(), ejercicio.getTiempo());
                        ViewHolder.this.favBtn.setText("-");
                        ViewHolder.this.favBtn.setBackgroundColor(SupportMenu.CATEGORY_MASK);
                        return;
                    }
                    ejercicio.setFavStatus("0");
                    AdaptadorEjercicios.this.dbHelper.remove_fav(ejercicio.getID());
                    ViewHolder.this.favBtn.setText("+");
                    ViewHolder.this.favBtn.setBackgroundColor(-16711936);
                }
            });
            this.cardView = (CardView) view.findViewById(C1308R.C1311id.CardView_Ejercicios);
        }

        /* access modifiers changed from: package-private */
        public void bindData(final Ejercicio ejercicio) {
            this.Nombre.setText(ejercicio.getNombre());
            this.Dificultad.setText(ejercicio.getCategoria());
            Glide.with(AdaptadorEjercicios.this.context).load(ejercicio.getImagen()).into(this.ImagenEjercicio);
            this.Tiempo.setText(String.valueOf(ejercicio.getTiempo()));
            this.itemView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AdaptadorEjercicios.this.listener.onItemclick(ejercicio);
                }
            });
        }
    }

    private void LeerCursor(Ejercicio ejercicio, ViewHolder viewHolder) {
        Cursor LeertablaFav = this.dbHelper.LeertablaFav(ejercicio.getID());
        SQLiteDatabase readableDatabase = this.dbHelper.getReadableDatabase();
        while (LeertablaFav.moveToNext()) {
            String string = LeertablaFav.getString(LeertablaFav.getColumnIndex("fStatus"));
            ejercicio.setFavStatus(string);
            if (string != null && string.equals("1")) {
                viewHolder.favBtn.setText("-");
                viewHolder.favBtn.setBackgroundColor(SupportMenu.CATEGORY_MASK);
            } else if (string != null && string.equals("0")) {
                viewHolder.favBtn.setText("+");
                viewHolder.favBtn.setBackgroundColor(-16711936);
            }
        }
        readableDatabase.close();
    }

    public void Filtrado(String str) {
        if (str.length() == 0) {
            this.Lista.clear();
            this.Lista.addAll(this.ListaOriginal);
        } else {
            this.Lista.clear();
            this.Lista.addAll((List) this.ListaOriginal.stream().filter(new AdaptadorEjercicios$$ExternalSyntheticLambda0(str)).collect(Collectors.toList()));
        }
        notifyDataSetChanged();
    }

    public void filterlist(List<Ejercicio> list) {
        this.Lista = (ArrayList) list;
        notifyDataSetChanged();
    }

    private void CREARTABLA() {
        this.dbHelper.insertEmpty();
        SharedPreferences.Editor edit = this.context.getSharedPreferences("prefs", 0).edit();
        edit.putBoolean("firstStart", false);
        edit.apply();
    }
}
