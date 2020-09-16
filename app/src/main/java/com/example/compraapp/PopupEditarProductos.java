package com.example.compraapp;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AppComponentFactory;
import android.content.Intent;
import android.drm.DrmInfoRequest;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class PopupEditarProductos extends AppCompatActivity {
    EditText ti_codigo, ti_nombre, ti_stock, ti_tipo, ti_precio;
    Button btn_confirmar, btn_cancelar;


    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popup_editar_productos);
        Intent intent = getIntent();


        btn_confirmar = findViewById(R.id.btn_EditConfirm);
        btn_cancelar = findViewById(R.id.btn_EditCancelar);

        ti_codigo = findViewById(R.id.ti_newProdCodigo);
        ti_nombre = findViewById(R.id.ti_newProdNombre);
        ti_stock = findViewById(R.id.ti_newProdStock);
        ti_tipo = findViewById(R.id.ti_newProdTipo);
        ti_precio = findViewById(R.id.ti_newProdPrecio);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int width = displayMetrics.widthPixels;
        int height = displayMetrics.heightPixels;

        WindowManager.LayoutParams layoutParams = getWindow().getAttributes();
        layoutParams.dimAmount = 0.75f;
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        getWindow().setAttributes(layoutParams);
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.BLUE));
        getWindow().setLayout((int) (width*0.9), (int) (height*0.8));

        final int codigoProd = intent.getIntExtra("prod_codigo",0);

        ti_codigo.setText(Integer.toString(intent.getIntExtra("prod_codigo",0)));
        ti_nombre.setText(intent.getStringExtra("prod_nombre"));
        ti_stock.setText(Integer.toString(intent.getIntExtra("prod_stock",0)));
        ti_tipo.setText(intent.getStringExtra("prod_tipo"));
        ti_precio.setText(Integer.toString(intent.getIntExtra("prod_precio",0)));



        btn_confirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ModeloProducto modeloProducto;
                DataBaseHelper dataBaseHelper;

                dataBaseHelper = new DataBaseHelper(PopupEditarProductos.this);


                modeloProducto = new ModeloProducto(Integer.parseInt(ti_codigo.getText().toString()), 194398239,ti_nombre.getText().toString(),Integer.parseInt(ti_stock.getText().toString()),ti_tipo.getText().toString(), Integer.parseInt(ti_stock.getText().toString()));
                Toast.makeText(PopupEditarProductos.this,modeloProducto.toString(),Toast.LENGTH_LONG).show();

                dataBaseHelper.updateProductoEdit(194398239,codigoProd, modeloProducto);

                Intent i = new Intent(PopupEditarProductos.this, EditarEliminarProducto.class);
                startActivity(i);

            }
        });

        btn_cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(PopupEditarProductos.this, EditarEliminarProducto.class);
                startActivity(i);
            }
        });


    }
}
