package com.human.runningup.Adaptadores;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import java.util.ArrayList;

public class AdaptadorViewPager extends FragmentStateAdapter {
    ArrayList<Fragment> ArrayFragments = new ArrayList<>();

    public AdaptadorViewPager(FragmentManager fragmentManager, Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    public Fragment createFragment(int i) {
        return this.ArrayFragments.get(i);
    }

    public int getItemCount() {
        return this.ArrayFragments.size();
    }

    public void AgregarFragments(Fragment fragment) {
        this.ArrayFragments.add(fragment);
    }
}
