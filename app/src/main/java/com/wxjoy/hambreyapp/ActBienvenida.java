package com.wxjoy.hambreyapp;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.wxjoy.hambreyapp.data.DBRestaurante;
import com.wxjoy.hambreyapp.logica.Restaurante;
import com.wxjoy.hambreyapp.logica.Usuario;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by wxjoy on 22/09/17.
 */

public class ActBienvenida extends AppCompatActivity {
    private Usuario user;
    private TextView lblBienvenido;
    private TextView lblVacio;
    private ArrayList<Restaurante> lstRest;
    private Context cont;
    //private TableLayout tblRest;
    private ListView lstVRest;
    private RestAdapter adapterRest ;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        cont = this;
        setContentView(R.layout.act_bienvenida);
        lblBienvenido = (TextView) findViewById(R.id.lbl_b_bienvenido);
        lblVacio = (TextView) findViewById(R.id.lbl_vacio_r);
        //tblRest = (TableLayout) findViewById(R.id.tbl_restaurantes);
        lstVRest =(ListView) findViewById(R.id.lst_view);
        lstVRest.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
                String item =""+ lstRest.get(position).getId();
                Toast.makeText(cont,"You selected : " + item,Toast.LENGTH_SHORT).show();
            }
        });
        Intent intent = this.getIntent();
        if(intent != null){
            user = intent.getParcelableExtra("usuario");
            lblBienvenido.setText("Bienvenido " + user.getNombres());
        }
        new MngDatos().execute();
    }

    private void llenarRest(){
        if(lstRest.isEmpty()){
            lblVacio.setText("No hay Restaurantes");
        }else {
            System.out.println("cargando vistas");
            //cargarVistas();
            opt();
        }

    }

    private void opt(){
        adapterRest = new RestAdapter(this,lstRest);
        lstVRest.setAdapter(adapterRest);

    }

    /***
     * Manejo de datos asincrono
     * **/
    private class MngDatos extends AsyncTask<String,Void, ArrayList<Restaurante>>{
        private DBRestaurante dbR;

        @Override
        protected ArrayList<Restaurante> doInBackground(String... params) {
            dbR = new DBRestaurante();
            ArrayList<Restaurante> lst = dbR.getRestaurantes();
            return lst;
        }

        @Override
        protected void onPostExecute(ArrayList<Restaurante> param){
            lstRest = param;
            llenarRest();
        }
    }

}
