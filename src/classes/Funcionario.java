package classes;

import Interface.IFuncionario;

import java.util.Date;

public class Funcionario implements IFuncionario {
    private String nome;
    private double salario;

    private Date dataContratacao;

    @Override
    public void promover() {

    }

    public Funcionario(String nome, Double salario, String dataContratacao) {
        this.nome = nome;
        this.salario = salario;
        this.dataContratacao = new Date(dataContratacao);
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

    public Date getDataContratacao() {
        return dataContratacao;
    }

    public void setDataContratacao(Date dataContratacao) {
        this.dataContratacao = dataContratacao;
    }

    /**
     *
     * @param dataContratacao format yyyy-MM-dd
     */
    public void setDataContratacao(String dataContratacao) {
        this.dataContratacao = new Date(dataContratacao);
    }
}
