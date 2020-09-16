package com.example.compraapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

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
//        lista_productos = new ArrayAdapter<ModeloProducto>(BusquedaDeProductos.this, android.R.layout.simple_list_item_single_choice,dataBaseHelper.getEveryoneBusqueda(ti_buscar.getText().toString()));
        lv_busqueda.setChoiceMode(AbsListView.CHOICE_MODE_SINGLE);
//        lv_busqueda.setAdapter(lista_productos);

        btn_buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dataBaseHelper = new DataBaseHelper(BusquedaDeProductos.this);
                lista_productos = new ArrayAdapter<ModeloProducto>(BusquedaDeProductos.this, android.R.layout.simple_list_item_single_choice,dataBaseHelper.getEveryoneBusqueda(ti_buscar.getText().toString()));
                lv_busqueda.setAdapter(lista_productos);
            }
        });

        btn_agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ModeloProducto modeloProducto;
                dataBaseHelper = new DataBaseHelper(BusquedaDeProductos.this);
                modeloProducto = (ModeloProducto) lv_busqueda.getItemAtPosition(lv_busqueda.getCheckedItemPosition());

                if(dataBaseHelper.agregarProductoAlCarro(modeloProducto, 190033694)) Toast.makeText(BusquedaDeProductos.this, "Producto Agregado", Toast.LENGTH_LONG).show();
                //Toast.makeText(BusquedaDeProductos.this, modeloProducto.toString(),Toast.LENGTH_LONG).show();

            }
        });
    }
}