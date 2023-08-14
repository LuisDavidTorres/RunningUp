package com.human.runningup.Adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.human.runningup.C1308R;
import com.human.runningup.Objetos.Recorrido;
import java.util.ArrayList;

public class AdaptadorRecorrido extends RecyclerView.Adapter<ViewHolder> {
    private LayoutInflater Inflater;
    private ArrayList<Recorrido> Lista;
    private Context context;

    public AdaptadorRecorrido(ArrayList<Recorrido> arrayList, Context context2) {
        this.Inflater = LayoutInflater.from(context2);
        this.context = context2;
        this.Lista = arrayList;
    }

    public int getItemCount() {
        return this.Lista.size();
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ViewHolder(this.Inflater.inflate(C1308R.layout.lista_recorridos, (ViewGroup) null));
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        viewHolder.bindData(this.Lista.get(i));
    }

    public void setItems(ArrayList<Recorrido> arrayList) {
        this.Lista = arrayList;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView Fecha;
        TextView Kilometros;
        TextView Tiempo;

        ViewHolder(View view) {
            super(view);
            this.Tiempo = (TextView) view.findViewById(C1308R.C1311id.Card_Tiempo_Recorrido);
            this.Fecha = (TextView) view.findViewById(C1308R.C1311id.Card_Fecha_Recorrido);
            this.Kilometros = (TextView) view.findViewById(C1308R.C1311id.Card_Kilometros_Recorrido);
        }

        /* access modifiers changed from: package-private */
        public void bindData(Recorrido recorrido) {
            this.Kilometros.setText(recorrido.getKilometros());
            this.Fecha.setText(recorrido.getFecha());
            this.Tiempo.setText(recorrido.getTiempo());
        }
    }
}
