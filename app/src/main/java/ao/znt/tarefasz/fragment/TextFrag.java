package ao.znt.tarefasz.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import ao.znt.tarefasz.R;
import ao.znt.tarefasz.modelos.Tarefa;

public class TextFrag extends Fragment {
    public final static String ARG_POSITION = "position";
    int mCorrentPosition = -1;

    public TextFrag(){}
    public static TextFrag newInstance(int postion){
        Bundle parameters = new Bundle();
        parameters.putInt(ARG_POSITION, postion);
        TextFrag frag = new TextFrag();
        frag.setArguments(parameters);
        return frag;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View fragView = inflater.inflate(R.layout.shape_aula,container, false);
        //TextView text = (TextView) fragView.findViewById(R.id.content_view);
        //text.setText(String.format(getActivity().getResources().getString(R.string.content))+getArguments().get(ARG_POSITION));

        return fragView;
    }

}
