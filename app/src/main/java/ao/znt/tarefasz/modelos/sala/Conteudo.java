package ao.znt.tarefasz.modelos.sala;

public abstract class Conteudo {
    private String topico;
    private TipoDeConteudo tipoDeConteudo;//icon e cor varia de acordo com o tipo de conteudo

    public Conteudo(){};

    public String getTopico() {
        return topico;
    }

    public void setTopico(String topico) {
        this.topico = topico;
    }

    public TipoDeConteudo getTipoDeConteudo() {
        return tipoDeConteudo;
    }

    public void setTipoDeConteudo(TipoDeConteudo tipoDeConteudo) {
        this.tipoDeConteudo = tipoDeConteudo;
    }
}
