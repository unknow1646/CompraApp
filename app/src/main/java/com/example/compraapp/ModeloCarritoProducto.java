package com.example.compraapp;

public class ModeloCarritoProducto {
    public int cli_rut;
    public int ven_rut;
    public int prod_codigo;

    public ModeloCarritoProducto(int cli_rut, int ven_rut, int prod_codigo) {
        this.cli_rut = cli_rut;
        this.ven_rut = ven_rut;
        this.prod_codigo = prod_codigo;
    }

    @Override
    public String toString() {
        return "ModeloCarritoProducto{" +
                "cli_rut=" + cli_rut +
                ", ven_rut=" + ven_rut +
                ", prod_codigo=" + prod_codigo +
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

    public int getProd_codigo() {
        return prod_codigo;
    }

    public void setProd_codigo(int prod_codigo) {
        this.prod_codigo = prod_codigo;
    }
}



