package com.example.compraapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ModuloVendedor extends AppCompatActivity {
    Button btn_mantencion;
    Button btn_ventas;
    int rut;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modulo_vendedor);

        btn_mantencion = findViewById(R.id.btn_ven_mantencion);
        btn_ventas = findViewById(R.id.btn_ven_ventas);
        rut = ((DatosUsuario) ModuloVendedor.this.getApplication()).getRut_user();


        Toast.makeText(ModuloVendedor.this,"rut: "+rut,Toast.LENGTH_SHORT).show();

        btn_ventas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ModuloVendedor.this, Ventas.class);
                startActivity(i);
            }
        });

        btn_mantencion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ModuloVendedor.this, MantencionDeProductos.class);
                startActivity(i);
            }
        });


    }
}