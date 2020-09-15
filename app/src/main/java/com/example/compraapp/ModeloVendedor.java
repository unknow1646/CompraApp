package com.example.compraapp;

public class ModeloVendedor extends ModeloPersona {
    private int ven_rut;
    private String ven_tienda;
    private String ven_direccion;

    public ModeloVendedor(int per_rut, String per_nombre, String per_apellido, int per_telefono, int ven_rut, String ven_tienda, String ven_direccion) {
        super(per_rut, per_nombre, per_apellido, per_telefono);
        this.ven_rut = ven_rut;
        this.ven_tienda = ven_tienda;
        this.ven_direccion = ven_direccion;
    }

    @Override
    public String toString() {
        return "ModeloVendedor{" +
                "ven_rut=" + ven_rut +
                ", ven_tienda='" + ven_tienda + '\'' +
                ", ven_direccion='" + ven_direccion + '\'' +
                ", per_rut=" + per_rut +
                ", per_nombre='" + per_nombre + '\'' +
                ", per_apellido='" + per_apellido + '\'' +
                ", per_telefono=" + per_telefono +
                '}';
    }

    public int getVen_rut() {
        return ven_rut;
    }

    public void setVen_rut(int ven_rut) {
        this.ven_rut = ven_rut;
    }

    public String getVen_tienda() {
        return ven_tienda;
    }

    public void setVen_tienda(String ven_tienda) {
        this.ven_tienda = ven_tienda;
    }

    public String getVen_direccion() {
        return ven_direccion;
    }

    public void setVen_direccion(String ven_direccion) {
        this.ven_direccion = ven_direccion;
    }
}
