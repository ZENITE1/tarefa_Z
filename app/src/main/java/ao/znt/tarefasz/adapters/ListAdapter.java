package ao.znt.tarefasz.adapters;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import ao.znt.tarefasz.R;

public class ListAdapter extends ArrayAdapter<String> {
    LayoutInflater inflater;

    public ListAdapter(Context context, List<String> temas/*aulas**/){
        super(context,0,temas);
        inflater = LayoutInflater.from(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView == null){
            convertView = inflater.inflate(R.layout.item_list,null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        String tema = (String) getItem(position);
        //pintar de acorddo com o numero da aula e settar a img
        viewHolder.texto.setText(tema);
        viewHolder.imageView.setImageResource(R.drawable.email);
        switch (position){
            case 0 :
                viewHolder.layout2.setBackgroundResource(R.drawable.back_1_2);
                viewHolder.layout1.setCardBackgroundColor(getContext().getResources().getColor(R.color.clor_1_1));
                break;
            case 1:
                viewHolder.layout2.setBackgroundResource(R.drawable.back_2_2);
                viewHolder.layout1.setCardBackgroundColor(getContext().getResources().getColor(R.color.clor_2_1));
                break;
            case 2:
                viewHolder.layout2.setBackgroundResource(R.drawable.back_3_2);
                viewHolder.layout1.setCardBackgroundColor(getContext().getResources().getColor(R.color.clor_3_1));
                break;
            case 3:
                viewHolder.layout2.setBackgroundResource(R.drawable.back_4_2);
                viewHolder.layout1.setCardBackgroundColor(getContext().getResources().getColor(R.color.clor_4_1));
                break;
            case 4:
                viewHolder.layout2.setBackgroundResource(R.drawable.back_5_2);
                viewHolder.layout1.setCardBackgroundColor(getContext().getResources().getColor(R.color.clor_5_1));
                break;
            case 5:
                viewHolder.layout2.setBackgroundResource(R.drawable.back_6_2);
                viewHolder.layout1.setCardBackgroundColor(getContext().getResources().getColor(R.color.clor_6_1));
                break;
            case 6:
                viewHolder.layout2.setBackgroundResource(R.drawable.back_7_2);
                viewHolder.layout1.setCardBackgroundColor(getContext().getResources().getColor(R.color.clor_7_1));
                break;
            case 7:
                viewHolder.layout2.setBackgroundResource(R.drawable.back_8_2);
                viewHolder.layout1.setCardBackgroundColor(getContext().getResources().getColor(R.color.clor_8_1));
                break;
        }


        return convertView;
    }
    private class ViewHolder{
        TextView texto;
        ImageView imageView;
        LinearLayout layout2;
        CardView layout1;// setar o cardBackgroundcolor para as colors 1.1

        private ViewHolder(View view){
            texto = (TextView) view.findViewById(R.id.textView_item_list);
            imageView = (ImageView) view.findViewById(R.id.imageView_item_list);
            layout1 = (CardView) view.findViewById(R.id.background1);
            layout2 = (LinearLayout) view.findViewById(R.id.background2);
        }
    }
}
