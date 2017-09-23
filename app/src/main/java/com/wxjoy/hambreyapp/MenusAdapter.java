package com.wxjoy.hambreyapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.wxjoy.hambreyapp.logica.Menu;

import java.util.List;

/**
 * Created by root on 22/09/17.
 */

public class MenusAdapter extends BaseAdapter {


    private Context context;
    private List<Menu> items;

    public MenusAdapter(Context context,List<Menu> items){this.context = context;this.items = items;}

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View rowView = view;
        if(view==null)
        {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            rowView = inflater.inflate(R.layout.item_menus,viewGroup,false);
        }

        return rowView;
    }
}
