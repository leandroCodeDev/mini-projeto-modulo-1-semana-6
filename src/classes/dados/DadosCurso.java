package classes.dados;

import classes.Curso;

import java.util.ArrayList;

public class DadosCurso {
    private final ArrayList<Curso> cursos = new ArrayList<>();

    public void adicionarCurso(Curso curso) {
        cursos.add(curso);
    }

    public void removerCurso(Curso curso) {
        cursos.remove(curso);
    }

    public Curso buscarCursoPeloIndice(int index){
        if (cursos.size() < index){
            return null;
        }
        return cursos.get(index);
    }

    public void listar() {
        System.out.println("*** Lista de Cursos ***");
        for (int i = 0; i < cursos.size(); i++) {
            System.out.println("ID: "+i+" - " + cursos.get(i).toString());
        }
    }

    public ArrayList<Curso> getCursos() {
        return cursos;
    }
}