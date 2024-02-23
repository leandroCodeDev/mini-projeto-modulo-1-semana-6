package classes.dados;

import classes.Aluno;
import classes.Curso;
import helper.ArrayHelper;

import java.util.ArrayList;

public class DadosCurso {
    private final ArrayList<Curso> cursos = new ArrayList<>();

    public void adicionarCurso(Curso curso) throws Exception {
        boolean alunoExiste = ArrayHelper.objetoExiste(cursos, curso);
        if(alunoExiste){
            throw new Exception("Curso ja existe dentro da univercidade");
        }
        for(Curso c: cursos){
            if(curso.getNome().equals(c.getNome())){
                throw new Exception("Curso ja existe dentro da univercidade");
            }
        }
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