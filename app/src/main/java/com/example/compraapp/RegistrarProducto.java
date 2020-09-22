package com.example.compraapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistrarProducto extends AppCompatActivity {
    EditText prod_codigo, prod_nombre, prod_stock, prod_tipo, prod_precio;
    Button btn_Registrar,btn_Volver;
    DataBaseHelper dataBaseHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_producto);
        prod_codigo = findViewById(R.id.ti_prodCodigo);
        prod_nombre = findViewById(R.id.ti_NombreProducto);
        prod_stock = findViewById(R.id.ti_StockProducto);
        prod_tipo = findViewById(R.id.ti_TipoProducto);
        prod_precio = findViewById(R.id.ti_PrecioProducto);
        btn_Registrar = findViewById(R.id.btn_RegistrarProducto);
        btn_Volver = findViewById(R.id.btn_RegistrarVolver);

        dataBaseHelper = new DataBaseHelper(RegistrarProducto.this);

        btn_Registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ModeloProducto modeloProducto;
                if(prod_codigo.getText().toString().matches("")){
                    Toast.makeText(RegistrarProducto.this,"Código de producto vacío",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(prod_nombre.getText().toString().matches("")){
                    Toast.makeText(RegistrarProducto.this,"Nombre de producto vacío",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(prod_stock.getText().toString().matches("")){
                    Toast.makeText(RegistrarProducto.this,"Stock de producto vacío",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(prod_tipo.getText().toString().matches("")){
                    Toast.makeText(RegistrarProducto.this,"Tipo de producto vacío",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(prod_precio.getText().toString().matches("")){
                    Toast.makeText(RegistrarProducto.this,"Precio de producto vacío",Toast.LENGTH_SHORT).show();
                    return;
                }

                modeloProducto = new ModeloProducto(Integer.parseInt(prod_codigo.getText().toString()), 194398239, prod_nombre.getText().toString(),Integer.parseInt(prod_stock.getText().toString()),prod_tipo.getText().toString(),Integer.parseInt(prod_precio.getText().toString()));

                dataBaseHelper = new DataBaseHelper(RegistrarProducto.this);
                if(dataBaseHelper.checkProducto(modeloProducto)==false){
                    Toast.makeText(RegistrarProducto.this, "Este producto ya existe", Toast.LENGTH_SHORT).show();
                }
                else {
                    boolean success = dataBaseHelper.agregarProducto(modeloProducto);
                    Toast.makeText(RegistrarProducto.this, "Producto registrado con éxito", Toast.LENGTH_SHORT).show();
                    prod_codigo.setText("");
                    prod_nombre.setText("");
                    prod_precio.setText("");
                    prod_stock.setText("");
                    prod_tipo.setText("");
                }
            }
        });

        btn_Volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               finish();
            }
        });
    }
}