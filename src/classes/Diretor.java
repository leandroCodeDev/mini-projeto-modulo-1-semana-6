package classes;

import enums.CargoFuncionario;

import java.util.Date;

public class Diretor extends Funcionario{

    public Diretor(String nome, Double salario, Date dataContratacao, CargoFuncionario cargo) {
        super(nome, salario, dataContratacao, cargo);

    }

    @Override
    public String toString() {
        return "nome: " +super.getNome()+ " Cargo: " + super.getCargo();
    }
}
