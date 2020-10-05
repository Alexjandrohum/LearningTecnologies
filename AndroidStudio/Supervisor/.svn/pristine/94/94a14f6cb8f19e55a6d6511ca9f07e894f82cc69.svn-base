package com.grupopakar.grupopakarapp.fragments;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.grupopakar.grupopakarapp.R;
import com.grupopakar.grupopakarapp.adapter.TiendasPagerAdapter;

/**
 * Created by antonio.ruiz on 11/05/2018.
 */
public class TiendasFragment extends Fragment implements TabLayout.BaseOnTabSelectedListener {
    private Activity activity;
    private ViewPager viewPager;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_tiendas, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        setupComponentes(view);
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof Activity) activity = (Activity) context;
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    private void setupComponentes(View view) {
        TabLayout tabLayout = view.findViewById(R.id.tab);
        tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.lb_tiendas_cercanas)), 0);
        tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.lb_lista_tiendas)), 1);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        viewPager = view.findViewById(R.id.pager);
        TiendasPagerAdapter adapter = new TiendasPagerAdapter(getFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);

        tabLayout.setupWithViewPager(viewPager);
        tabLayout.addOnTabSelectedListener(this);
        tabLayout.getTabAt(0).setText(getString(R.string.lb_tiendas_cercanas));
        tabLayout.getTabAt(1).setText(getString(R.string.lb_lista_tiendas));
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        viewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}
