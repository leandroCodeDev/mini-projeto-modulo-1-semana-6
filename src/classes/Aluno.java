package classes;

import java.util.ArrayList;

public class Aluno {

    private String Nome;
    private ArrayList<Curso> cursos;

    public ArrayList<Curso> getCursos(){
        return this.cursos;
    }

    public void adicionarCurso(Curso curso){
        this.cursos.add(curso);
    }

    public void removerCurso(Curso curso){
        this.cursos.remove(curso);
    }
}
