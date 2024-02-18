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

    public ArrayList<Aluno> getAlunos() {
        return alunos;
    }

    public void listar() {
        System.out.println("*** Lista de Alunos da Faculdade ***");
        for (int i = 0; i < alunos.size(); i++) {
            System.out.println("ID: "+i+" - " + alunos.get(i).toString());
        }
    }

    public Aluno buscaPeloNome(String nome){
        for (Aluno a : alunos) {
            if (a.getNome().equals(nome)) {
                return a;
            }
        }
        return null;
    }
}
