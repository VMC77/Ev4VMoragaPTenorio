package com.example.moraga.ev4vmoragaptenorio.ModulosBdd;


public class Locales {
    private int id;
    private String nombreLocal;
    private int telefonoLocal;
    private String emailLocal;
    private String direccion;
    private String fechaLocal;
    private String estado;
    private int ciudadidL;
    private int fotoId;

    public Locales(){
    }
    public Locales(int idb) {
        this.id=idb;
    }
    public Locales(String nombreLocal, int telefonoLocal, String emailLocal, String direccion, String fechaLocal, String estado, int ciudadidL, int fotoId) {
        this.nombreLocal = nombreLocal;
        this.telefonoLocal = telefonoLocal;
        this.emailLocal = emailLocal;
        this.direccion = direccion;
        this.fechaLocal = fechaLocal;
        this.estado = estado;
        this.ciudadidL = ciudadidL;
        this.fotoId=fotoId;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getNombreLocal() {
        return nombreLocal;
    }

    public int getTelefonoLocal() {
        return telefonoLocal;
    }

    public String getEmailLocal() {
        return emailLocal;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getFechaLocal() {
        return fechaLocal;
    }

    public String getEstado() {
        return estado;
    }

    public int getCiudadidL() {
        return ciudadidL;
    }

    public int getFotoId() {
        return fotoId;
    }

    @Override
    public String toString() {
        return "Local: " + nombreLocal +
                " - Telefono: " + telefonoLocal +
                " - Email: " + emailLocal;
    }
    public String toString2(){
        return ""+id;
    }
}