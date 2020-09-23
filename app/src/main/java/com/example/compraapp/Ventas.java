package com.example.compraapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
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
        lv_ventas.setChoiceMode(AbsListView.CHOICE_MODE_SINGLE);

        dataBaseHelper = new DataBaseHelper(Ventas.this);

        lista_ventas = new ArrayAdapter<ModeloCompra>(Ventas.this, android.R.layout.simple_list_item_single_choice, dataBaseHelper.getEveryoneCompra(rut));
        lv_ventas.setAdapter(lista_ventas);

        btn_confirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ModeloCompra modeloCompra = (ModeloCompra) lv_ventas.getItemAtPosition(lv_ventas.getCheckedItemPosition());
                Intent i = new Intent(Ventas.this, VentaConcretada.class);
                i.putExtra("code",modeloCompra.getCom_id());
                startActivity(i);
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        lista_ventas = new ArrayAdapter<ModeloCompra>(Ventas.this, android.R.layout.simple_list_item_single_choice, dataBaseHelper.getEveryoneCompra(rut));
        lv_ventas.setAdapter(lista_ventas);
        lista_ventas.notifyDataSetChanged();
    }
}