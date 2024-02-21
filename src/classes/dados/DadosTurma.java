package classes.dados;

import classes.Professor;
import classes.Turma;
import helper.ArrayHelper;

import java.util.ArrayList;

public class DadosTurma {
    private final ArrayList<Turma> turmas = new ArrayList<>();

    public void adicionarTurma(Turma turma) throws Exception {
        boolean alunoExiste = ArrayHelper.objetoExiste(turmas, turma);
        if(alunoExiste){
            throw new Exception("Curso ja existe dentro da univercidade");
        }
        for(Turma t: turmas){
            if(turma.getAno().equals(t.getAno())){
                throw new Exception("Curso ja existe dentro da univercidade");
            }
        }
        turmas.add(turma);
    }

    public void removerTurma(Turma turma) {
        turmas.remove(turma);
    }

    public void removerTurma(int indece) {
        turmas.remove(turmas.get(indece));
    }

    public Turma buscarTurmaPeloIndice(int index){
        if (turmas.size() < index){
            return null;
        }
        return turmas.get(index);
    }

    public ArrayList<Turma> getTurmas() {
        return turmas;
    }

    public void listar() {
        System.out.println("*** Lista de Turmas ***");
        for (int i = 0; i < turmas.size(); i++) {
            System.out.println("ID: "+i+" - " + turmas.get(i).toString());
        }
    }
}