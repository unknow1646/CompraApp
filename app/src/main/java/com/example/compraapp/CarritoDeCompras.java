package com.example.compraapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class CarritoDeCompras extends AppCompatActivity {
    Button btn_eliminar;
    Button btn_confirmar_compra;
    ListView lv_carrito;
    DataBaseHelper dataBaseHelper;
    ProductoListAdapter lista_productos;
    int rut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrito_de_compras);
        btn_eliminar = findViewById(R.id.btn_EliminarDelCarrito);
        btn_confirmar_compra = findViewById(R.id.btn_CarritoConfirmar);
        lv_carrito = findViewById(R.id.lv_CarritoDeCompras);

        rut = ((DatosUsuario) CarritoDeCompras.this.getApplication()).getRut_user();

        lv_carrito.setChoiceMode(AbsListView.CHOICE_MODE_SINGLE);

        dataBaseHelper = new DataBaseHelper(CarritoDeCompras.this);
        lista_productos = new ProductoListAdapter(CarritoDeCompras.this, R.layout.layout_productos_busqueda, dataBaseHelper.getProductosCarrito(rut));

        lv_carrito.setAdapter(lista_productos);

        btn_eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ModeloProducto modeloProducto;
                try {
                    modeloProducto = (ModeloProducto) lv_carrito.getItemAtPosition(lv_carrito.getCheckedItemPosition());
                    dataBaseHelper = new DataBaseHelper(CarritoDeCompras.this);
                    dataBaseHelper.deleteProductoCarrito(rut, modeloProducto.getProd_codigo());
                    lista_productos = new ProductoListAdapter(CarritoDeCompras.this, R.layout.layout_productos_busqueda, dataBaseHelper.getProductosCarrito(rut));
                    lista_productos.notifyDataSetChanged();
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
                if(lv_carrito.getAdapter().getCount() == 0){
                    Toast.makeText(CarritoDeCompras.this,"Carrito vacío!", Toast.LENGTH_SHORT).show();
                    return;
                }
                else {
                    ModeloCompra modeloCompra;
                    ModeloProducto modeloProducto = (ModeloProducto) lv_carrito.getItemAtPosition(0);
                    int ven_rut = modeloProducto.getVen_rut();

                    modeloCompra = new ModeloCompra(0, rut, ven_rut, 0, 0);

                    dataBaseHelper.instanciaCompra(modeloCompra);
                    Intent i = new Intent(CarritoDeCompras.this, CompraConcretada.class);
                    startActivity(i);
                }
            }
        });

        lv_carrito.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                lista_productos.pos = i;
                lista_productos.notifyDataSetChanged();
            }
        });



    }

    @Override
    protected void onResume() {
        super.onResume();
        lista_productos = new ProductoListAdapter(CarritoDeCompras.this, R.layout.layout_productos_busqueda, dataBaseHelper.getProductosCarrito(rut));
        lv_carrito.setAdapter(lista_productos);
        lista_productos.notifyDataSetChanged();
    }
}