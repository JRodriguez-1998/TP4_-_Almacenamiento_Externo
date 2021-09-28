package com.example.tp4_almacenamientoexterno.dao;

import com.example.tp4_almacenamientoexterno.entidades.Articulo;
import com.example.tp4_almacenamientoexterno.entidades.Categoria;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DataDB {
    //Información de la BD
    public static String host="sql10.freesqldatabase.com";
    public static String port="3306";
    public static String nameBD="sql10440077";
    public static String user="sql10440077";
    public static String pass="K8pfyPQKEf";

    //Información para la conexion
    public static String urlMySQL = "jdbc:mysql://" + host + ":" + port + "/"+nameBD;
    public static String driver = "com.mysql.jdbc.Driver";
}
