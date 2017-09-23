package com.wxjoy.hambreyapp.logica;

/**
 * Created by root on 22/09/17.
 */

public class Menu {

    private int id;
    private String nombre;
    private String descripcion;
    private String imagen;

    public Menu(String nombre,String descripcion,String imagen,int id){

        this.setId(id);
        this.setNombre(nombre);
        this.setDescripcion(descripcion);
        this.setImagen(imagen);
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}
