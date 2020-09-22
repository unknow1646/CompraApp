package com.example.compraapp;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.w3c.dom.Text;

import java.util.List;

public class EditarListAdapter extends ArrayAdapter<ModeloProducto> {

    private Context mContext;
    int mResource;
    int pos=-1;

    public EditarListAdapter(@NonNull Context context, int resource, @NonNull List<ModeloProducto> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        String nombre = getItem(position).getProd_nombre();
        String code = Integer.toString(getItem(position).getProd_codigo());
        String precio = Integer.toString(getItem(position).getProd_precio());
        String stock = Integer.toString(getItem(position).getProd_stock());

        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        convertView = layoutInflater.inflate(mResource,parent,false);

        TextView prod_nombre = convertView.findViewById(R.id.LE_nombre);
        TextView prod_code = convertView.findViewById(R.id.LE_code);
        TextView prod_stock = convertView.findViewById(R.id.LE_stock);
        TextView prod_precio = convertView.findViewById(R.id.LE_precio);
        LinearLayout linearLayout = convertView.findViewById(R.id.LL_editar);

        prod_nombre.setText(nombre);
        prod_code.setText(code);
        prod_precio.setText("$"+precio);
        prod_stock.setText("Stock: "+stock);

        if(pos == position){
            //rb.setChecked(true);
            linearLayout.setBackgroundColor(Color.parseColor("#83FF1744"));
        }
        else{
            //rb.setChecked(false);
        }

        return convertView;

    }
}
