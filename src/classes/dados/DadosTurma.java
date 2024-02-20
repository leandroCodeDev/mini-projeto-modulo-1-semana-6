package classes.dados;

import classes.Turma;

import java.util.ArrayList;

public class DadosTurma {
    private final ArrayList<Turma> turmas = new ArrayList<>();

    public void adicionarTurma(Turma turma) {
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