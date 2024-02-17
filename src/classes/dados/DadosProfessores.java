package classes.dados;

import classes.Funcionario;
import classes.Professor;
import excecoes.BuscaVazia;

import java.util.ArrayList;

public class DadosProfessores {
    private ArrayList<Professor> professores = new ArrayList<>();

    public void adicionarProfessor(Professor professor) {
        professores.add(professor);
    }

    public void removerProfessor(Professor professor) {
        professores.remove(professor);

    }

    public Professor buscarProfessorPeloID(int id) throws BuscaVazia {
        for (Professor professor: professores){
            if (professor.getId() == id){
                return professor;
            }
        }
        throw  new BuscaVazia("Busca não retornou nenhum item");
    }

    public Professor buscarProfessorPeloIndice(int index){
        if (professores.size() < index){
            return null;
        }
        return professores.get(index);
    }

    public void listar() {
        System.out.println("*** Lista de Professores ***");
        for (int i = 0; i < professores.size(); i++) {
            System.out.println("ID: "+i+" - " + professores.get(i).toString());
        }
    }
}
