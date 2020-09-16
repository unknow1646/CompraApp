package com.example.compraapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.Display;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

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
        String crearTablaCarrProd = "CREATE TABLE carr_prod(cli_rut INTEGER, ven_rut INTEGER, prod_codigo INTEGER PRIMARY KEY, com_autoincrementable INTEGER PRIMARY KEY, FOREIGN KEY (cli_rut) REFERENCES cliente (cli_rut), FOREIGN KEY (ven_rut) REFERENCES vendedor (ven_rut), FOREIGN KEY (prod_codigo) REFERENCES producto (prod_codigo))";

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

    //Revisa si existe el producto en la BD
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

    //Agrega producto a tabla 'producto'
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

    //agrega una instancia de 'compra' en la tabla
    public boolean instanciaCompra(ModeloCompra modeloCompra){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("cli_rut",modeloCompra.getCli_rut());
        cv.put("ven_rut",modeloCompra.getVen_rut());
        cv.put("com_hora_entrega",modeloCompra.getCom_hora_entrega());
        cv.put("com_fecha_entrega",modeloCompra.getCom_fecha_entrega());


        long insert = db.insert("compra",null,cv);
        return insert != -1;
    }

    //consulta en tabla productos (Vendedor) [para editar productos]
    public List<ModeloProducto> getProductos(int rut){
        List<ModeloProducto> returnList = new ArrayList<>();
        String queryString = "SELECT * FROM producto WHERE ven_rut = "+Integer.toString(rut);
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString,null);
        if(cursor.moveToFirst()){
            do{
                int codigo = cursor.getInt(0);
                int rut_v = cursor.getInt(1);
                String nombre = cursor.getString(2);
                int stock = cursor.getInt(3);
                String tipo = cursor.getString(4);
                int precio = cursor.getInt(5);
                ModeloProducto modeloProducto = new ModeloProducto(codigo, rut_v, nombre, stock, tipo, precio);
                returnList.add(modeloProducto);
            }while(cursor.moveToNext());
        }
        else{
            //FAIL
        }
        cursor.close();
        db.close();
        return returnList;
    }

    //Query de las solicitudes de compra disponibles
    public List<ModeloCompra> getEveryoneCompra(){
        List<ModeloCompra> returnList = new ArrayList<>();
        String queryString = "SELECT * FROM compra";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString, null);
        if(cursor.moveToFirst()){
            //loop results
            do{
                int compraid = cursor.getInt(3);
                int compraclirut = cursor.getInt(0);
                int compravenrut = cursor.getInt(1);
                int comprahoranetrega=cursor.getInt(3);
                int comprafechaentrega= cursor.getInt(4);
                ModeloCompra newmodelocompra = new ModeloCompra(compraid,compraclirut,compravenrut,comprahoranetrega,comprafechaentrega);
                returnList.add(newmodelocompra);
            }while(cursor.moveToNext());
        }
        else{
            //FAIL
        }

        //close everything
        cursor.close();
        db.close();
        return returnList;
    }

    //UPTATE tabla compra con su hora y fecha de entrega
    public void updateFinalizarVenta(ModeloCompra modeloCompra){
        int id = 0;
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("cli_rut", modeloCompra.getCli_rut());
        cv.put("ven_rut", modeloCompra.getVen_rut());
        cv.put("com_hora_entrega", modeloCompra.getCom_hora_entrega());
        cv.put("com_fecha_entrega", modeloCompra.getCom_fecha_entrega());
        db.update("compra", cv, "_id=" +id  , null);
    }

    //
    public void updateFechaHoraCompra(ModeloCompra modeloCompra){
        int id = 0;
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("com_hora_entrega", modeloCompra.getCom_hora_entrega());
        cv.put("com_fecha_entrega", modeloCompra.getCom_fecha_entrega());
        db.update("compra", cv, "_id=" +id  , null);
    }

    public void updateCarrito(ModeloCarrito modeloCarrito){
        int id = 0;
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("cli_rut", modeloCarrito.getCli_rut());
        cv.put("carr_cant_prod", modeloCarrito.getCar_cantidad_productos());
        cv.put("carr_precio_total", modeloCarrito.getCar_precio_total());
        db.update("compra", cv, "_id=" +id  , null);
    }


    public boolean deleteAllCarrito(int rut){
        SQLiteDatabase db = this.getWritableDatabase();
        int ret = db.delete("carr_prod", "cli_rut", new String[]{Integer.toString(rut)});
        return ret == 1;
    }


    //QUERY productos para agregar al carrito
    public List<ModeloProducto> getEveryoneBusqueda(String busqueda){
        List<ModeloProducto> returnList = new ArrayList<>();
        String queryString = "SELECT * FROM producto WHERE prod_nombre LIKE \"%"+busqueda+"%\"";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString, null);
        if(cursor.moveToFirst()){
            //loop results
            do{
                int cod = cursor.getInt(0);
                int rut = cursor.getInt(1);
                String nombreprod = cursor.getString(2);
                int stock = cursor.getInt(3);
                String tipo= cursor.getString(4);
                int precio= cursor.getInt(5);
                ModeloProducto modeloProducto = new ModeloProducto(cod, rut, nombreprod, stock,tipo,precio);
                returnList.add(modeloProducto);
            }while(cursor.moveToNext());
        }
        else{
            //FAIL
        }

        //close everything
        cursor.close();
        db.close();
        return returnList;
    }

    //INSERT producto a carr_com
    public boolean agregarProductoAlCarro(ModeloProducto modeloProducto, int rut){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv =new ContentValues();
        cv.put("prod_codigo",modeloProducto.getProd_codigo());
        cv.put("ven_rut",modeloProducto.getVen_rut());
        cv.put("cli_rut",rut);

        long insert = db.insert("carr_prod",null,cv);

        return insert != -1;
    }



    public List<ModeloProducto> getProductosCarrito(int rut) {
        List<ModeloProducto> returnList = new ArrayList<>();
        String queryString = "SELECT producto.* FROM carr_prod,producto where cli_rut = "+rut+" and carr_prod.prod_codigo = producto.prod_codigo";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString, null);
        if (cursor.moveToFirst()) {
            //loop results
            do {
                int codigo = cursor.getInt(0);
                int vRut = cursor.getInt(1);
                String nombre = cursor.getString(2);
                int stock = cursor.getInt(3);
                String tipo = cursor.getString(4);
                int precio = cursor.getInt(5);

                ModeloProducto modeloProducto = new ModeloProducto(codigo,vRut,nombre,stock,tipo,precio);
                returnList.add(modeloProducto);
            } while (cursor.moveToNext());
        } else {
            //FAIL
        }
        //close everything
        cursor.close();
        db.close();
        return returnList;
    }

    public void deleteProductoCarrito(int rut, int cod_producto) {
        SQLiteDatabase db = this.getWritableDatabase();
        String queryString = "DELETE FROM carr_prod WHERE cli_rut = "+ Integer.toString(rut)+" AND prod_codigo = "+Integer.toString(cod_producto);
        try {
            db.execSQL(queryString);
        }
        catch (Exception e){
            //Toast.makeText(null, "Error eliminando producto",Toast.LENGTH_SHORT).show();
        }
    }


    public boolean confirmcompra(ModeloCarritoProducto modelocarritoproducto){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv =new ContentValues();
        cv.put("cli_rut",modelocarritoproducto.getCli_rut());
        cv.put("ven_rut",modelocarritoproducto.getVen_rut());
 //       cv.put("prod_nombre",modelocarritoproducto.getProd_nombre());

        long insert = db.insert("compra",null,cv);

        return insert != -1;
    }


    public void deleteProducto(int ven_rut, int prod_codigo){
        SQLiteDatabase db = getWritableDatabase();
        String queryString = "DELETE FROM producto WHERE prod_codigo ="+prod_codigo+" AND ven_rut = "+ven_rut;
        db.execSQL(queryString);
    }
  
    public int getcodigo(int rut) {
        int cod=0;
        String queryString = "SELECT com_autoincrementable FROM compra WHERE cli_rut="+rut +"AND com_hora_entrega = 0 AND com_fecha_entrega = 0";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString, null);
        if (cursor.moveToFirst()) {
            cod=cursor.getInt(0);
        }
        else{
            return -1;
        }
        cursor.close();
        db.close();
        return cod;
    }


    public void updateProductoEdit(int rut,int code, ModeloProducto modeloProducto_new){
        SQLiteDatabase db = getWritableDatabase();

        String queryString = "UPDATE producto SET prod_codigo = "+modeloProducto_new.getProd_codigo()+",  prod_nombre=\""+ modeloProducto_new.getProd_nombre()+ "\", prod_stock="+modeloProducto_new.getProd_stock()+", prod_precio="+modeloProducto_new.getProd_precio()+",prod_tipo = \""+modeloProducto_new.getProd_tipo()+"\" WHERE prod_codigo="+code+ " AND ven_rut ="+rut;

        db.execSQL(queryString);

    }

}



