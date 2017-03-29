package com.model.entities;

public class Ua {
    
    private int idUA;
    private String nombreUA;
    private int nivel;

    public Ua() {
    }

    public int getIdUA() {
        return idUA;
    }

    public void setIdUA(int idUA) {
        this.idUA = idUA;
    }

    public String getNombreUA() {
        return nombreUA;
    }

    public void setNombreUA(String nombreUA) {
        this.nombreUA = nombreUA;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    @Override
    public String toString() {
        return "Ua{" + "idUA=" + idUA + ", nombreUA=" + nombreUA + ", nivel=" + nivel + '}';
    }

}
