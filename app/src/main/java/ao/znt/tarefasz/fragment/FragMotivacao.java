package ao.znt.tarefasz.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import ao.znt.tarefasz.R;
import ao.znt.tarefasz.modelos.sala.Aula;
import ao.znt.tarefasz.modelos.sala.Conteudo;
import ao.znt.tarefasz.modelos.sala.TipoDeConteudo;
import ao.znt.tarefasz.modelos.sala.materia.Motivacao;

public class FragMotivacao extends Fragment {
    public final static String ARG_POSITION = "position";
    private static Aula aula;
    int mCorrentPosition = -1;

    public FragMotivacao(){}
    public static FragMotivacao newInstance(int postion, Aula aul){
        aula = aul;
        Bundle parameters = new Bundle();
        parameters.putInt(ARG_POSITION, postion);
        FragMotivacao frag = new FragMotivacao();
        frag.setArguments(parameters);
        return frag;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View fragView = inflater.inflate(R.layout.shape_aula,container, false);
        TextView textTema = (TextView) fragView.findViewById(R.id.shape_aula_motivacao_tema);
        TextView textobj1 = (TextView) fragView.findViewById(R.id.shape_aula_motivacao_obj1);
        TextView textobj2 = (TextView) fragView.findViewById(R.id.shape_aula_motivacao_obj2);
        TextView textModivacao = (TextView) fragView.findViewById(R.id.shape_aula_motivacao_paragrafointrodutorio);
        //////////////////////
        Motivacao motivacao = null;
        Bundle bundle = getArguments();
        mCorrentPosition = bundle.getInt(ARG_POSITION);

        for (Conteudo c : aula.getConteudos()) {
            if(c.getTipoDeConteudo().equals(TipoDeConteudo.MOTIVACAO))
                motivacao = (Motivacao) c;
        }
        if(motivacao != null){
            textTema.setText(aula.getTema());
            textModivacao.setText(motivacao.getParagrafo());
            textobj1.setText(aula.getObj1());
            textobj2.setText(aula.getObj2());
        }
        if(mCorrentPosition!=-1){
          switch (mCorrentPosition){
              case 0 : textTema.setTextColor(getResources().getColor(R.color.clor_1_2));
                       textobj1.setTextColor(getResources().getColor(R.color.clor_1_1));
                       textobj2.setTextColor(getResources().getColor(R.color.clor_1_1));
              break;
              case 1 : textTema.setTextColor(getResources().getColor(R.color.clor_2_2));
                       textobj1.setTextColor(getResources().getColor(R.color.clor_2_1));
                       textobj2.setTextColor(getResources().getColor(R.color.clor_2_1));
              break;
              case 2 : textTema.setTextColor(getResources().getColor(R.color.clor_3_2));
                       textobj1.setTextColor(getResources().getColor(R.color.clor_3_1));
                       textobj2.setTextColor(getResources().getColor(R.color.clor_3_1));
              break;
              case 3 : textTema.setTextColor(getResources().getColor(R.color.clor_4_2));
                       textobj1.setTextColor(getResources().getColor(R.color.clor_4_1));
                       textobj2.setTextColor(getResources().getColor(R.color.clor_4_1));
              break;
              case 4 : textTema.setTextColor(getResources().getColor(R.color.clor_5_2));
                       textobj1.setTextColor(getResources().getColor(R.color.clor_5_1));
                       textobj2.setTextColor(getResources().getColor(R.color.clor_5_1));
              break;
              case 5 : textTema.setTextColor(getResources().getColor(R.color.clor_6_2));
                       textobj1.setTextColor(getResources().getColor(R.color.clor_6_1));
                       textobj2.setTextColor(getResources().getColor(R.color.clor_6_1));
              break;
              case 6 : textTema.setTextColor(getResources().getColor(R.color.clor_7_2));
                       textobj1.setTextColor(getResources().getColor(R.color.clor_7_1));
                       textobj2.setTextColor(getResources().getColor(R.color.clor_7_1));
              break;
              case 7 : textTema.setTextColor(getResources().getColor(R.color.clor_8_2));
                       textobj1.setTextColor(getResources().getColor(R.color.clor_8_1));
                       textobj2.setTextColor(getResources().getColor(R.color.clor_8_1));
              break;
          }

        }
        return fragView;
    }
}
