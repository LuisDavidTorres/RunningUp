package com.human.runningup.Objetos;

public class Comentario {
    private int Calificacion;
    private String Descripcion;
    private String Fecha;
    private Usuario usuario;

    public Comentario() {
    }

    public Comentario(Usuario usuario2, String str, int i, String str2) {
        this.Descripcion = str;
        this.Calificacion = i;
        this.Fecha = str2;
        this.usuario = usuario2;
    }

    public String getDescripcion() {
        return this.Descripcion;
    }

    public void setDescripcion(String str) {
        this.Descripcion = str;
    }

    public String getFecha() {
        return this.Fecha;
    }

    public void setFecha(String str) {
        this.Fecha = str;
    }

    public int getCalificaion() {
        return this.Calificacion;
    }

    public void setCalificaion(int i) {
        this.Calificacion = i;
    }

    public Usuario getUsuario() {
        return this.usuario;
    }

    public void setUsuario(Usuario usuario2) {
        this.usuario = usuario2;
    }
}
