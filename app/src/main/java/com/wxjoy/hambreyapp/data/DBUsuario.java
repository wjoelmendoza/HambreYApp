package com.wxjoy.hambreyapp.data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by wxjoy on 21/09/17.
 */

public class DBUsuario {
    private String query;
    private Conexion con;
    private PreparedStatement stmt;
    private ResultSet rset;

    public DBUsuario(){}

    public Object[] validarUsuario(String correo, String pass){
        Object obj[] = null;
        con = new Conexion();
        query = "SELECT * FROM USUARIO U WHERE U.correo = ? and U.clave = ? ";

        try {
            stmt = con.getConexion().prepareStatement(query);
            stmt.setString(1,correo);
            stmt.setString(2,pass);
            rset = stmt.executeQuery();
            obj = cargarDatos();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return obj;
    }

    private Object[] cargarDatos(){
        Object obj[] = null;
        try {
            if(rset == null || !rset.next())
                return obj;

            obj = new Object[rset.getMetaData().getColumnCount()];
            for(int i = 0; i<obj.length; i++){
                obj[i] = rset.getObject(i+1);
            }
            con.cerrarConexion();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return  obj;
    }

}
