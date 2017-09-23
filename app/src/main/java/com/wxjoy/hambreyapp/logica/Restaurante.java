package com.wxjoy.hambreyapp.logica;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by wxjoy on 20/09/17.
 */

public class Restaurante implements Parcelable{
    private int id;
    private String nombre;
    private String descripcion;

    public Restaurante(){}

    public Restaurante(Parcel in){
        readFromParcel(in);
    }

    public Restaurante(int id, String nombre, String descripcion){
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public  String getNombre(){
        return nombre;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }

    public int getId(){
        return id;
    }

    public String getDescripcion(){
        return descripcion;
    }

    private void readFromParcel(Parcel in){
        id = in.readInt();
        nombre = in.readString();
        descripcion = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flag){
        dest.writeInt(id);
        dest.writeString(nombre);
        dest.writeString(descripcion);
    }

    @Override
    public int describeContents(){ return 0; }

    public static final Parcelable.Creator<Restaurante> CREATOR = new Parcelable.Creator<Restaurante>(){
        public Restaurante createFromParcel(Parcel in){
            return new Restaurante(in);
        }

        public Restaurante[] newArray(int size){
            return  new Restaurante[size];
        }
    };
}
