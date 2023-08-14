package com.human.runningup.Adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.human.runningup.C1308R;
import com.human.runningup.Objetos.Comentario;
import java.util.ArrayList;

public class AdaptadorComentarios extends RecyclerView.Adapter<ViewHolder> {
    private LayoutInflater Inflater;
    private ArrayList<Comentario> Lista;
    /* access modifiers changed from: private */
    public Context context;

    public AdaptadorComentarios(ArrayList<Comentario> arrayList, Context context2) {
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

    public void setItems(ArrayList<Comentario> arrayList) {
        this.Lista = arrayList;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        RatingBar Calificacion;
        TextView Descripcion;
        TextView Fecha;
        ImageView ImagenUsuarioComentario;
        TextView NombreUsuario;

        ViewHolder(View view) {
            super(view);
            this.Descripcion = (TextView) view.findViewById(C1308R.C1311id.Comentario_Usuario_R);
            this.Calificacion = (RatingBar) view.findViewById(C1308R.C1311id.RatingBar_Calificacion_Cometario);
            this.Fecha = (TextView) view.findViewById(C1308R.C1311id.Fecha_comentario);
            this.NombreUsuario = (TextView) view.findViewById(C1308R.C1311id.Nombre_usuario_Comentario);
            this.ImagenUsuarioComentario = (ImageView) view.findViewById(C1308R.C1311id.Imagen_perfil_Comentario);
        }

        /* access modifiers changed from: package-private */
        public void bindData(Comentario comentario) {
            this.Descripcion.setText(comentario.getDescripcion());
            this.Calificacion.setRating((float) comentario.getCalificaion());
            this.Fecha.setText(comentario.getFecha());
            this.NombreUsuario.setText(comentario.getUsuario().getNombre());
            Glide.with(AdaptadorComentarios.this.context).load(comentario.getUsuario().getImagen()).into(this.ImagenUsuarioComentario);
        }
    }
}
