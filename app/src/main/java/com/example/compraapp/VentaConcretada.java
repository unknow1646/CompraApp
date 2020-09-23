package com.example.compraapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class VentaConcretada extends AppCompatActivity {
    TextView codigoventa;
    Button btn_finalizar;
    DataBaseHelper dataBaseHelper;
    ModeloCompra modeloCompra;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_venta_concretada);
        codigoventa = findViewById(R.id.ti_CodigoVenta);
        btn_finalizar = findViewById(R.id.btn_ConcretarVenta_Volver);
        dataBaseHelper = new DataBaseHelper(VentaConcretada.this);
        final int code = getIntent().getIntExtra("code",0);

        codigoventa.setText(Integer.toString(code));

        btn_finalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dataBaseHelper.deleteSolCompra(code);
                finish();
            }
        });



        
    }
}