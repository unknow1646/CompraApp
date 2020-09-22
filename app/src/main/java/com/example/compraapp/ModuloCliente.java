package com.example.compraapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ModuloCliente extends AppCompatActivity {
    Button btn_buscar;
    Button btn_carrito;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modulo_cliente);

        btn_buscar = findViewById(R.id.btn_cli_buscar);
        btn_carrito = findViewById(R.id.btn_cli_carrito);

        btn_carrito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ModuloCliente.this, CarritoDeCompras.class);
                startActivity(i);
            }
        });

        btn_buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ModuloCliente.this, BusquedaDeProductos.class);
                startActivity(i);
            }
        });
    }
}