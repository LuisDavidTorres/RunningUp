package com.human.runningup.Objetos;

public class Usuario {

    /* renamed from: Contraseña  reason: contains not printable characters */
    private String f200Contrasea;
    private String Correo;
    private String Imagen;
    private String Nombre;

    public Usuario() {
    }

    public Usuario(String str, String str2, String str3, String str4) {
        this.Nombre = str;
        this.Correo = str2;
        this.f200Contrasea = str3;
        this.Imagen = str4;
    }

    public String getNombre() {
        return this.Nombre;
    }

    public void setNombre(String str) {
        this.Nombre = str;
    }

    public String getCorreo() {
        return this.Correo;
    }

    public void setCorreo(String str) {
        this.Correo = str;
    }

    /* renamed from: getContraseña  reason: contains not printable characters */
    public String m58getContrasea() {
        return this.f200Contrasea;
    }

    /* renamed from: setContraseña  reason: contains not printable characters */
    public void m59setContrasea(String str) {
        this.f200Contrasea = str;
    }

    public String getImagen() {
        return this.Imagen;
    }

    public void setImagen(String str) {
        this.Imagen = str;
    }
}
