package com.example.tp4_almacenamientoexterno.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.tp4_almacenamientoexterno.R;
import com.example.tp4_almacenamientoexterno.dao.AltaArticulo;
import com.example.tp4_almacenamientoexterno.dao.ArticuloDAO;
import com.example.tp4_almacenamientoexterno.dao.BusquedaArticulo;
import com.example.tp4_almacenamientoexterno.dao.CargarSpinner;
import com.example.tp4_almacenamientoexterno.entidades.Articulo;

public class fragmentAlta  extends Fragment {

    public static final String titulo = "ALTA";
    private View view;
    private Button btnAgregar;
    private EditText txtId, txtNombre, txtStock, txtIdCategoria;
    private Spinner spinnerCat;

    public static fragmentAlta newInstance() {
        return new fragmentAlta();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_alta, container, false);

        txtId = (EditText) view.findViewById(R.id.txtID);
        txtNombre = (EditText) view.findViewById(R.id.txtNombre);
        txtStock = (EditText)view.findViewById(R.id.txtStock);

        spinnerCat = (Spinner) view.findViewById(R.id.spinnerCategoria);
        btnAgregar = (Button) view.findViewById(R.id.btnAgregar);

        cargarSpinner();

        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                
                if(txtId.getText().toString().isEmpty() || txtNombre.getText().toString().isEmpty() || txtStock.getText().toString().isEmpty()){

                    Toast.makeText(getActivity(), "Faltan completar campos", Toast.LENGTH_SHORT).show();
                    return;

                }

                try {
                    Integer id = Integer.parseInt(txtId.getText().toString());

                    BusquedaArticulo busqueda = new BusquedaArticulo();
                    busqueda.setId(id);

                    Articulo art = busqueda.execute().get();
                    if (art != null) {
                        Toast.makeText(getActivity(), "El ID ingresado ya existe", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    Articulo a = new Articulo(id,txtNombre.getText().toString(),
                            Integer.parseInt(txtStock.getText().toString()), spinnerCat.getSelectedItemPosition() +1, null);

                    AltaArticulo alta = new AltaArticulo();
                    alta.setArticulo(a);

                    String resultado = alta.execute().get();
                    Toast.makeText(getActivity(), resultado, Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(getActivity(), "Error al insertar", Toast.LENGTH_SHORT).show();
                }
            }

        });
        return view;
    }

    public void cargarSpinner() {
        CargarSpinner carga = new CargarSpinner(spinnerCat, getActivity());
        carga.execute();
    }
}
