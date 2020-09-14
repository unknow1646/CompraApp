package com.example.compraapp;

public class ModeloPersona {
    public int per_rut;
    public String per_nombre;
    public String per_apellido;
    public int per_telefono;


    public ModeloPersona(int per_rut, String per_nombre, String per_apellido, int per_telefono) {
        this.per_rut = per_rut;
        this.per_nombre = per_nombre;
        this.per_apellido = per_apellido;
        this.per_telefono = per_telefono;
    }

    public ModeloPersona(){}

    @Override
    public String toString() {
        return "ModeloPersona{" +
                "per_rut=" + per_rut +
                ", per_nombre='" + per_nombre + '\'' +
                ", per_apellido='" + per_apellido + '\'' +
                ", per_telefono=" + per_telefono +
                '}';
    }

    public int getper_rut() {
        return per_rut;
    }

    public void setper_rut(int per_rut) {
        this.per_rut = per_rut;
    }

    public String getper_nombre() {
        return per_nombre;
    }

    public void setper_nombre(String per_nombre) {
        this.per_nombre = per_nombre;
    }

    public String getper_Apellido() {
        return per_apellido;
    }

    public void setper_Apellido(String per_apellido) {
        this.per_apellido = per_apellido;
    }

    public int getper_Telefono() {
        return per_telefono;
    }

    public void setper_Telefono(int per_telefono) {
        this.per_telefono = per_telefono;
    }
}
