package ao.znt.tarefasz.modelos.sala.materia;

import ao.znt.tarefasz.modelos.sala.Conteudo;
import ao.znt.tarefasz.modelos.sala.TipoDeConteudo;

public class Introducao extends Conteudo {
    private String paragrafoIntrodutorio;
    public Introducao(){
        setTipoDeConteudo(TipoDeConteudo.INTRODUCAO);
    }

    public String getParagrafoIntrodutorio() {
        return paragrafoIntrodutorio;
    }

    public void setParagrafoIntrodutorio(String paragrafoIntrodutorio) {
        this.paragrafoIntrodutorio = paragrafoIntrodutorio;
    }
}
