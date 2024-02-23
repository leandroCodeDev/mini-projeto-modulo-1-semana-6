package classes.dados;

import classes.Curso;
import classes.Diretor;
import classes.Professor;
import excecoes.BuscaVazia;
import helper.ArrayHelper;

import java.util.ArrayList;

public class DadosDiretores {
    private ArrayList<Diretor> diretores = new ArrayList<>();

    public void adicionarDiretor(Diretor diretor) throws Exception {
        boolean alunoExiste = ArrayHelper.objetoExiste(diretores, diretor);
        if(alunoExiste){
            throw new Exception("Curso ja existe dentro da univercidade");
        }
        for(Diretor d: diretores){
            if(diretor.getNome().equals(d.getNome())
                && d.getId() == diretor.getId()
            ){
                throw new Exception("Curso ja existe dentro da univercidade");
            }
        }
        diretores.add(diretor);
    }

    public void removerDiretor(Diretor diretor) {
        diretores.remove(diretor);

    }

    public Diretor buscarDiretorPeloID(int id) throws BuscaVazia {
        for (Diretor diretor: diretores){
            if (diretor.getId() == id){
                return diretor;
            }
        }
        throw  new BuscaVazia("Busca não retornou nenhum item");
    }

    public Diretor buscarDiretorPeloIndice(int index){
        if (diretores.size() < index){
            return null;
        }
        return diretores.get(index);
    }

    public void listar() {
        System.out.println("*** Lista de Diretores ***");
        for (int i = 0; i < diretores.size(); i++) {
            System.out.println("ID: "+i+" - " + diretores.get(i).toString());
        }
    }

    public Diretor buscaPeloNome(String nome){
        for (Diretor a : diretores) {
            if (a.getNome().equals(nome)) {
                return a;
            }
        }
        return null;
    }
}
