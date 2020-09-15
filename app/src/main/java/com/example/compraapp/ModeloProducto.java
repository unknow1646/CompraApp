package com.example.compraapp;

public class ModeloProducto {
    public int ven_rut;
    public String prod_nombre;
    public int prod_stock;
    public String prod_tipo;
    public int prod_precio;

    public ModeloProducto(int ven_rut, String prod_nombre, int prod_stock, String prod_tipo, int prod_precio) {
        this.ven_rut = ven_rut;
        this.prod_nombre = prod_nombre;
        this.prod_stock = prod_stock;
        this.prod_tipo = prod_tipo;
        this.prod_precio = prod_precio;
    }

    @Override
    public String toString() {
        return "ModeloProducto{" +
                "ven_rut=" + ven_rut +
                ", prod_nombre='" + prod_nombre + '\'' +
                ", prod_stock=" + prod_stock +
                ", prod_tipo='" + prod_tipo + '\'' +
                ", prod_precio=" + prod_precio +
                '}';
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

    public int getProd_stock() {
        return prod_stock;
    }

    public void setProd_stock(int prod_stock) {
        this.prod_stock = prod_stock;
    }

    public String getProd_tipo() {
        return prod_tipo;
    }

    public void setProd_tipo(String prod_tipo) {
        this.prod_tipo = prod_tipo;
    }

    public int getProd_precio() {
        return prod_precio;
    }

    public void setProd_precio(int prod_precio) {
        this.prod_precio = prod_precio;
    }
}
