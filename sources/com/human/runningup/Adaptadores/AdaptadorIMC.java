package com.human.runningup.Adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.human.runningup.C1308R;
import com.human.runningup.Objetos.IMC;
import java.util.ArrayList;

public class AdaptadorIMC extends RecyclerView.Adapter<ViewHolder> {
    private LayoutInflater Inflater;
    private ArrayList<IMC> Lista;
    private Context context;

    public AdaptadorIMC(ArrayList<IMC> arrayList, Context context2) {
        this.Inflater = LayoutInflater.from(context2);
        this.context = context2;
        this.Lista = arrayList;
    }

    public int getItemCount() {
        return this.Lista.size();
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ViewHolder(this.Inflater.inflate(C1308R.layout.lista_imc, (ViewGroup) null));
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        viewHolder.bindData(this.Lista.get(i));
    }

    public void setItems(ArrayList<IMC> arrayList) {
        this.Lista = arrayList;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView Altura;
        TextView Calificacion;
        TextView Fecha;
        TextView Peso;
        TextView ResultadoIMC;

        ViewHolder(View view) {
            super(view);
            this.Fecha = (TextView) view.findViewById(C1308R.C1311id.IMC_Fecha);
            this.ResultadoIMC = (TextView) view.findViewById(C1308R.C1311id.IMC_Resultado);
            this.Calificacion = (TextView) view.findViewById(C1308R.C1311id.IMC_Calificacion);
            this.Altura = (TextView) view.findViewById(C1308R.C1311id.IMC_Altura);
            this.Peso = (TextView) view.findViewById(C1308R.C1311id.IMC_Peso);
        }

        /* access modifiers changed from: package-private */
        public void bindData(IMC imc) {
            this.Fecha.setText(imc.getFecha());
            this.ResultadoIMC.setText(imc.getResultado());
            this.Calificacion.setText(imc.getCalificacion());
            this.Altura.setText(imc.getAltura());
            this.Peso.setText("" + imc.getPeso());
        }
    }
}
