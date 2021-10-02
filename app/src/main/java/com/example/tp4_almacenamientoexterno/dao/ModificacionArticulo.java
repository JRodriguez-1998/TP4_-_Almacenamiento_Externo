package com.example.tp4_almacenamientoexterno.dao;

import android.os.AsyncTask;

import com.example.tp4_almacenamientoexterno.entidades.Articulo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.text.MessageFormat;

public class ModificacionArticulo extends AsyncTask<String, Void, String> {

    private Articulo articulo;

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }

    @Override
    protected String doInBackground(String... strings) {
        String response = "";
        String query = MessageFormat.format("UPDATE articulo SET " +
                        "nombre = ''{0}'', " +
                        "stock = {1}, " +
                        "idCategoria = {2} " +
                        "WHERE id = {3}",
                articulo.getNombre(), articulo.getStock(), articulo.getIdCategoria(), articulo.getId());

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(DataDB.urlMySQL, DataDB.user, DataDB.pass);
            Statement st = con.createStatement();
            st.executeUpdate(query);
            response = "Éxito al actualizar";
        }
        catch(Exception e) {
            e.printStackTrace();
            response = "Hubo un error al actualizar";
        }
        return response;
    }
}
