package classes;

import Interface.IFuncionario;
import enums.CargoFuncionario;
import helper.DataHelper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Funcionario implements IFuncionario {
    private String nome;
    private double salario;
    private CargoFuncionario cargo;
    private Date dataContratacao;

    private static int contador;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int id;
    public static int gerarId(){
        return contador++;
    }

    @Override
    public void promover() {
        
        switch (this.cargo){
            case INICIANTE:
                this.cargo = CargoFuncionario.AVANCADO;
                break;
            case AVANCADO:
                this.cargo = CargoFuncionario.EXPERIENTE;
                break;
            case EXPERIENTE:
                throw new RuntimeException("Impossivel de promover funcionario "+CargoFuncionario.EXPERIENTE.getLabel());

        }
    }

    public Funcionario(String nome, Double salario, Date dataContratacao, CargoFuncionario cargo) {
        this.nome = nome;
        this.salario = salario;
        this.dataContratacao = dataContratacao;
        this.cargo = cargo;
        this.id = ++contador;

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
        return "Funcionario [ nome:" + nome + "salario: " + salario +"dataContratacao: " + DataHelper.converterDataParaString(dataContratacao) + "cargo: " + cargo.getLabel() +"]";
    }
}
