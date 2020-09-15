package com.example.compraapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class VentaConcretada extends AppCompatActivity {
    EditText codigoventa;
    Button btn_finalizar;
    DataBaseHelper dataBaseHelper;
    ModeloCompra modeloCompra;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_venta_concretada);
        codigoventa = findViewById(R.id.ti_CodigoVenta);
        btn_finalizar = findViewById(R.id.btn_ConcretarVenta_Volver);

        
    }
}