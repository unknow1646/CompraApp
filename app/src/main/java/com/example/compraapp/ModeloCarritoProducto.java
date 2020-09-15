package com.example.compraapp;

public class ModeloCarritoProducto {
    public int cli_rut;
    public int ven_rut;
    public String prod_nombre;

    public ModeloCarritoProducto(int cli_rut, int ven_rut, String prod_nombre) {

        this.cli_rut = cli_rut;
        this.ven_rut = ven_rut;
        this.prod_nombre = prod_nombre;
    }

    @Override
    public String toString() {
        return "ModeloCarritoProducto{" +
                "cli_rut=" + cli_rut +
                ", ven_rut=" + ven_rut +
                ", prod_nombre='" + prod_nombre + '\'' +
                '}';
    }

    public int getCli_rut() {
        return cli_rut;
    }

    public void setCli_rut(int cli_rut) {
        this.cli_rut = cli_rut;
    }

    public int getVen_rut() {
        return ven_rut;
    }

    public void setVen_rut(int ven_rut) {
        this.ven_rut = ven_rut;
    }

    public String getProd_nombre() {
        return prod_nombre;
    }

    public void setProd_nombre(String prod_nombre) {
        this.prod_nombre = prod_nombre;
    }
}
