package com.example.compraapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class EditarEliminarProducto extends AppCompatActivity {
    ListView lv_Editar;
    Button btn_editar, btn_eliminar, btn_volver;
    ArrayAdapter lista_productos;
    DataBaseHelper dataBaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_eliminar_producto);
        lv_Editar = findViewById(R.id.lv_EditarEliminar);
        btn_editar = findViewById(R.id.btn_EditarProducto);
        btn_eliminar = findViewById(R.id.btn_EliminarProducto);

        dataBaseHelper = new DataBaseHelper(EditarEliminarProducto.this);
        lista_productos = new ArrayAdapter<ModeloProducto>(EditarEliminarProducto.this, android.R.layout.simple_list_item_checked, dataBaseHelper.getProductos(194398239));
        lv_Editar.setAdapter(lista_productos);

    }
}