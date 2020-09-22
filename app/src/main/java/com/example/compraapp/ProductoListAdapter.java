package com.example.compraapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowAnimationFrameStats;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class ProductoListAdapter extends ArrayAdapter<ModeloProducto> {
    private static final String TAG = "ProductoListAdapter";
    private Context mContext;
    int mResource;
    int pos = -1;


    public ProductoListAdapter(@NonNull Context context, int resource, @NonNull List<ModeloProducto> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
    }

    @SuppressLint("ResourceAsColor")
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        String prod_nombre = getItem(position).getProd_nombre();
        int prod_precio = getItem(position).getProd_precio();
        int prod_stock = getItem(position).getProd_stock();

        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent, false);

        TextView nombre = (TextView) convertView.findViewById(R.id.IL_productoNombre);
        TextView precio = (TextView) convertView.findViewById(R.id.IL_productoPrecio);
        TextView stock = (TextView) convertView.findViewById(R.id.IL_precioStock);
       // RadioButton rb =  (RadioButton) convertView.findViewById(R.id.rb_item_selection);
        LinearLayout LL_parent = convertView.findViewById(R.id.LL_parent);

        nombre.setText(prod_nombre);
        precio.setText("$"+Integer.toString(prod_precio));
        stock.setText("Stock: "+Integer.toString(prod_stock));

        if(pos == position){
            //rb.setChecked(true);
            LL_parent.setBackgroundColor(Color.parseColor("#83FF1744"));
        }
        else{
            //rb.setChecked(false);
        }
        return convertView;
    }
}