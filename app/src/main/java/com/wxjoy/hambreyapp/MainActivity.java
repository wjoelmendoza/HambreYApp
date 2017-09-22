package com.wxjoy.hambreyapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.wxjoy.hambreyapp.logica.GestorDatos;

public class MainActivity extends AppCompatActivity {
    private EditText txtPass;
    private EditText txtCorreo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtPass = (EditText) findViewById(R.id.txt_password);
        txtCorreo = (EditText) findViewById(R.id.txt_correo);
    }


    public void btnAceptar(View view){

        GestorDatos gestor = new GestorDatos(this, txtCorreo.getText().toString(),txtPass.getText().toString());
        gestor.getUsuario();
    }
}
