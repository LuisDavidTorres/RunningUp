package com.human.runningup.Adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.human.runningup.C1308R;
import com.human.runningup.DbHelper;
import com.human.runningup.Objetos.Ejercicio;
import java.util.ArrayList;
import java.util.List;

public class AdaptadorEjerciciosFavoritos extends RecyclerView.Adapter<ViewHolder> {
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

    public void filterlist(List<Ejercicio> list) {
        this.Lista = (ArrayList) list;
        notifyDataSetChanged();
    }

    public AdaptadorEjerciciosFavoritos(ArrayList<Ejercicio> arrayList, Context context2, OnItemClickListener onItemClickListener) {
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
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(C1308R.layout.lista_ejercicios_favoritos, viewGroup, false));
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        Ejercicio ejercicio = this.Lista.get(i);
        this.dbHelper = new DbHelper(this.context);
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
            this.ImagenEjercicio = (ImageView) view.findViewById(C1308R.C1311id.Card_imagen_Ejercicio_Favorito);
            this.Nombre = (TextView) view.findViewById(C1308R.C1311id.Card_nombre_Ejercicio_Favorito);
            this.Dificultad = (TextView) view.findViewById(C1308R.C1311id.Card_dificultad_Ejercicio_Favorito);
            this.Tiempo = (TextView) view.findViewById(C1308R.C1311id.Card_Tiempo_Ejercicio_Favorito);
            Button button = (Button) view.findViewById(C1308R.C1311id.favBtn_F);
            this.favBtn = button;
            button.setOnClickListener(new View.OnClickListener(AdaptadorEjerciciosFavoritos.this) {
                public void onClick(View view) {
                    int adapterPosition = ViewHolder.this.getAdapterPosition();
                    AdaptadorEjerciciosFavoritos.this.dbHelper.remove_fav(((Ejercicio) AdaptadorEjerciciosFavoritos.this.Lista.get(adapterPosition)).getID());
                    AdaptadorEjerciciosFavoritos.this.removeitem(adapterPosition);
                }
            });
            this.cardView = (CardView) view.findViewById(C1308R.C1311id.CardView_Ejercicios);
        }

        /* access modifiers changed from: package-private */
        public void bindData(final Ejercicio ejercicio) {
            this.Nombre.setText(ejercicio.getNombre());
            this.Dificultad.setText(ejercicio.getCategoria());
            Glide.with(AdaptadorEjerciciosFavoritos.this.context).load(ejercicio.getImagen()).into(this.ImagenEjercicio);
            this.Tiempo.setText(String.valueOf(ejercicio.getTiempo()));
            this.itemView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AdaptadorEjerciciosFavoritos.this.listener.onItemclick(ejercicio);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void removeitem(int i) {
        this.Lista.remove(i);
        notifyItemRemoved(i);
        notifyItemRangeChanged(i, this.Lista.size());
    }
}
