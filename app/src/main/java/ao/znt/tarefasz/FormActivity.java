package ao.znt.tarefasz;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import ao.znt.tarefasz.modelos.sala.Aula;
import ao.znt.tarefasz.modelos.sala.Conteudo;
import ao.znt.tarefasz.modelos.sala.materia.Motivacao;

public class FormActivity extends AppCompatActivity {
    List<Aula> aulas = new ArrayList<>();
    TextView edProf,edTema, edObj1,edObj2,edMot;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_form);
        edProf = findViewById(R.id.layoutFormEdProfessor);
        edTema = findViewById(R.id.layoutFormEdTema);
        edObj1 = findViewById(R.id.layoutFormEdObj1);
        edObj2 = findViewById(R.id.layoutFormEdObj2);
        edMot = findViewById(R.id.layoutFormEdMotivacao);
    }
    public void guardar(View view){

        String professor = edProf.getText().toString();
        String tema = edTema.getText().toString();
        String obj1 = edObj1.getText().toString();
        String obj2 = edObj2.getText().toString();
        String mot = edMot.getText().toString();

        Motivacao conteudo = new Motivacao();
        conteudo.setParagrafo(mot);
        List<Conteudo> conteudos = new ArrayList<>();
        conteudos.add(conteudo);
        Aula aula = new Aula(tema,conteudos);
        aula.setProfessor(professor);
        aula.setObj1(obj1);
        aula.setObj2(obj2);
        aulas.add(aula);
        Toast.makeText(this, "Aula add "+tema, Toast.LENGTH_SHORT).show();

    }
    public void aulas(View view){
        Intent intent = new Intent(this,TarefasActivity.class);
        /*passar os conteudos*/
        intent.putParcelableArrayListExtra("aulas", (ArrayList<? extends Parcelable>) aulas);
        startActivity(intent);
        //finish();
        Toast.makeText(this, "Ir para Aulas", Toast.LENGTH_SHORT).show();
    }
}