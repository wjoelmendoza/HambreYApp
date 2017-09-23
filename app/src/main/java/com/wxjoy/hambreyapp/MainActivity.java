package com.wxjoy.hambreyapp;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.wxjoy.hambreyapp.data.DBUsuario;
import com.wxjoy.hambreyapp.logica.Usuario;

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
        String correo = txtCorreo.getText().toString();
        String pass = txtPass.getText().toString();
        if(correo.length() !=0 && pass.length() !=0) {
            Login lg = new Login();
            lg.execute(txtCorreo.getText().toString(), txtPass.getText().toString());
        }else{
            Toast.makeText(this,"Todos los campos son obligatorios",Toast.LENGTH_LONG).show();
        }
    }

    private void continuar(Usuario user){
        if(user!=null) {
            Intent actB = new Intent(this, ActBienvenida.class);
            actB.putExtra("usuario", user);
            startActivity(actB);
        }else{
            Toast.makeText(this,"Credenciales invalidas", Toast.LENGTH_LONG).show();
        }
    }

    private class Login extends AsyncTask<String, Void,Usuario>{
        private String correo;
        private String pass;
        private Usuario usuario;

        @Override
        protected Usuario doInBackground(String... params){
            DBUsuario dbUser = new DBUsuario();
            correo = params[0];
            pass = params[1];
            Object data[] = dbUser.validarUsuario(correo,pass);
            if(data != null) {
                usuario = new Usuario();
                usuario.setCodigo(Integer.parseInt(data[0].toString()));
                usuario.setNombres(data[1].toString());
                usuario.setApellidos(data[2].toString());
                usuario.setCorreo(correo);
                usuario.setPass(pass);
                return usuario;
            }else {
                return null;
            }
        }

        @Override
        protected void onPostExecute(Usuario usr){
            continuar(usr);
        }
    }
}


