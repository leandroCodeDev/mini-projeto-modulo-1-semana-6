package classes;

import java.util.ArrayList;

public class Turma
{
    /**
     * Turma - atributos: Lista de alunos, Ano, Curso
     * - métodos: listar alunos, adicionar aluno, remover aluno
     */

    private String ano;

    private Curso curso;
    private ArrayList<Aluno> alunos = new ArrayList<>();


    public ArrayList<Aluno> getAlunos(){
        return this.alunos;
    }

    public void adiconarAluno(Aluno aluno){
        this.alunos.add(aluno);
    }

    public void removerAluno(Aluno aluno){
        this.alunos.remove(aluno);
    }
}
