package ao.znt.tarefasz;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import ao.znt.tarefasz.fragment.ContentFragment;
import ao.znt.tarefasz.fragment.ListFragment;
import ao.znt.tarefasz.modelos.Programa;
import ao.znt.tarefasz.modelos.sala.Aula;

public class TarefasActivity extends FragmentActivity implements ListFragment.OnContentSelectedListener {
    List<Aula> aulas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sumario_view);
        Bundle extra = getIntent().getExtras();
        if(extra.getParcelableArrayList("aulas")!=null){
            Toast.makeText(this, "nao é null", Toast.LENGTH_SHORT).show();
            aulas = extra.getParcelableArrayList("aulas");
        }else Toast.makeText(this, "é null", Toast.LENGTH_SHORT).show();

        if(findViewById(R.id.fragmentContainer) != null){
            if(savedInstanceState != null){
                return;
            }
            ListFragment primeiroFramgent = new ListFragment(new Programa(aulas));
            primeiroFramgent.setArguments(getIntent().getExtras());
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragmentContainer,primeiroFramgent).commit();
        }
    }

    @Override
    public void onContentSelected(int position) {

        ContentFragment contentFrag = (ContentFragment) getSupportFragmentManager().
                findFragmentById(R.id.sumarioConteudo);
        if(contentFrag != null &&  contentFrag.getActivity() != null){
            contentFrag.updateContent(position);//tela land
        }else {//tela portable
            ContentFragment newcontentFrag = new ContentFragment();
            Bundle bundle = new Bundle();
            bundle.putInt(ContentFragment.ARG_POSITION,position);
            newcontentFrag .setArguments(bundle);
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.fragmentContainer,newcontentFrag);
            transaction.addToBackStack(null);
            transaction.commit();
        }

    }
}
