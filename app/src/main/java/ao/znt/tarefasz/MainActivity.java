package ao.znt.tarefasz;

import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.io.DataOutputStream;

import ao.znt.tarefasz.fragment.ConfirmacaoDialogFragment;

public class MainActivity extends FragmentActivity implements View.OnClickListener, ConfirmacaoDialogFragment.ConfirmancaoDialogFragmentListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.button).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        ConfirmacaoDialogFragment content = ConfirmacaoDialogFragment.newInstance(R.string.app_name);
        content.setConfirmacaoDialogFragment(this);
        content.show(getSupportFragmentManager(),null);

    }

    @Override
    public void onNegativeClick() {
        Toast.makeText(this, android.R.string.cancel, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPositiveClick() {
        Toast.makeText(this, android.R.string.ok, Toast.LENGTH_SHORT).show();
    }
}