package com.example.moraga.ev4vmoragaptenorio.ModulosBdd;


public class Direcciones {
    private int id;
    private String nombreCalle;
    private int numeroCalle;
    private String fechaCliente;
    private String estado;
    private int localidD;

    public Direcciones(String nombreCalle, int numeroCalle, String fechaCliente, int localidD, String estado) {
        this.nombreCalle = nombreCalle;
        this.numeroCalle = numeroCalle;
        this.fechaCliente = fechaCliente;
        this.localidD = localidD;
        this.estado = estado;
    }

    public void setLocalidD(int localidD) {
        this.localidD = localidD;
    }

    public String getNombreCalle() {
        return nombreCalle;
    }

    public int getNumeroCalle() {
        return numeroCalle;
    }

    public String getFechaCliente() {
        return fechaCliente;
    }

    public String getEstado() {
        return estado;
    }

    public int getLocalidD() {
        return localidD;
    }

    @Override
    public String toString() {
        return "Direcciones " +
                "Calle: " + nombreCalle +
                " #" + numeroCalle +
                ", Fecha de Creacion: " + fechaCliente;
    }
}