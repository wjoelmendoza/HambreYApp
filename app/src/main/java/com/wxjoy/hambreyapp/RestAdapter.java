package com.wxjoy.hambreyapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.wxjoy.hambreyapp.logica.Restaurante;

import java.util.ArrayList;

/**
 * Created by wxjoy on 22/09/17.
 */

public class RestAdapter extends ArrayAdapter<Restaurante> {
    public RestAdapter(Context context, ArrayList<Restaurante> rests){
        super(context,0, rests);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        Restaurante rest = getItem(position);
        if(convertView ==null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.row_rest,parent,false);
        }
        TextView tvName = (TextView) convertView.findViewById(R.id.tv_nombre);
        TextView tvDesc = (TextView) convertView.findViewById(R.id.tv_descripcion);
        tvName.setText(rest.getNombre());
        tvDesc.setText(rest.getDescripcion());

        return convertView;
    }

}
