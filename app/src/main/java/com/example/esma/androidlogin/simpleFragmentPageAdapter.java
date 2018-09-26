package com.example.esma.androidlogin;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class simpleFragmentPageAdapter extends FragmentPagerAdapter{
    private String [] tabTitle = new String[]{"Malzemeye Göre","Tarifler","Bugün"};
    Context context;

    public simpleFragmentPageAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public android.support.v4.app.Fragment getItem(int position) {
        if(position==0) {
            FragmentMaterial fragmentDemo = new FragmentMaterial();
            return fragmentDemo;
        }else{
            FragmentTarifler fragmentDemo2 = new FragmentTarifler();
            return fragmentDemo2;

        }

    }

    @Override
    public int getCount() {
        return tabTitle.length;

    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitle[position];
    }
}
