package com.human.runningup.Adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.human.runningup.C1308R;
import com.human.runningup.Objetos.Usuario;
import java.util.ArrayList;

public class AdaptadorUsuarios extends RecyclerView.Adapter<ViewHolder> {
    private LayoutInflater Inflater;
    private ArrayList<Usuario> Lista;
    private Context context;

    public AdaptadorUsuarios(ArrayList<Usuario> arrayList, Context context2) {
        this.Inflater = LayoutInflater.from(context2);
        this.context = context2;
        this.Lista = arrayList;
    }

    public int getItemCount() {
        return this.Lista.size();
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(C1308R.layout.lista_comentarios, viewGroup, false));
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        viewHolder.bindData(this.Lista.get(i));
    }

    public void setItems(ArrayList<Usuario> arrayList) {
        this.Lista = arrayList;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView NombreUsuario;

        ViewHolder(View view) {
            super(view);
            this.NombreUsuario = (TextView) view.findViewById(C1308R.C1311id.Nombre_usuario_Comentario);
        }

        /* access modifiers changed from: package-private */
        public void bindData(Usuario usuario) {
            this.NombreUsuario.setText(usuario.getNombre());
        }
    }
}
