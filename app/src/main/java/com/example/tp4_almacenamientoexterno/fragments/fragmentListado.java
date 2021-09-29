package com.example.tp4_almacenamientoexterno.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.tp4_almacenamientoexterno.MainActivity;
import com.example.tp4_almacenamientoexterno.R;
import com.example.tp4_almacenamientoexterno.dao.ArticuloDAO;
import com.example.tp4_almacenamientoexterno.dao.CategoriaDAO;
import com.example.tp4_almacenamientoexterno.entidades.Categoria;

import org.w3c.dom.Text;

import java.util.List;

public class fragmentListado extends Fragment {

    public static final String titulo = "LISTADO";
    private View view;
    private ListView listProductos;
    public static fragmentListado newInstance() {
        return new fragmentListado();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_listado, container, false);
        listProductos = (ListView) view.findViewById(R.id.listViewProductos);
        Connect();
        return view;
    }

    public void Connect() {
        ArticuloDAO artDao = new ArticuloDAO(listProductos, getActivity());
        artDao.execute();
    }
}
