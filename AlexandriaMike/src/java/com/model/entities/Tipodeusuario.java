package com.model.entities;

public class Tipodeusuario {
    
    private int idTipodeusuario;
    private String nombreTipodeusuario;

    public Tipodeusuario() {
    }

    public int getIdTipodeusuario() {
        return idTipodeusuario;
    }

    public void setIdTipodeusuario(int idTipodeusuario) {
        this.idTipodeusuario = idTipodeusuario;
    }

    public String getNombreTipodeusuario() {
        return nombreTipodeusuario;
    }

    public void setNombreTipodeusuario(String nombreTipodeusuario) {
        this.nombreTipodeusuario = nombreTipodeusuario;
    }

    @Override
    public String toString() {
        return "Tipodeusuario{" + "idTipodeusuario=" + idTipodeusuario + ", nombreTipodeusuario=" + nombreTipodeusuario + '}';
    }
    
}
