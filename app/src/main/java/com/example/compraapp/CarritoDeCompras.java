package com.example.compraapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class CarritoDeCompras extends AppCompatActivity {
    Button btn_eliminar;
    Button btn_confirmar_compra;
    ListView lv_carrito;
    DataBaseHelper dataBaseHelper;
    ArrayAdapter lista_productos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrito_de_compras);
        btn_eliminar = findViewById(R.id.btn_EliminarDelCarrito);
        btn_confirmar_compra = findViewById(R.id.btn_CarritoConfirmar);
        lv_carrito = findViewById(R.id.lv_CarritoDeCompras);

        lv_carrito.setChoiceMode(AbsListView.CHOICE_MODE_SINGLE);

        dataBaseHelper = new DataBaseHelper(CarritoDeCompras.this);
        lista_productos = new ArrayAdapter<ModeloProducto>(CarritoDeCompras.this, android.R.layout.simple_list_item_single_choice, dataBaseHelper.getProductosCarrito(190033694));

        lv_carrito.setAdapter(lista_productos);

        btn_eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ModeloProducto modeloProducto;
                try {
                    modeloProducto = (ModeloProducto) lv_carrito.getItemAtPosition(lv_carrito.getCheckedItemPosition());
                    dataBaseHelper = new DataBaseHelper(CarritoDeCompras.this);
                    dataBaseHelper.deleteProductoCarrito(190033694, modeloProducto.getProd_codigo());
                    lista_productos = new ArrayAdapter<ModeloProducto>(CarritoDeCompras.this, android.R.layout.simple_list_item_single_choice, dataBaseHelper.getProductosCarrito(190033694));
                    lv_carrito.setAdapter(lista_productos);
                }
                catch (Exception e){
                    Toast.makeText(CarritoDeCompras.this, "No hay producto seleccionado",Toast.LENGTH_LONG).show();
                }
            }
        });

        btn_confirmar_compra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ModeloCompra modeloCompra;
                modeloCompra = new ModeloCompra(0,190033694, 194398239,0,0);

                dataBaseHelper.instanciaCompra(modeloCompra);
            }
        });

    }


}