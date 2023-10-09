package ao.znt.tarefasz.fragment;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.List;

import ao.znt.tarefasz.R;
import ao.znt.tarefasz.modelos.Programa;
import ao.znt.tarefasz.modelos.sala.Aula;

public class ListFragment extends android.support.v4.app.ListFragment{
    private OnContentSelectedListener mCallback;
    private Programa programa;

    public ListFragment(){}
    @SuppressLint("ValidFragment")
    public ListFragment(Programa programa){
        this.programa = programa;
    }
    @RequiresApi(api = Build.VERSION_CODES.R)
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onResume() {
        super.onResume();
        ListAdapter adapter = new ao.znt.tarefasz.adapters.ListAdapter(getContext(),programa.getTemas());
        setListAdapter(adapter);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onStart() {
        super.onStart();
        if(getFragmentManager().findFragmentById(R.id.sumarioConteudo)!=null){
            getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        }
    }

    public interface OnContentSelectedListener{
        public void onContentSelected(int position);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mCallback = (OnContentSelectedListener) activity;
        }catch (ClassCastException e){
            throw new ClassCastException(activity.toString()+" preciza implementar OnContentSelectedListener");
        }
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        mCallback.onContentSelected(position);
        getListView().setItemChecked(position, true);
    }
}
