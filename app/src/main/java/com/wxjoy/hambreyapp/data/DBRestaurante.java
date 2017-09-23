package com.wxjoy.hambreyapp.data;

import com.wxjoy.hambreyapp.logica.Restaurante;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by wxjoy on 22/09/17.
 */

public class DBRestaurante {
    private String query;
    private Conexion con;
    private PreparedStatement stmt;
    private ResultSet rset;

    public DBRestaurante(){}

    public ArrayList<Restaurante> getRestaurantes(){
        ArrayList<Restaurante> lst = new ArrayList<>();
        Restaurante rest;
        con = new Conexion();
        query = "SELECT * FROM Restaurante R order by R.nombre";
        try {
            stmt = con.getConexion().prepareCall(query);
            rset = stmt.executeQuery();
            while (rset.next()){
                rest = new Restaurante(
                        rset.getInt(1),
                        rset.getString(2),
                        rset.getString(3)
                );
                lst.add(rest);
            }
            con.cerrarConexion();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return lst;
    }
}
