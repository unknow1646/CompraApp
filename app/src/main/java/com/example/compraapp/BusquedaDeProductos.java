package com.example.compraapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class BusquedaDeProductos extends AppCompatActivity {
    ListView lv_busqueda;
    Button btn_buscar, btn_agregar;
    EditText ti_buscar;
    ArrayAdapter lista_productos;
    DataBaseHelper dataBaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_busqueda_de_productos);
        lv_busqueda = findViewById(R.id.lv_buscar);
        btn_agregar = findViewById(R.id.btn_AgregarAlCarrito);
        btn_buscar = findViewById(R.id.btn_buscar);
        ti_buscar = findViewById(R.id.ti_ProductoBusqueda);

        dataBaseHelper = new DataBaseHelper(BusquedaDeProductos.this);
        lista_productos = new ArrayAdapter<ModeloProducto>(BusquedaDeProductos.this, android.R.layout.simple_list_item_1,dataBaseHelper.getEveryoneBusqueda(ti_buscar.getText().toString()));
        lv_busqueda.setAdapter(lista_productos);

        btn_buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dataBaseHelper = new DataBaseHelper(BusquedaDeProductos.this);
                lista_productos = new ArrayAdapter<ModeloProducto>(BusquedaDeProductos.this, android.R.layout.simple_list_item_1,dataBaseHelper.getEveryoneBusqueda(ti_buscar.getText().toString()));
                lv_busqueda.setAdapter(lista_productos);
            }
        });
    }
}