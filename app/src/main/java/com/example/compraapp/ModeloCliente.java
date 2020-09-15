package com.example.compraapp;

public class ModeloCliente extends ModeloPersona {
    private int cli_rut;
    private String cli_direccion;

    public ModeloCliente(int per_rut, String per_nombre, String per_apellido, int per_telefono, int cli_rut, String cli_direccion) {
        super(per_rut, per_nombre, per_apellido, per_telefono);
        this.cli_rut = cli_rut;
        this.cli_direccion = cli_direccion;
    }

    @Override
    public String toString() {
        return "ModeloCliente{" +
                "cli_rut=" + cli_rut +
                ", cli_direccion='" + cli_direccion + '\'' +
                ", per_rut=" + per_rut +
                ", per_nombre='" + per_nombre + '\'' +
                ", per_apellido='" + per_apellido + '\'' +
                ", per_telefono=" + per_telefono +
                '}';
    }

    public int getCli_rut() {
        return cli_rut;
    }

    public void setCli_rut(int cli_rut) {
        this.cli_rut = cli_rut;
    }

    public String getCli_direccion() {
        return cli_direccion;
    }

    public void setCli_direccion(String cli_direccion) {
        this.cli_direccion = cli_direccion;
    }
}
