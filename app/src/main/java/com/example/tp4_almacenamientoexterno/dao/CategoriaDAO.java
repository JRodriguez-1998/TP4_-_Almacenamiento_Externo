package com.example.tp4_almacenamientoexterno.dao;

import android.os.AsyncTask;

import com.example.tp4_almacenamientoexterno.entidades.Categoria;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import android.os.AsyncTask;

public class CategoriaDAO{

    public List<Categoria> GetAll() {
        List<Categoria> result = new ArrayList<>();

        try {
            Class.forName(DataDB.driver);
            Connection conn = DriverManager.getConnection(DataDB.urlMySQL, DataDB.user, DataDB.pass);
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM categoria");

            while(rs.next()) {
                result.add(MakeCategoria(rs));
            }

            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private Categoria MakeCategoria(ResultSet rs) throws SQLException {
        Categoria result = new Categoria();

        result.setId(rs.getInt("id"));
        result.setDescripcion(rs.getString("descripcion"));

        return result;
    }
}
