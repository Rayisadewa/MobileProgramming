package com.dodot.rayisadewa;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.dodot.rayisadewa.fragments.BiodataFragment;
import com.dodot.rayisadewa.fragments.PendidikanFragment;
import com.dodot.rayisadewa.fragments.PengalamanFragment;

public class MyViewPagerAdapter extends FragmentStateAdapter {
    public MyViewPagerAdapter (@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);

    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 1:
                return new PendidikanFragment();
            case 2:
                return new PengalamanFragment();
            default:
                return new BiodataFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
