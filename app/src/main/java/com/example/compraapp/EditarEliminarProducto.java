package com.example.compraapp;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.ColorSpace;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.PopupWindow;
import android.widget.Toast;

public class EditarEliminarProducto extends AppCompatActivity {
    ListView lv_Editar;
    Button btn_editar, btn_eliminar, btn_volver;
    EditarListAdapter lista_productos;
    DataBaseHelper dataBaseHelper;
    int rut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_eliminar_producto);
        lv_Editar = findViewById(R.id.lv_EditarEliminar);
        btn_editar = findViewById(R.id.btn_EditarProducto);
        btn_eliminar = findViewById(R.id.btn_EliminarProducto);
        btn_volver = findViewById(R.id.btn_Editar_Volver);

        lv_Editar.setChoiceMode(AbsListView.CHOICE_MODE_SINGLE);

        rut = ((DatosUsuario) EditarEliminarProducto.this.getApplication()).getRut_user();



        dataBaseHelper = new DataBaseHelper(EditarEliminarProducto.this);
        lista_productos = new EditarListAdapter(EditarEliminarProducto.this, R.layout.layout_editar_productos, dataBaseHelper.getProductos(rut));
        lv_Editar.setAdapter(lista_productos);
        lista_productos.notifyDataSetChanged();


        btn_editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ModeloProducto modeloProducto;
                Intent intent = new Intent(EditarEliminarProducto.this, PopupEditarProductos.class);

                modeloProducto = (ModeloProducto) lv_Editar.getItemAtPosition(lv_Editar.getCheckedItemPosition());


                intent.putExtra("prod_codigo", modeloProducto.getProd_codigo());
                intent.putExtra("ven_rut",modeloProducto.getVen_rut());
                intent.putExtra("prod_nombre", modeloProducto.getProd_nombre());
                intent.putExtra("prod_stock", modeloProducto.getProd_stock());
                intent.putExtra("prod_tipo", modeloProducto.getProd_tipo());
                intent.putExtra("prod_precio",modeloProducto.getProd_precio());

                startActivity(intent);
                lista_productos.notifyDataSetChanged();



            }
        });

        btn_eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ModeloProducto modeloProducto;
                try{
                    modeloProducto = (ModeloProducto) lv_Editar.getItemAtPosition(lv_Editar.getCheckedItemPosition());
                    dataBaseHelper = new DataBaseHelper(EditarEliminarProducto.this);
                    dataBaseHelper.deleteProducto(modeloProducto);

                    lista_productos = new EditarListAdapter(EditarEliminarProducto.this, R.layout.layout_editar_productos, dataBaseHelper.getProductos(194398239));
                    lv_Editar.setAdapter(lista_productos);
                }
                catch(Exception e){
                    Toast.makeText(EditarEliminarProducto.this, "No hay producto seleccionado",Toast.LENGTH_LONG).show();

                }
            }
        });
        btn_volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        lv_Editar.setOnItemClickListener(new AdapterView.OnItemClickListener() {
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
        lista_productos = new EditarListAdapter(EditarEliminarProducto.this, R.layout.layout_editar_productos, dataBaseHelper.getProductos(rut));
        lv_Editar.setAdapter(lista_productos);
        lista_productos.notifyDataSetChanged();
    }
}