package com.example.tp4_almacenamientoexterno.dao;

import com.example.tp4_almacenamientoexterno.entidades.Articulo;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ArticuloDAO {

    private Articulo MakeArticulo(ResultSet rs) throws SQLException {
        Articulo result = new Articulo();

        result.setId(rs.getInt("id"));
        result.setNombre(rs.getString("nombre"));
        result.setStock(rs.getInt("stock"));
        result.setIdCategoria(rs.getInt("idCategoria"));

        return result;
    }
}
