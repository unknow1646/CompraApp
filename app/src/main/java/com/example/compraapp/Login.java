package com.example.compraapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    EditText tiRut;
    EditText tiPassword;
    Button btnLogin;
    Button btnRegistrar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        tiRut = findViewById(R.id.ti_loginRut);
        tiPassword = findViewById(R.id.ti_loginPassword);
        btnLogin = findViewById(R.id.btn_login);
        btnRegistrar = findViewById(R.id.btn_register);
        final DataBaseHelper dataBaseHelper = new DataBaseHelper(Login.this);



        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Login.this, RegistrarUsuario.class);
                startActivity(i);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(tiRut.getText().toString().matches("") || tiRut.getText().length()<8){
                    Toast.makeText(Login.this,"Ingrese un rut válido",Toast.LENGTH_SHORT).show();
                    return;
                }
                else if(tiPassword.getText().toString().matches("")){
                    Toast.makeText(Login.this,"Favor ingrese su contraseña",Toast.LENGTH_SHORT).show();
                    return;
                }

                else {
                    int rut = Integer.parseInt(tiRut.getText().toString());
                    String pass = tiPassword.getText().toString();
                    if (dataBaseHelper.checkrut(rut)) {
                        Toast.makeText(Login.this, "Rut o contraseña invalido", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    else {
                        if (dataBaseHelper.login(rut, pass)) {
                            int usr_type = dataBaseHelper.checkUserType(rut);
                            if (usr_type == 0) {
                                //vista Modulo Cliente
                                Intent i = new Intent(Login.this, ModuloCliente.class);
                                startActivity(i);
                                //Toast.makeText(Login.this, "Modulo Cliente", Toast.LENGTH_SHORT).show();
                            } else {
                                //vista modulo Vendedor
                                Intent i = new Intent(Login.this, ModuloVendedor.class);
                                startActivity(i);
                                //Toast.makeText(Login.this, "Modulo Vendedor", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{
                            Toast.makeText(Login.this, "Rut o contraseña invalido", Toast.LENGTH_SHORT).show();
                            return;
                        }
                    }
                }
            }
        });
    }
}