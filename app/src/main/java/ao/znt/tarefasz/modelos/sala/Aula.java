package ao.znt.tarefasz.modelos.sala;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class Aula implements Parcelable {
    private String professor;
    private String tema;
    private String obj1,obj2;
    private List<Conteudo> conteudos;

    public Aula(String tema,List<Conteudo> conteudos){
        this.tema = tema;
        this.conteudos = conteudos;
    }

    protected Aula(Parcel in) {
        professor = in.readString();
        tema = in.readString();
        obj1 = in.readString();
        obj2 = in.readString();
    }

    public static final Creator<Aula> CREATOR = new Creator<Aula>() {
        @Override
        public Aula createFromParcel(Parcel in) {
            return new Aula(in);
        }

        @Override
        public Aula[] newArray(int size) {
            return new Aula[size];
        }
    };

    public List<Conteudo> getConteudos() {
        return conteudos;
    }

    public void setConteudos(List<Conteudo> conteudos) {
        this.conteudos = conteudos;
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getObj1() {
        return obj1;
    }

    public void setObj1(String obj1) {
        this.obj1 = obj1;
    }

    public String getObj2() {
        return obj2;
    }

    public void setObj2(String obj2) {
        this.obj2 = obj2;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(professor);
        dest.writeString(tema);
        dest.writeString(obj1);
        dest.writeString(obj2);
    }
}
