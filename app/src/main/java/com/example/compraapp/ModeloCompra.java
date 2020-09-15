package com.example.compraapp;

public class ModeloCompra {
    public int com_id;
    public int cli_rut;
    public int ven_rut;
    public int com_hora_entrega;
    public int com_fecha_entrega;

    public ModeloCompra(int com_id, int cli_rut, int ven_rut, int com_hora_entrega, int com_fecha_entrega) {
        this.com_id = com_id;
        this.cli_rut = cli_rut;
        this.ven_rut = ven_rut;
        this.com_hora_entrega = com_hora_entrega;
        this.com_fecha_entrega = com_fecha_entrega;
    }

    @Override
    public String toString() {
        return "ModeloCompra{" +
                "com_id=" + com_id +
                ", cli_rut=" + cli_rut +
                ", ven_rut=" + ven_rut +
                ", com_hora_entrega=" + com_hora_entrega +
                ", com_fecha_entrega=" + com_fecha_entrega +
                '}';
    }

    public int getCom_id() {
        return com_id;
    }

    public void setCom_id(int com_id) {
        this.com_id = com_id;
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

    public int getCom_hora_entrega() {
        return com_hora_entrega;
    }

    public void setCom_hora_entrega(int com_hora_entrega) {
        this.com_hora_entrega = com_hora_entrega;
    }

    public int getCom_fecha_entrega() {
        return com_fecha_entrega;
    }

    public void setCom_fecha_entrega(int com_fecha_entrega) {
        this.com_fecha_entrega = com_fecha_entrega;
    }
}
