package classes;

import enums.StatusMatricula;
import helper.DataHelper;
import java.util.ArrayList;
import java.util.Date;

public class Aluno {

    private String nome;

    private Date dataNascimento;
    private ArrayList<Curso> cursos = new ArrayList<>();
    private StatusMatricula matricula;

    public Aluno(String nome, Date dataNascimento) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.matricula = StatusMatricula.ATIVO;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setCursos(ArrayList<Curso> cursos) {
        this.cursos = cursos;
    }

    public ArrayList<Curso> getCursos() {
        return this.cursos;
    }

    public StatusMatricula getMatricula() {
        return matricula;
    }

    public void setMatricula(StatusMatricula matricula) {
        this.matricula = matricula;
    }

    public void adicionarCurso(Curso curso) {
        this.cursos.add(curso);
    }

    public void removerCurso(Curso curso) {
        this.cursos.remove(curso);
    }

    public void removerCurso(int indice) {
        this.cursos.remove(this.cursos.get(indice));
    }


    public boolean trancarMatricula() {
        if (this.matricula == StatusMatricula.TRANCADO) {
            return false;
        }
        this.matricula = StatusMatricula.TRANCADO;
        return true;
    }

    public boolean ativarMatricula() {
        if (this.matricula == StatusMatricula.ATIVO) {
            return false;
        }
        this.matricula = StatusMatricula.ATIVO;
        return true;
    }


    @Override
    public String toString() {
        return "Aluno [nome=" + nome + ", dataNascimento=" + DataHelper.converterDataParaString(dataNascimento) + " Matricula: " + matricula.getSituacao() + " Matricula descrição: " + matricula.getDescricao() + "]";
    }

    public void listarCursoMatriculados() {
        System.out.println("*** Lista de Cursos matriculados ***");
        for (int i = 0; i < cursos.size(); i++) {
            System.out.println("ID: " + i + " - " + cursos.get(i).toString());
        }
    }
}
