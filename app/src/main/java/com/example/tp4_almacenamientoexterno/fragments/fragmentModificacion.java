package com.example.tp4_almacenamientoexterno.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.tp4_almacenamientoexterno.R;

public class fragmentModificacion extends Fragment {

    public static final String titulo = "MODIFICACION";
    private View view;

    public static fragmentModificacion newInstance() {
        return new fragmentModificacion();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_modificacion, container, false);
        return view;
    }
}
