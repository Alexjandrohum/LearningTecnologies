package com.alexjandrohum.semanas;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.getbase.floatingactionbutton.FloatingActionButton;
import com.getbase.floatingactionbutton.FloatingActionsMenu;

public class Semana extends AppCompatActivity{
    DrawerLayout drawer;
    NavigationView navigationView;
    Toolbar toolbar=null;


    private TabLayout tabLayout;
    private ViewPager viewPaper;
    private ViewPaperAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_semana);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setElevation(0);

        final FloatingActionsMenu menuBotones = (FloatingActionsMenu) findViewById(R.id.grupo_fab);
        final FloatingActionButton fab1 = (FloatingActionButton) findViewById(R.id.fab1);
        final FloatingActionButton fab2 = (FloatingActionButton) findViewById(R.id.fab2);
        final FloatingActionButton fab3 = (FloatingActionButton) findViewById(R.id.fab3);



        fab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent inte = new Intent(Semana.this, Perfil.class);
                  startActivity(inte);

            }
        });


        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent inte = new Intent(Semana.this, Semana.class);
                startActivity(inte);

            }
        });
        fab3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent inte = new Intent(Semana.this, MainActivity2.class);
                startActivity(inte);

            }
        });


        tabLayout = (TabLayout) findViewById(R.id.tablayout_id);
        viewPaper = (ViewPager) findViewById(R.id.viewpawer_id);
        adapter = new ViewPaperAdapter(getSupportFragmentManager());



        adapter.AddFragment(new FragmentLunes(),"Lu");
        adapter.AddFragment(new FragmentMartes(),"Ma");
        adapter.AddFragment(new FragmentMiercoles(),"Mi");
        adapter.AddFragment(new FragmentJueves(),"Ju");
        adapter.AddFragment(new FragmentViernes(),"Vi");
        adapter.AddFragment(new FragmentSabado(),"Sa");
        viewPaper.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPaper);


    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.tools, menu);
        return true;
    }


}
