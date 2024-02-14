package classes;

public class Diretor extends Funcionario{
    private int tempoDeCargo;

    public Diretor(String nome, Double salario, int tempoDeCargo) {
        super(nome, salario);
        this.tempoDeCargo = tempoDeCargo;
    }
}
