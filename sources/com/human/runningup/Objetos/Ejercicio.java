package com.human.runningup.Objetos;

import java.io.Serializable;

public class Ejercicio implements Serializable {
    private String Categoria;
    private String Descripcion;

    /* renamed from: ID */
    private String f158ID;
    private String Imagen;
    private String Nombre;
    private int Tiempo;
    private String favStatus;

    public Ejercicio() {
    }

    public Ejercicio(String str, String str2, String str3, String str4, String str5, int i, String str6) {
        this.f158ID = str;
        this.Nombre = str2;
        this.Descripcion = str3;
        this.Imagen = str4;
        this.Categoria = str5;
        this.Tiempo = i;
        this.favStatus = str6;
    }

    public String getID() {
        return this.f158ID;
    }

    public void setID(String str) {
        this.f158ID = str;
    }

    public String getNombre() {
        return this.Nombre;
    }

    public void setNombre(String str) {
        this.Nombre = str;
    }

    public String getDescripcion() {
        return this.Descripcion;
    }

    public void setDescripcion(String str) {
        this.Descripcion = str;
    }

    public String getImagen() {
        return this.Imagen;
    }

    public void setImagen(String str) {
        this.Imagen = str;
    }

    public String getCategoria() {
        return this.Categoria;
    }

    public void setCategoria(String str) {
        this.Categoria = str;
    }

    public int getTiempo() {
        return this.Tiempo;
    }

    public void setTiempo(int i) {
        this.Tiempo = i;
    }

    public String getFavStatus() {
        return this.favStatus;
    }

    public void setFavStatus(String str) {
        this.favStatus = str;
    }
}
