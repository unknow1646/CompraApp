package com.example.compraapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

public class RegistrarUsuario extends AppCompatActivity {

    EditText ti_nombre;
    EditText ti_apellido;
    EditText ti_numero;
    EditText ti_direccion;
    EditText ti_rut;
    EditText ti_password;
    Switch sw_vendedor;
    Button btn_confirmar;
    Button btn_cancelar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_usuario);

        ti_nombre = findViewById(R.id.ti_reg_nombre);
        ti_apellido = findViewById(R.id.ti_reg_apellido);
        ti_numero = findViewById(R.id.ti_reg_telefono);
        ti_rut = findViewById(R.id.ti_reg_rut);
        ti_password = findViewById(R.id.ti_reg_password);
        ti_direccion = findViewById(R.id.ti_reg_direccion);
        sw_vendedor = findViewById(R.id.sw_vendedor);
        btn_confirmar = findViewById(R.id.btn_reg_registrar);
        btn_cancelar = findViewById(R.id.bt_reg_cancelar);

        btn_cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btn_confirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombre = ti_nombre.getText().toString();
                String apellido = ti_apellido.getText().toString();
                String telefono =  ti_numero.getText().toString();
                String direccion = ti_direccion.getText().toString();
                Boolean vendedor = sw_vendedor.isChecked();
                String rut = ti_rut.getText().toString();
                String password = ti_password.getText().toString();

                if(nombre.matches("") || apellido.matches("") || telefono.matches("") || direccion.matches("") || rut.matches("") || password.matches("")){
                    Toast.makeText(RegistrarUsuario.this,"Favor llene todos los campos", Toast.LENGTH_SHORT).show();
                    return;
                }

                else{
                    if(vendedor == false){
                        //registrar cliente
                    }
                    else{
                        //registrar cliente
                        Toast.makeText(RegistrarUsuario.this,"Registrar vendedor",Toast.LENGTH_SHORT).show();

                    }

                }

            }
        });

    }
}