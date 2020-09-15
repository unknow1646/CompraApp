package com.example.compraapp;

public class ModeloCarrito  {
    public int cli_rut;
    public int car_cantidad_productos;
    public int car_precio_total;

    public ModeloCarrito(int cli_rut, int car_cantidad_productos, int car_precio_total) {
        this.cli_rut = cli_rut;
        this.car_cantidad_productos = car_cantidad_productos;
        this.car_precio_total = car_precio_total;
    }

    @Override
    public String toString() {
        return "ModeloCarrito{" +
                "cli_rut=" + cli_rut +
                ", car_cantidad_productos=" + car_cantidad_productos +
                ", car_precio_total=" + car_precio_total +
                '}';
    }

    public int getCli_rut() {
        return cli_rut;
    }

    public void setCli_rut(int cli_rut) {
        this.cli_rut = cli_rut;
    }

    public int getCar_cantidad_productos() {
        return car_cantidad_productos;
    }

    public void setCar_cantidad_productos(int car_cantidad_productos) {
        this.car_cantidad_productos = car_cantidad_productos;
    }

    public int getCar_precio_total() {
        return car_precio_total;
    }

    public void setCar_precio_total(int car_precio_total) {
        this.car_precio_total = car_precio_total;
    }
}
