package com.example.tp4_almacenamientoexterno.dao;

import android.os.AsyncTask;

import com.example.tp4_almacenamientoexterno.entidades.Articulo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ArticuloAltaDao extends AsyncTask<String, Void, String>{

    private static Articulo articulo = new Articulo();
    private static String result2;


    @Override
    protected String doInBackground(String... strings) {
        String response = "";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(DataDB.urlMySQL, DataDB.user, DataDB.pass);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM articulo");

            result2 = " ";

            //Articulo art;
            while(rs.next()) {
                articulo = new Articulo();
                articulo.setId(rs.getInt("id"));
                articulo.setNombre(rs.getString("nombre"));
                articulo.setStock(rs.getInt("stock"));
                articulo.setIdCategoria(rs.getInt("idCategoria"));
               // articulo = art;
            }
            response = "Conexion exitosa";
        }
        catch(Exception e) {
            e.printStackTrace();
            result2 = "Conexion no exitosa";
        }
        return response;
    }
}
