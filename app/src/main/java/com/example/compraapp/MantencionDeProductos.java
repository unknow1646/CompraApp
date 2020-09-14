package com.example.compraapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MantencionDeProductos extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mantencion_de_productos);
        Button btnRegistrar = findViewById(R.id.btn_RegistrarProducto);
        Button btneditar = findViewById(R.id.btn_EditarEliminarProducto);
        btnRegistrar.setOnClickListener(this);
        btneditar.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_RegistrarProducto:
                Intent registrar = new Intent(MantencionDeProductos.this, RegistrarProducto.class);
                startActivity(registrar);
                break;

            case R.id.btn_EditarEliminarProducto:
                Intent editar = new Intent(MantencionDeProductos.this, EditarEliminarProducto.class);
                startActivity(editar);
                break;

        }

    }
}