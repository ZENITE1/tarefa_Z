package ao.znt.tarefasz.modelos.sala.materia;

import java.util.HashMap;
import java.util.Map;

import ao.znt.tarefasz.modelos.sala.Conteudo;
import ao.znt.tarefasz.modelos.sala.TipoDeConteudo;

public class Avaliacao extends Conteudo {
    Map<String,String> perguntas;

    public Avaliacao(){
        setTipoDeConteudo(TipoDeConteudo.AVALIACAO);
        perguntas = new HashMap<String,String>();
    }
}
