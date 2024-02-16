package classes.dados;

import classes.Aluno;
import classes.Professor;

import java.util.ArrayList;

public class DadosAlunos {
    private final ArrayList<Aluno> alunos = new ArrayList<>();

    public void adicionarAluno(Aluno aluno) {
        alunos.add(aluno);
    }

    public void removerAluno(Aluno aluno) {
        alunos.remove(aluno);
    }

    public Aluno buscarAlunoPeloIndice(int index){
        if (alunos.size() < index){
            return null;
        }
        return alunos.get(index);
    }
}