package com.example.moraga.ev4vmoragaptenorio.ModulosBdd;


public class Ciudades {
    private int id;
    private String nombreCiudad;
    private String region;
    private String estado;

    public Ciudades(String nombreCiudad, String region, String estado) {
        this.nombreCiudad = nombreCiudad;
        this.region = region;
        this.estado = estado;
    }

    public String getNombreCiudad() {
        return nombreCiudad;
    }

    public String getRegion() {
        return region;
    }

    public String getEstado() {
        return estado;
    }

    @Override
    public String toString() {
        return "Ciudad: " + nombreCiudad +
                " Region: " + region;
    }
}