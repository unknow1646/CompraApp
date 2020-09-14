package com.example.compraapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnCarrito = (Button) findViewById(R.id.btn_main_Carrito);
        Button btnCompraConcretada = (Button)findViewById(R.id.btn_Main_CompraConcretada);
        Button btnVentas = (Button)findViewById(R.id.btn_Main_Ventas);
        Button btnBuscar = findViewById(R.id.btn_main_buscar);
        Button btnMantener = findViewById(R.id.btn_Main_MantencionProductos);

        btnCarrito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, CarritoDeCompras.class);
                startActivity(i);
            }
        });

        btnCompraConcretada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, VentaConcretada.class);
                startActivity(i);
            }
        });

        btnVentas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Ventas.class);
                startActivity(i);
            }
        });

        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, BusquedaDeProductos.class);
                startActivity(i);
            }
        });
        btnMantener.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, MantencionDeProductos.class);
                startActivity(i);
            }
        });

    }

}