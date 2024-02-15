package classes;

import enums.StatusMatricula;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Aluno {

    private String nome;

    private Date dataNascimento;
    private ArrayList<Curso> cursos;
    private StatusMatricula matricula;


    /**
     * @param nome
     * @param dataNascimento - Formato yyyy-MM-dd
     */
    public Aluno(String nome, String dataNascimento) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = dateFormat.parse(dataNascimento);
            System.out.println("Parsed Date: " + date);
        } catch (ParseException e) {
            System.out.println("Error parsing date: " + e.getMessage());
        } finally {
            date = new Date();
        }

        this.nome = nome;
        this.dataNascimento = date;
        this.matricula = StatusMatricula.ATIVO;

    }

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


    @Override
    public String toString() {
        return "Aluno [nome=" + nome + ", dataNascimento=" + dataNascimento.toString() + " Matricula: " + matricula.getSituacao() + " Matricula descrição: " + matricula.getDescricao() + "]";
    }
}
