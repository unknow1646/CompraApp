package com.example.compraapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataBaseHelper extends SQLiteOpenHelper {

    public DataBaseHelper(@Nullable Context context) {
        super(context, "ModeloComprapp.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String crearTablaPersona = "CREATE TABLE persona(per_rut INTEGER PRIMARY KEY,per_nombre TEXT,per_apellido TEXT,per_telefono INTEGER)";
        String crearTablaCliente = "CREATE TABLE cliente(cli_rut INTEGER, cli_direccion TEXT, FOREIGN KEY (cli_rut) REFERENCES persona (per_rut))";
        String crearTablaVendedor = "CREATE TABLE vendedor(ven_rut INTEGER, ven_tienda TEXT, ven_direccion TEXT, FOREIGN KEY (ven_rut) REFERENCES persona (per_rut))";
        String crearTablaProducto = "CREATE TABLE producto(prod_codigo INTEGER PRIMARY KEY, ven_rut INTEGER,  prod_nombre TEXT, prod_stock INTEGER, prod_tipo TEXT, prod_precio INTEGER, FOREIGN KEY  (ven_rut) REFERENCES vendedor(ven_rut))";
        String crearTablaCompra = "CREATE Table compra(cli_rut INTEGER, ven_rut INTEGER, com_autoincrementable INTEGER PRIMARY KEY AUTOINCREMENT, com_hora_entrega INTEGER, com_fecha_entrega INTEGER, FOREIGN KEY  (cli_rut) REFERENCES  cliente (cli_rut), FOREIGN KEY  (ven_rut) REFERENCES  vendedor (ven_rut))";
        String crearTablaCarrito = "CREATE TABLE carrito(cli_rut INTEGER, com_autoincrementable INTEGER PRIMARY KEY, carr_cant_prod INTEGER, carr_precio_total INTEGER, FOREIGN KEY (cli_rut) REFERENCES cliente (cli_rut))";
        String crearTablaCarrProd = "CREATE TABLE carr_prod(cli_rut INTEGER, ven_rut INTEGER, prod_nombre TEXT, com_autoincrementable INTEGER PRIMARY KEY, FOREIGN KEY (cli_rut) REFERENCES cliente (cli_rut), FOREIGN KEY (ven_rut) REFERENCES vendedor (ven_rut), FOREIGN KEY (prod_nombre) REFERENCES producto (prod_nombre))";

        db.execSQL(crearTablaPersona);
        db.execSQL(crearTablaCliente);
        db.execSQL(crearTablaVendedor);
        db.execSQL(crearTablaProducto);
        db.execSQL(crearTablaCompra);
        db.execSQL(crearTablaCarrito);
        db.execSQL(crearTablaCarrProd);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public boolean checkProducto(ModeloProducto modeloProducto){
        //GetCount
        boolean ret;
        String queryString = "SELECT * FROM producto WHERE prod_codigo = "+Integer.toString(modeloProducto.getProd_codigo())+" AND ven_rut = "+Integer.toString(modeloProducto.getVen_rut());
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString,null);
        ret = cursor.getCount() <= 0;

        cursor.close();
        db.close();
        return ret;
    }

    public boolean agregarProducto(ModeloProducto modeloProducto){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv =new ContentValues();
        cv.put("prod_codigo",modeloProducto.getProd_codigo());
        cv.put("ven_rut",modeloProducto.getVen_rut());
        cv.put("prod_nombre",modeloProducto.getProd_nombre());
        cv.put("prod_stock",modeloProducto.getProd_stock());
        cv.put("prod_tipo",modeloProducto.getProd_tipo());
        cv.put("prod_precio",modeloProducto.getProd_precio());

        long insert = db.insert("producto",null,cv);

        return insert != -1;
    }


}
