package com.wxjoy.hambreyapp.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by wxjoy on 21/09/17.
 */

public class Conexion {
    private static final String USUARIO ="root";
    private static final String PASS = "w1j2m3";
    private static final String DB = "jdbc:mysql://10.0.3.192:3306/dbP2AYD2";
    private  Connection con;

    public Conexion(){

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con =(Connection) DriverManager.getConnection(DB,USUARIO,PASS);
        }catch (SQLException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection getConexion(){
        return con;
    }

    public void cerrarConexion(){
        try {
            con.close();
        }catch (SQLException e){

        }
    }

}
