package com.example.tp4_almacenamientoexterno.dao;

import com.example.tp4_almacenamientoexterno.R;
import com.example.tp4_almacenamientoexterno.adapter.articuloAdapter;
import com.example.tp4_almacenamientoexterno.entidades.Articulo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class ArticuloDAO extends AsyncTask<String, Void, String>{

    private static ArrayList<Articulo> listaArticulos = new ArrayList<Articulo>();
    private static String result2;

    private ListView lvArticulos;
    private Context context;

    public ArticuloDAO(ListView lvArticulos, Context context) {
        this.lvArticulos = lvArticulos;
        this.context = context;
    }

    @Override
    protected String doInBackground(String... strings) {
        listaArticulos.clear();
        String response = "";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(DataDB.urlMySQL, DataDB.user, DataDB.pass);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM articulo");
            result2 = " ";

            Articulo articulo;
            while(rs.next()) {
                articulo = new Articulo();
                articulo.setId(rs.getInt("id"));
                articulo.setNombre(rs.getString("nombre"));
                articulo.setStock(rs.getInt("stock"));
                articulo.setIdCategoria(rs.getInt("idCategoria"));
                listaArticulos.add(articulo);
            }
            response = "Conexion exitosa";
        }
        catch(Exception e) {
            e.printStackTrace();
            result2 = "Conexion no exitosa";
        }
        return response;
    }

    @Override
    protected void onPostExecute(String s) {
        articuloAdapter adapter = new articuloAdapter(context, listaArticulos);
        lvArticulos.setAdapter(adapter);
    }
}