package classes;

import enums.CargoFuncionario;

public class Diretor extends Funcionario{

    public Diretor(String nome, Double salario, String dataContratacao, CargoFuncionario cargo) {
        super(nome, salario, dataContratacao, cargo);

    }

    @Override
    public String toString() {
        return "nome: " +super.getNome()+ " Cargo: " + super.getCargo();
    }
}
