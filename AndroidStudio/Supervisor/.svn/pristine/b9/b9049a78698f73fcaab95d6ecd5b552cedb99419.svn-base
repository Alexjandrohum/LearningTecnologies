package com.grupopakar.grupopakarapp.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.grupopakar.grupopakarapp.fragments.tabs.TabListaTiendas;
import com.grupopakar.grupopakarapp.fragments.tabs.TabTiendasCercanas;

/**
 * Created by antonio.ruiz on 29/11/2017.
 */

public class TiendasPagerAdapter extends FragmentStatePagerAdapter {
    private final int tabCount;

    public TiendasPagerAdapter(FragmentManager fm, int tabCount) {
        super(fm);
        this.tabCount= tabCount;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new TabTiendasCercanas();
            case 1:
                return new TabListaTiendas();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }
}
