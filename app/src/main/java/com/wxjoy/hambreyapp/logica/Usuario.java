package com.wxjoy.hambreyapp.logica;

import android.os.AsyncTask;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by wxjoy on 21/09/17.
 */

public class Usuario implements Parcelable {
    private int codigo;
    private String nombres;
    private String apellidos;
    private String correo;
    private String pass;

    public Usuario(){}
    public Usuario(Parcel in){
        readFromParcel(in);
    }

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

    private void readFromParcel(Parcel in){
        codigo = in.readInt();
        nombres = in.readString();
        apellidos = in.readString();
        correo = in.readString();
        pass = in.readString();
    }
    @Override
    public void writeToParcel(Parcel dest, int flag){
        dest.writeInt(codigo);
        dest.writeString(nombres);
        dest.writeString(apellidos);
        dest.writeString(correo);
        dest.writeString(pass);
    }

    @Override
    public int describeContents(){
        return 0;
    }

    public static final Parcelable.Creator<Usuario> CREATOR = new Parcelable.Creator<Usuario>(){
        public Usuario createFromParcel(Parcel in){
            return new Usuario(in);
        }

        public Usuario[] newArray(int size){
            return new Usuario[size];
        }
    };
}
