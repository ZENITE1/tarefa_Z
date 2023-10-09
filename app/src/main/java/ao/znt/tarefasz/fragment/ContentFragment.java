package ao.znt.tarefasz.fragment;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

import ao.znt.tarefasz.R;
import ao.znt.tarefasz.adapters.FragAdapter;
import ao.znt.tarefasz.modelos.sala.Aula;
import ao.znt.tarefasz.modelos.sala.Conteudo;
import ao.znt.tarefasz.modelos.sala.materia.Motivacao;

public class ContentFragment extends Fragment {
    public final static String ARG_POSITION = "position";
    int mCorrentPosition = -1;
    ViewPager viewPager;
    PagerAdapter pagerAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,  Bundle savedInstanceState) {

        if(savedInstanceState != null){
            mCorrentPosition = savedInstanceState.getInt(ARG_POSITION);
        }
        return inflater.inflate(R.layout.activity_tab_code,container,false);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onStart() {
        super.onStart();
        Bundle bundle = getArguments();
        if(bundle != null){
            updateContent(bundle.getInt(ARG_POSITION));
        }else if(mCorrentPosition != -1){
            updateContent(mCorrentPosition);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(ARG_POSITION,mCorrentPosition);
    }
    public void updateContent(int position){/*este code estara no update*/
        //passar os conteudos das fases da aula pelo metodo newInstance(Conteudo)
        Resources resources = getResources();
        Motivacao m = new Motivacao();
        m.setParagrafo(resources.getString(R.string.content));
        List<Conteudo> conteudos = new ArrayList<>();
        String obj1 = resources.getString(R.string.obj1);
        String obj2 = resources.getString(R.string.obj2);
        conteudos.add(m);
        Aula aula = new Aula(resources.getString(R.string.tema),conteudos);
        aula.setObj2(obj2);
        aula.setObj1(obj1);

        FragAdapter fragAdapter = new FragAdapter(getChildFragmentManager());
        fragAdapter.add(FragMotivacao.newInstance(position,aula),resources.getString(R.string.tab_1));
        fragAdapter.add(TextFrag.newInstance(2),resources.getString(R.string.tab_2));
        fragAdapter.add(TextFrag.newInstance(3),resources.getString(R.string.tab_3));
        fragAdapter.add(TextFrag.newInstance(4),resources.getString(R.string.tab_4));

        viewPager = getActivity().findViewById(R.id.viewpager);
        viewPager.setAdapter(fragAdapter);
        TabLayout tabLayout = getActivity().findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        switch (position){
            case 0 : tabLayout.setBackgroundColor(getResources().getColor(R.color.clor_1_1));
                     tabLayout.setTabTextColors(getResources().getColor(R.color.white),getResources().getColor(R.color.clor_1_2));
            break;
            case 1 : tabLayout.setBackgroundColor(getResources().getColor(R.color.clor_2_1));
                tabLayout.setTabTextColors(getResources().getColor(R.color.white),getResources().getColor(R.color.clor_1_2));
            break;
            case 2 : tabLayout.setBackgroundColor(getResources().getColor(R.color.clor_3_1));
                tabLayout.setTabTextColors(getResources().getColor(R.color.white),getResources().getColor(R.color.clor_3_2));
            break;
            case 3 : tabLayout.setBackgroundColor(getResources().getColor(R.color.clor_4_1));
                tabLayout.setTabTextColors(getResources().getColor(R.color.white),getResources().getColor(R.color.clor_4_2));
            break;
            case 4 : tabLayout.setBackgroundColor(getResources().getColor(R.color.clor_5_1));
                tabLayout.setTabTextColors(getResources().getColor(R.color.white),getResources().getColor(R.color.clor_5_2));
            break;
            case 5 : tabLayout.setBackgroundColor(getResources().getColor(R.color.clor_6_1));
                tabLayout.setTabTextColors(getResources().getColor(R.color.white),getResources().getColor(R.color.clor_6_2));
            break;
            case 6 : tabLayout.setBackgroundColor(getResources().getColor(R.color.clor_7_1));
                tabLayout.setTabTextColors(getResources().getColor(R.color.white),getResources().getColor(R.color.clor_7_2));
            break;
            case 7 : tabLayout.setBackgroundColor(getResources().getColor(R.color.clor_8_1));
                tabLayout.setTabTextColors(getResources().getColor(R.color.white),getResources().getColor(R.color.clor_8_2));
            break;
            default: tabLayout.setBackgroundColor(getResources().getColor(R.color.white));//implementar um random e usar os case existentes
                break;
        }

        mCorrentPosition = position;
    }
}
