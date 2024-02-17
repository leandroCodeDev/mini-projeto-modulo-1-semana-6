package classes;

import java.util.ArrayList;

public class Turma{

    private String ano;

    private Curso curso;
    private ArrayList<Aluno> alunos = new ArrayList<>();

    public Turma(String ano, Curso curso){
        this.ano = ano;
        this.curso = curso;
    }

    public Turma(String ano, Curso curso,ArrayList<Aluno> alunos){
        this.ano = ano;
        this.curso = curso;
        this.alunos = alunos;
    }



    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public void setAlunos(ArrayList<Aluno> alunos) {
        this.alunos = alunos;
    }

    public ArrayList<Aluno> getAlunos(){
        return this.alunos;
    }

    public void adiconarAluno(Aluno aluno){
        this.alunos.add(aluno);
    }

    public void removerAluno(Aluno aluno){
        this.alunos.remove(aluno);
    }

    public void removerAluno(int indece) {
        alunos.remove(alunos.get(indece));
    }

    public void listarAlunos() {
        System.out.println("*** Lista de Alunos da turma ***");
        for (int i = 0; i < alunos.size(); i++) {
            System.out.println("ID: "+i+" - " + alunos.get(i).toString());
        }
    }

    @Override
    public String toString() {
        return "Turma do curso "+this.curso.getNome()+" do ano "+ this.ano;
    }



}
