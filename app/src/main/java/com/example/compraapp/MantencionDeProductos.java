package com.example.compraapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MantencionDeProductos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mantencion_de_productos);

        Button btnRegistrar = findViewById(R.id.btn_RegistrarProducto);
        Button btnEditarEliminar = findViewById(R.id.btn_EditarEliminarProducto);


        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MantencionDeProductos.this, RegistrarProducto.class);
                startActivity(i);
            }
        });

        btnEditarEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MantencionDeProductos.this, EditarEliminarProducto.class);
                startActivity(i);
            }
        });
    }
}