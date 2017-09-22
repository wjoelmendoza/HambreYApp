package com.wxjoy.hambreyapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.wxjoy.hambreyapp.logica.Usuario;

/**
 * Created by wxjoy on 22/09/17.
 */

public class ActBienvenida extends AppCompatActivity {
    private Usuario user;
    private TextView lblBienvenido;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_bienvenida);
        lblBienvenido = (TextView) findViewById(R.id.lbl_b_bienvenido);

        Intent intent = this.getIntent();
        if(intent != null){
            user = intent.getParcelableExtra("usuario");
            lblBienvenido.setText("Bienvenido " + user.getNombres());
        }
    }
}
