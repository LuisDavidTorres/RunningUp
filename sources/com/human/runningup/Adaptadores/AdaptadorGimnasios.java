package com.human.runningup.Adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.human.runningup.C1308R;
import com.human.runningup.Objetos.Gimnasio;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AdaptadorGimnasios extends RecyclerView.Adapter<ViewHolder> {
    private LayoutInflater Inflater;
    private ArrayList<Gimnasio> Lista;
    private ArrayList<Gimnasio> ListaOriginal;
    /* access modifiers changed from: private */
    public Context context;
    final OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemclick(Gimnasio gimnasio);
    }

    public AdaptadorGimnasios(ArrayList<Gimnasio> arrayList, Context context2, OnItemClickListener onItemClickListener) {
        this.Inflater = LayoutInflater.from(context2);
        this.Lista = arrayList;
        this.context = context2;
        this.listener = onItemClickListener;
        ArrayList<Gimnasio> arrayList2 = new ArrayList<>();
        this.ListaOriginal = arrayList2;
        arrayList2.addAll(arrayList);
    }

    public int getItemCount() {
        return this.Lista.size();
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ViewHolder(this.Inflater.inflate(C1308R.layout.lista_gimnasios, (ViewGroup) null));
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        viewHolder.bindData(this.Lista.get(i));
    }

    public void setItems(ArrayList<Gimnasio> arrayList) {
        this.Lista = arrayList;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView Horario;
        ImageView ImagenGimnasio;
        TextView Nombre;

        ViewHolder(View view) {
            super(view);
            this.ImagenGimnasio = (ImageView) view.findViewById(C1308R.C1311id.Card_imagen_Gimnasio);
            this.Nombre = (TextView) view.findViewById(C1308R.C1311id.Card_nombre_Gimnasio);
            this.Horario = (TextView) view.findViewById(C1308R.C1311id.Card_Horario_Gimnasio);
        }

        /* access modifiers changed from: package-private */
        public void bindData(final Gimnasio gimnasio) {
            Glide.with(AdaptadorGimnasios.this.context).load(gimnasio.getImagen()).into(this.ImagenGimnasio);
            this.Nombre.setText(gimnasio.getNombre());
            this.Horario.setText(gimnasio.getHorario());
            this.itemView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AdaptadorGimnasios.this.listener.onItemclick(gimnasio);
                }
            });
        }
    }

    public void Filtrado(String str) {
        if (str.length() == 0) {
            this.Lista.clear();
            this.Lista.addAll(this.ListaOriginal);
        } else {
            this.Lista.clear();
            this.Lista.addAll((List) this.Lista.stream().filter(new AdaptadorGimnasios$$ExternalSyntheticLambda0(str)).collect(Collectors.toList()));
        }
        notifyDataSetChanged();
    }

    public void filterlist(List<Gimnasio> list) {
        this.Lista = (ArrayList) list;
        notifyDataSetChanged();
    }
}
