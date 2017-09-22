package com.wxjoy.hambreyapp.logica;

import android.os.AsyncTask;
import android.content.Context;

import com.wxjoy.hambreyapp.data.DBUsuario;

/**
 * Created by wxjoy on 21/09/17.
 */

public class GestorDatos extends AsyncTask<String,Integer,Boolean> {

    private Context act;
    private String correo;
    private String pass;
    private Usuario usuario;

    public GestorDatos(Context act, String correo, String pass){
        this.act =act;
        this.correo = correo;
        this.pass = pass;
        usuario = null;
    }

    @Override
    protected Boolean doInBackground(String... params) {
        DBUsuario dbUser = new DBUsuario();
        Object data[] = dbUser.validarUsuario(correo,pass);
        if(data != null) {
            usuario = new Usuario();
            usuario.setCodigo(Integer.parseInt(data[0].toString()));
            usuario.setNombres(data[1].toString());
            usuario.setApellidos(data[2].toString());
            usuario.setCorreo(correo);
            usuario.setPass(pass);
            return true;
        }else {
            return false;
        }
    }

    public Usuario getUsuario(){
        doInBackground();
        return  usuario;
    }

}
