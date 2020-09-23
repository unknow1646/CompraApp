package com.example.compraapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.DatabaseMetaData;

public class CompraConcretada extends AppCompatActivity {

    TextView codigoCompra;
    Button finalizar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compra_concretada);
        codigoCompra = findViewById(R.id.txt_CodigoCompra);
        finalizar = findViewById(R.id.btn_finalizar_cliente);

        final DataBaseHelper dataBaseHelper = new DataBaseHelper(CompraConcretada.this);
        final int rut = ((DatosUsuario) CompraConcretada.this.getApplication()).getRut_user();

        int code = dataBaseHelper.getCodigoCompraCli(rut);

        codigoCompra.setText(Integer.toString(code));

        finalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dataBaseHelper.deleteAllCarrito(rut);
                finish();
            }
        });

    }
}