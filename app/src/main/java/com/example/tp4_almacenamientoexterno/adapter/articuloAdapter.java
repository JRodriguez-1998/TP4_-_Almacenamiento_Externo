package com.example.tp4_almacenamientoexterno.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.tp4_almacenamientoexterno.R;
import com.example.tp4_almacenamientoexterno.entidades.Articulo;

import java.util.List;

public class articuloAdapter extends ArrayAdapter<Articulo> {

    public articuloAdapter(Context context, List<Articulo> listArticulo) {
        super(context, R.layout.list_item_articulos, listArticulo);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.list_item_articulos, null);

        TextView tvId = item.findViewById(R.id.idArticulo);
        TextView tvNombre = item.findViewById(R.id.nombreArt);
        TextView tvStock = item.findViewById(R.id.stockArt);
        TextView tvIdCategoria = item.findViewById(R.id.idCategoria);

        tvId.setText("ID: " + getItem(position).getId()+"");
        tvNombre.setText(getItem(position).getNombre());
        tvStock.setText("Stock: "+ getItem(position).getStock()+"");
        tvIdCategoria.setText("Categoría: "+ getItem(position).getIdCategoria()+"");

        return item;
    }
}
