package classes.dados;

import classes.Curso;
import classes.Professor;
import excecoes.BuscaVazia;
import helper.ArrayHelper;

import java.util.ArrayList;

public class DadosProfessores {
    private ArrayList<Professor> professores = new ArrayList<>();

    public void adicionarProfessor(Professor professor) throws Exception {
        boolean alunoExiste = ArrayHelper.objetoExiste(professores, professor);
        if(alunoExiste){
            throw new Exception("Curso ja existe dentro da univercidade");
        }
        for(Professor p: professores){
            if(professor.getNome().equals(p.getNome())){
                throw new Exception("Curso ja existe dentro da univercidade");
            }
        }
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

    public Professor buscaPeloNome(String nome){
        for (Professor a : professores) {
            if (a.getNome().equals(nome)) {
                return a;
            }
        }
        return null;
    }

    public ArrayList<Professor> getProfessores() {
        return professores;
    }
}
