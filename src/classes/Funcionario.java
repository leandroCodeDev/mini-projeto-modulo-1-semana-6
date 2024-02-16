package classes;

import Interface.IFuncionario;
import enums.CargoFuncionario;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Funcionario implements IFuncionario {
    private String nome;
    private double salario;
    private CargoFuncionario cargo;

    private Date dataContratacao;

    @Override
    public void promover() {
        
        switch (this.cargo){
            case CargoFuncionario.INICIANTE:
                this.cargo = CargoFuncionario.AVANCADO;
                break;
            case CargoFuncionario.AVANCADO:
                this.cargo = CargoFuncionario.EXPERIENTE;
                break;
            case CargoFuncionario.EXPERIENTE:
                throw new RuntimeException("Impossivel de promover funcionario "+CargoFuncionario.EXPERIENTE.getLabel());

        }
    }

    public Funcionario(String nome, Double salario, String dataContratacao, CargoFuncionario cargo) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = dateFormat.parse(dataContratacao);
            System.out.println("Parsed Date: " + date);
        } catch (ParseException e) {
            System.out.println("Error parsing date: " + e.getMessage());
        } finally {
            date = new Date();
        }

        this.nome = nome;
        this.salario = salario;
        this.dataContratacao = date;
        this.cargo = cargo;
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

    public String getCargo() {
        return cargo.getLabel();
    }

    public void setCargo(CargoFuncionario cargo) {
        this.cargo = cargo;
    }

    /**
     *
     * @param dataContratacao format yyyy-MM-dd
     */
    public void setDataContratacao(String dataContratacao) {
        this.dataContratacao = new Date(dataContratacao);
    }


    @Override
    public String toString() {
        return "Funcionario [ nome:" + nome + "salario: " + salario +"dataContratacao: " + dataContratacao.toString()+ "cargo: " + cargo.getLabel() +"]";
    }
}
