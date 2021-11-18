package com.example.a3er_examen_poblano.models;

public class Mochila {

    private String id;
    private String nombre;
    private String cost;
    private String foto;

    public Mochila(){}

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCost() {
        return cost;
    }

    public String getFoto() {
        return foto;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
}
