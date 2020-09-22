package com.example.compraapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class Ventas extends AppCompatActivity {
    ListView lv_ventas;
    Button btn_confirmar;
    ArrayAdapter lista_ventas;
    DataBaseHelper dataBaseHelper;
    ModeloCompra modeloCompra;
    int rut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ventas);
        lv_ventas = findViewById(R.id.lv_ventas);
        btn_confirmar = findViewById(R.id.btn_ConfirmarVenta);
        rut = ((DatosUsuario) Ventas.this.getApplication()).getRut_user();

        dataBaseHelper = new DataBaseHelper(Ventas.this);

        lista_ventas = new ArrayAdapter<ModeloCompra>(Ventas.this, android.R.layout.simple_list_item_1, dataBaseHelper.getEveryoneCompra(rut));
        lv_ventas.setAdapter(lista_ventas);


    }
}