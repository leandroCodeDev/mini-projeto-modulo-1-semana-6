package classes;

public class Curso {

    private String nome;
    private Professor professor;

    public Curso (String nome){
        this.nome = nome;
    }

    public Curso (String nome, Professor professor){
        this.nome = nome;
        this.professor = professor;
    }

    public String getNome() {
        return nome;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }


    @Override
    public String toString() {
        return "Curso nome: "+this.nome;
    }
}
