package ao.znt.tarefasz.modelos.sala.materia;

import ao.znt.tarefasz.modelos.sala.Conteudo;
import ao.znt.tarefasz.modelos.sala.TipoDeConteudo;

public class Motivacao extends Conteudo {
    private String paragrafo;
    public Motivacao(){
        setTipoDeConteudo(TipoDeConteudo.MOTIVACAO);
    }

    public String getParagrafo() {
        return paragrafo;
    }

    public void setParagrafo(String paragrafo) {
        this.paragrafo = paragrafo;
    }
}
