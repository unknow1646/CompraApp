package com.example.compraapp;

import android.app.Application;

public class DatosUsuario extends Application {
    private int rut_user;

    public int getRut_user(){
        return rut_user;
    }

    public void setRut_user(int rut){
        this.rut_user = rut;
    }

}
