package com.human.runningup.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.human.runningup.Adaptadores.AdaptadorViewPager;
import com.human.runningup.C1308R;
import com.human.runningup.Calcular_IMC;
import com.human.runningup.Listado_IMC;

public class IMC_Fragment extends Fragment {
    AdaptadorViewPager Adaptador;
    EditText Altura;
    Button BTN_CALCULAR_IMC;
    TextView IMC;
    EditText Peso;
    SeekBar SeekBar_Peso;
    SeekBar Seekbar_Altura;
    TabLayout tabLayout;
    ViewPager2 viewPager2;

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(C1308R.layout.fragment_i_m_c_, viewGroup, false);
        this.viewPager2 = (ViewPager2) inflate.findViewById(C1308R.C1311id.View_Pager_IMC);
        this.tabLayout = (TabLayout) inflate.findViewById(C1308R.C1311id.Tab_Layout_IMC);
        AdaptadorViewPager adaptadorViewPager = new AdaptadorViewPager(getActivity().getSupportFragmentManager(), getLifecycle());
        this.Adaptador = adaptadorViewPager;
        adaptadorViewPager.AgregarFragments(new Calcular_IMC());
        this.Adaptador.AgregarFragments(new Listado_IMC());
        this.viewPager2.setAdapter(this.Adaptador);
        new TabLayoutMediator(this.tabLayout, this.viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            public void onConfigureTab(TabLayout.Tab tab, int i) {
                if (i == 0) {
                    tab.setText((CharSequence) "Calcular IMC");
                } else if (i == 1) {
                    tab.setText((CharSequence) "Listado IMC");
                }
            }
        }).attach();
        return inflate;
    }
}
