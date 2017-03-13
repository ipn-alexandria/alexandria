package com.model.entities;

import javax.servlet.http.Part;

public class Material {
    
    private int idMaterial;
    private String nombreMaterial;
    private int idTema;
    private int nivelMaterial;
    private String direccionMaterial;
    private int filtroUno;
    private int filtroDos;
    private int visibilidadMaterial;
    private int tipoMaterial;
    private int idUsuario;
    private int idUa;
    private Part pdf;

    public Material() {
    }

    public int getIdMaterial() {
        return idMaterial;
    }

    public void setIdMaterial(int idMaterial) {
        this.idMaterial = idMaterial;
    }

    public String getNombreMaterial() {
        return nombreMaterial;
    }

    public void setNombreMaterial(String nombreMaterial) {
        this.nombreMaterial = nombreMaterial;
    }

    public int getIdTema() {
        return idTema;
    }

    public void setIdTema(int idTema) {
        this.idTema = idTema;
    }

    public int getNivelMaterial() {
        return nivelMaterial;
    }

    public void setNivelMaterial(int nivelMaterial) {
        this.nivelMaterial = nivelMaterial;
    }

    public String getDireccionMaterial() {
        return direccionMaterial;
    }

    public void setDireccionMaterial(String direccionMaterial) {
        this.direccionMaterial = direccionMaterial;
    }

    public int getFiltroUno() {
        return filtroUno;
    }

    public void setFiltroUno(int filtroUno) {
        this.filtroUno = filtroUno;
    }

    public int getFiltroDos() {
        return filtroDos;
    }

    public void setFiltroDos(int filtroDos) {
        this.filtroDos = filtroDos;
    }

    public int getVisibilidadMaterial() {
        return visibilidadMaterial;
    }

    public void setVisibilidadMaterial(int visibilidadMaterial) {
        this.visibilidadMaterial = visibilidadMaterial;
    }

    public int getTipoMaterial() {
        return tipoMaterial;
    }

    public void setTipoMaterial(int tipoMaterial) {
        this.tipoMaterial = tipoMaterial;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdUa() {
        return idUa;
    }

    public void setIdUa(int idUa) {
        this.idUa = idUa;
    }
    
    public Part getPdf() {
        return pdf;
    }

    public void setPdf(Part pdf) {
        this.pdf = pdf;
    }

    @Override
    public String toString() {
        return "Material{" + "idMaterial=" + idMaterial + ", nombreMaterial=" + nombreMaterial + ", idTema=" + idTema + ", nivelMaterial=" + nivelMaterial + ", direccionMaterial=" + direccionMaterial + ", filtroUno=" + filtroUno + ", filtroDos=" + filtroDos + ", visibilidadMaterial=" + visibilidadMaterial + ", tipoMaterial=" + tipoMaterial + ", idUsuario=" + idUsuario + ", idUa=" + idUa + '}';
    }
    
}
