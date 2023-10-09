package ao.znt.tarefasz.modelos;

import java.util.ArrayList;
import java.util.List;

import ao.znt.tarefasz.modelos.sala.Aula;

public class Programa {
    private List<Aula> aulas;
    private List<String> temas = new ArrayList<>();

    public Programa(List<Aula> aulas){
        this.aulas = aulas;
        for (Aula aula : aulas) {
            temas.add(aula.getTema());
        }
    }

    public List<Aula> getAulas() {
        return aulas;
    }

    public void setAulas(List<Aula> aulas) {
        this.aulas = aulas;
    }

    public List<String> getTemas() {
        return temas;
    }

    public void setTemas(List<String> temas) {
        this.temas = temas;
    }
}
