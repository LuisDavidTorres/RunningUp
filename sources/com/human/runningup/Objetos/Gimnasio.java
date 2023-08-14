package com.human.runningup.Objetos;

import java.io.Serializable;

public class Gimnasio implements Serializable {
    private long Calificacion;
    private String Correo;
    private String Descripcion;
    private String Direccion;
    private String Horario;

    /* renamed from: ID */
    private String f160ID;
    private String ImagenURL;
    private float Latitud;
    private float Longitud;
    private String Nombre;
    private int Precio;
    private String Telefono;

    public Gimnasio() {
    }

    public Gimnasio(String str, String str2, String str3, int i, String str4, String str5, String str6, String str7, String str8, long j) {
        this.f160ID = str;
        this.Nombre = str2;
        this.ImagenURL = str3;
        this.Precio = i;
        this.Direccion = str4;
        this.Correo = str5;
        this.Telefono = str6;
        this.Descripcion = str7;
        this.Horario = str8;
        this.Calificacion = j;
    }

    public String getID() {
        return this.f160ID;
    }

    public void setID(String str) {
        this.f160ID = str;
    }

    public String getNombre() {
        return this.Nombre;
    }

    public void setNombre(String str) {
        this.Nombre = str;
    }

    public String getTelefono() {
        return this.Telefono;
    }

    public void setTelefono(String str) {
        this.Telefono = str;
    }

    public String getCorreo() {
        return this.Correo;
    }

    public void setCorreo(String str) {
        this.Correo = str;
    }

    public String getDireccion() {
        return this.Direccion;
    }

    public void setDireccion(String str) {
        this.Direccion = str;
    }

    public String getDescripcion() {
        return this.Descripcion;
    }

    public void setDescripcion(String str) {
        this.Descripcion = str;
    }

    public float getLatitud() {
        return this.Latitud;
    }

    public void setLatitud(float f) {
        this.Latitud = f;
    }

    public float getLongitud() {
        return this.Longitud;
    }

    public void setLongitud(float f) {
        this.Longitud = f;
    }

    public long getCalificacion() {
        return this.Calificacion;
    }

    public void setCalificacion(int i) {
        this.Calificacion = (long) i;
    }

    public float getPrecio() {
        return (float) this.Precio;
    }

    public void setPrecio(int i) {
        this.Precio = i;
    }

    public String getImagen() {
        return this.ImagenURL;
    }

    public void setImagen(String str) {
        this.ImagenURL = str;
    }

    public String getHorario() {
        return this.Horario;
    }

    public void setHorario(String str) {
        this.Horario = str;
    }
}
