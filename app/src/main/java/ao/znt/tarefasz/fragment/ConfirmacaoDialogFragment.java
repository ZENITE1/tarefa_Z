package ao.znt.tarefasz.fragment;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;

import ao.znt.tarefasz.R;

public class ConfirmacaoDialogFragment extends DialogFragment implements DialogInterface.OnClickListener {
            private ConfirmancaoDialogFragmentListener ouvido;
            public static ConfirmacaoDialogFragment newInstance(int title){
                ConfirmacaoDialogFragment dialogFrag = new ConfirmacaoDialogFragment();
                Bundle bundle = new Bundle();
                bundle.putInt("titulo",title);
                dialogFrag.setArguments(bundle);


                return dialogFrag;
            }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        int titulo = getArguments().getInt("titulo");
                return new AlertDialog.Builder(getActivity())
                        .setIcon(R.drawable.ic_launcher_background)
                        .setTitle(titulo)
                        .setPositiveButton(android.R.string.ok,this)
                        .setNegativeButton(android.R.string.cancel,this).create();
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
        if(ouvido != null){
            switch (which){
                case DialogInterface.BUTTON_POSITIVE:
                    ouvido.onPositiveClick();
                    break;
                default : ouvido.onNegativeClick();
            }
        }
    }

    public interface ConfirmancaoDialogFragmentListener {

        public void onPositiveClick();
        public void onNegativeClick();
    }

    public void setConfirmacaoDialogFragment(ConfirmancaoDialogFragmentListener listener){
                this.ouvido = listener;

    }
}
