package com.human.runningup.Objetos;

public class Recorrido {
    private String Fecha;
    private String Kilometros;
    private String Tiempo;

    public Recorrido() {
    }

    public Recorrido(String str, String str2, String str3) {
        this.Fecha = str;
        this.Kilometros = str2;
        this.Tiempo = str3;
    }

    public String getFecha() {
        return this.Fecha;
    }

    public void setFecha(String str) {
        this.Fecha = str;
    }

    public String getKilometros() {
        return this.Kilometros;
    }

    public void setKilometros(String str) {
        this.Kilometros = str;
    }

    public String getTiempo() {
        return this.Tiempo;
    }

    public void setTiempo(String str) {
        this.Tiempo = str;
    }
}
