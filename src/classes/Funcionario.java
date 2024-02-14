package classes;

import Interface.IFuncionario;

public class Funcionario implements IFuncionario {
    private String nome;
    private double salario;

    @Override
    public void promover() {

    }

    public Funcionario(String nome, Double salario) {
        this.nome = nome;
        this.salario = salario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}
