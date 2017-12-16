package com.example.moraga.ev4vmoragaptenorio.ModulosBdd;


public class Clientes {
    private int id;
    private String rut;
    private String nombreCliente;
    private String apepat;
    private String apemat;
    private int telefonoCliente;
    private String emailCliente;
    private String fechaCliente;
    private String estado;
    private int ciudadidC;

    public Clientes(String rut, String nombreCliente, String apepat, String apemat, int telefonoCliente, String emailCliente, String fechaCliente, int ciudadidC, String estado) {
        this.rut = rut;
        this.nombreCliente = nombreCliente;
        this.apepat = apepat;
        this.apemat = apemat;
        this.telefonoCliente = telefonoCliente;
        this.emailCliente = emailCliente;
        this.fechaCliente = fechaCliente;
        this.ciudadidC = ciudadidC;
        this.estado = estado;
    }

    public String getRut() {
        return rut;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public String getApepat() {
        return apepat;
    }

    public String getApemat() {
        return apemat;
    }

    public int getTelefonoCliente() {
        return telefonoCliente;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public String getFechaCliente() {
        return fechaCliente;
    }

    public String getEstado() {
        return estado;
    }

    public int getCiudadidC() {
        return ciudadidC;
    }

    @Override
    public String toString() {
        return "Clientes " +
                "rut: " + rut +
                ", Nombre: " + nombreCliente +
                ", Apellido Paterno: " + apepat +
                ", Apellido Materno: " + apemat +
                ", Telefono: " + telefonoCliente +
                ", Email: " + emailCliente  +
                ", Fecha de Creacion: " + fechaCliente;
    }
}