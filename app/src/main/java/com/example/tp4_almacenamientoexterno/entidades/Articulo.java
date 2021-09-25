package com.example.tp4_almacenamientoexterno.entidades;

import java.io.Serializable;

public class Articulo implements Serializable {
    private Integer id;
    private String nombre;
    private Integer stock;
    private Categoria categoria;

    public Articulo(){
    }

    public Articulo(Integer id, String nombre, Integer stock, Categoria categoria) {
        this.id = id;
        this.nombre = nombre;
        this.stock = stock;
        this.categoria = categoria;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Articulo{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", stock=" + stock +
                ", categoria=" + categoria +
                '}';
    }
}
