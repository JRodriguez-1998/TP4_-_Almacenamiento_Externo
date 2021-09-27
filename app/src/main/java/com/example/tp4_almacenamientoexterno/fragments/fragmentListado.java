package com.example.tp4_almacenamientoexterno.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.tp4_almacenamientoexterno.MainActivity;
import com.example.tp4_almacenamientoexterno.R;

public class fragmentListado extends Fragment {

    public static final String titulo = "LISTADO";
    private View view;
    private ListView listProductos;
    private String vProductos [] ={"Cerveza", "Fernet", "Vodka", "Champagne", "Jagger"};

    public static fragmentListado newInstance() {
        return new fragmentListado();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_listado, container, false);

        listProductos = (ListView) view.findViewById(R.id.listViewProductos);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, vProductos);
        listProductos.setAdapter(adapter);

        return view;
    }
}
