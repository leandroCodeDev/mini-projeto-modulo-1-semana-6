package classes.dados;

import classes.Diretor;
import excecoes.BuscaVazia;

import java.util.ArrayList;

public class DadosDiretores {
    private ArrayList<Diretor> diretores = new ArrayList<>();

    public void adicionarDiretor(Diretor diretor) {
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

}
