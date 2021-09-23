package com.example.tp4_almacenamientoexterno;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.tp4_almacenamientoexterno.fragments.fragmentAlta;
import com.example.tp4_almacenamientoexterno.fragments.fragmentListado;
import com.example.tp4_almacenamientoexterno.fragments.fragmentModificacion;

public class viewPagerAdapter extends FragmentPagerAdapter {

    private static int cantTabs = 3;

    public viewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        switch (position){
            case 0: return fragmentAlta.newInstance();
            case 1:  return fragmentModificacion.newInstance();
            case 2: return fragmentListado.newInstance();
        }
        return null;
    }

    @Override
    public int getCount() {
        return cantTabs;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return fragmentAlta.titulo;

            case 1:
                return fragmentModificacion.titulo;

            case 2:
                return fragmentListado.titulo;
        }
        return super.getPageTitle(position);
    }
}
