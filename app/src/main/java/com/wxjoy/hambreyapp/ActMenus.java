package com.wxjoy.hambreyapp;

import android.os.Bundle;
import android.app.Activity;
import android.widget.ListView;

import java.util.ArrayList;


public class ActMenus extends Activity {

    String idres;
    ListView lv;
    ArrayList itemsmenus,datamenus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_menus);
        idres = getIntent().getExtras().getString("id");
        Init();
    }

    private int Init(){

        this.lv = (ListView)findViewById(R.id.lv);
        itemsmenus = new ArrayList();
        datamenus = new ArrayList();

        return 1;
    }

}
