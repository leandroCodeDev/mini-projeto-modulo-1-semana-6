package classes;

import java.util.ArrayList;
import java.util.Date;

public class Aluno {

    private String nome;

    private Date dataNascimento;
    private ArrayList<Curso> cursos;


    /**
     *
     * @param nome
     * @param dataNascimento - Formato yyyy-MM-dd
     */
    public Aluno(String nome, String dataNascimento) {
        this.nome = nome;
        this.dataNascimento = new Date(dataNascimento);
    }

    public Aluno(String nome, Date dataNascimento) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
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

    /**
     * @param dataNascimento - Formato yyyy-MM-dd
     */
    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = new Date(dataNascimento);
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setCursos(ArrayList<Curso> cursos) {
        this.cursos = cursos;
    }

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
