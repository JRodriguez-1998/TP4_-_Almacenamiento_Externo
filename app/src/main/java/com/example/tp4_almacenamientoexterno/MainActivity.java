package com.example.tp4_almacenamientoexterno;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayout.Tab;

public class MainActivity extends AppCompatActivity {

    private TabLayout tab;
    private ViewPager vp;
    private viewPagerAdapter viewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tab = (TabLayout) findViewById(R.id.tabs);
        cargarViewPager();
    }

    private void cargarViewPager(){
        ViewPager vp = (ViewPager) findViewById(R.id.viewPager);
        viewAdapter = new viewPagerAdapter(getSupportFragmentManager());
        vp.setAdapter(viewAdapter);

        tab = (TabLayout) findViewById(R.id.tabs);
        tab.setupWithViewPager(vp);
    }
}