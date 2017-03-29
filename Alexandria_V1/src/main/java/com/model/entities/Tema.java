package com.model.entities;

public class Tema {
    
    private int idTema;
    private int idUA;
    private String nombretema;

    public Tema() {
    }

    public int getIdTema() {
        return idTema;
    }

    public void setIdTema(int idTema) {
        this.idTema = idTema;
    }

    public int getIdUA() {
        return idUA;
    }

    public void setIdUA(int idUA) {
        this.idUA = idUA;
    }

    public String getNombretema() {
        return nombretema;
    }

    public void setNombretema(String nombretema) {
        this.nombretema = nombretema;
    }

    @Override
    public String toString() {
        return "Tema{" + "idTema=" + idTema + ", idUA=" + idUA + ", nombretema=" + nombretema + '}';
    }
    
}
