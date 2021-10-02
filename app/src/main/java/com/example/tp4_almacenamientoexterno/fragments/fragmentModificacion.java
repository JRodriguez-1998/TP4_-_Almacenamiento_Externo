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
import com.example.tp4_almacenamientoexterno.dao.BusquedaArticulo;
import com.example.tp4_almacenamientoexterno.dao.CargarSpinner;
import com.example.tp4_almacenamientoexterno.dao.ModificacionArticulo;
import com.example.tp4_almacenamientoexterno.entidades.Articulo;

public class fragmentModificacion extends Fragment {

    public static final String titulo = "MODIFICACION";
    private View view;
    private EditText txtID;
    private Button btnBuscar;
    private Button btnModificar;
    private EditText txtNombre;
    private EditText txtStock;
    private Spinner spinnerCat;

    public static fragmentModificacion newInstance() {
        return new fragmentModificacion();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_modificacion, container, false);

        txtID = (EditText) view.findViewById(R.id.txtID);
        txtNombre = (EditText) view.findViewById(R.id.txtNombre);
        txtStock = (EditText) view.findViewById(R.id.txtStock);
        spinnerCat = (Spinner) view.findViewById(R.id.spinnerCategoria);

        btnBuscar = (Button) view.findViewById(R.id.btnBuscar);
        btnModificar = (Button) view.findViewById(R.id.btnModificar);

        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if (txtID.getText().toString().isEmpty()) {
                        Toast.makeText(getActivity(), "Debe ingresar un ID", Toast.LENGTH_LONG).show();
                        return;
                    }

                    Integer id = Integer.parseInt(txtID.getText().toString());

                    BusquedaArticulo busqueda = new BusquedaArticulo();
                    busqueda.setId(id);

                    Articulo art = busqueda.execute().get();

                    if (art == null) {
                        Toast.makeText(getActivity(), "El ID ingresado no existe", Toast.LENGTH_LONG).show();
                        return;
                    }
                    cargarSpinner();
                    SetearCamposArticulo(art);



                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        btnModificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(txtID.getText().toString().isEmpty() || txtNombre.getText().toString().isEmpty() || txtStock.getText().toString().isEmpty()){
                        Toast.makeText(getActivity(), "Faltan completar campos", Toast.LENGTH_SHORT).show();


                }
                else{
                Integer id = Integer.parseInt(txtID.getText().toString());
                String nombre = txtNombre.getText().toString();
                Integer stock = Integer.parseInt(txtStock.getText().toString());
                Integer idCategoria = spinnerCat.getSelectedItemPosition() + 1;

                Articulo articulo = new Articulo(id, nombre, stock, idCategoria, null);

                try {
                    ModificacionArticulo modificacion = new ModificacionArticulo();
                    modificacion.setArticulo(articulo);

                    String resultado = modificacion.execute().get();
                    Toast.makeText(getActivity(), resultado, Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(getActivity(), "Hubo un error al actualizar", Toast.LENGTH_SHORT).show();
                }
            }}

        });

        return view;
    }

    private void SetearCamposArticulo(Articulo articulo) {
        txtNombre.setText(articulo.getNombre());
        txtStock.setText(articulo.getStock().toString());

    }

    public void cargarSpinner() {
        CargarSpinner carga = new CargarSpinner(spinnerCat, getActivity());
        carga.execute();
    }

}
