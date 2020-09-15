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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ventas);
        lv_ventas = findViewById(R.id.lv_ventas);
        btn_confirmar = findViewById(R.id.btn_ConfirmarVenta);

        dataBaseHelper = new DataBaseHelper(Ventas.this);

        modeloCompra = new ModeloCompra(-1,123,123,123,123);
        Toast.makeText(Ventas.this, "Instancia OK = "+dataBaseHelper.instanciaCompra(modeloCompra),Toast.LENGTH_SHORT).show();

        lista_ventas = new ArrayAdapter<ModeloCompra>(Ventas.this, android.R.layout.simple_list_item_1, dataBaseHelper.getEveryoneCompra());
        lv_ventas.setAdapter(lista_ventas);


    }
}