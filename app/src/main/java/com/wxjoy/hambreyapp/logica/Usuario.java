package com.wxjoy.hambreyapp.logica;

import android.os.AsyncTask;

/**
 * Created by wxjoy on 21/09/17.
 */

public class Usuario {
    private int codigo;
    private String nombres;
    private String apellidos;
    private String correo;
    private String pass;

    public void setCodigo(int codigo){
        this.codigo = codigo;
    }

    public void setNombres(String nombres){
        this.nombres = nombres;
    }

    public void setApellidos(String apellidos){
        this.apellidos = apellidos;
    }

    public void setCorreo(String correo){
        this.correo=correo;
    }

    public void setPass(String pass){
        this.pass = pass;
    }

    public int getCodigo(){
        return  codigo;
    }

    public String getNombres(){
        return  nombres;
    }

    public String getApellidos(){
        return  apellidos;
    }

    public String getCorreo(){
        return correo;
    }

    public String getPass(){
        return pass;
    }

}
