import classes.Funcionario;
import enums.CargoFuncionario;
import enums.StatusMatricula;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
    /**
     * O aluno deve poder selecionar uma turma ao iniciar o programa. Caso não selecione uma turma ele deve ser adicionar pelo diretor a uma turma posteriormente.
     *
     * o diretor deve poder criar uma turma, listar alunos da turma, adicionar alunos e remover alunos da turma
     *
     * Aluno - atributos: Nome, idade
     */


        Funcionario funcionario = new Funcionario("Andre", 10000.00, "2024-02-10", CargoFuncionario.INICIANTE);
        System.out.println(funcionario.toString());
        System.out.println(funcionario.getCargo());
        funcionario.promover();
        System.out.println("Funcionario promovido");
        System.out.println(funcionario.getCargo());
        funcionario.promover();
        System.out.println("Funcionario promovido");
        System.out.println(funcionario.getCargo());
        funcionario.promover();
        System.out.println("Funcionario promovido");
        System.out.println(funcionario.getCargo());



        System.out.println(StatusMatricula.ATIVO);
        System.out.println(StatusMatricula.valueOf("TRANCADO".toUpperCase()));

        StatusMatricula statusMatricula = null; // statusMatricula pode ter apenas os valores do Enum StatusMatricula, e null
        statusMatricula = StatusMatricula.FORMADO;

        StatusMatricula statusMatricula2 = StatusMatricula.TRANCADO;

        // for -> para cada item de uma lista execute o código dentro do for
        // para cada item de valores atribui o item a "value" e executa o codigo
        // StatusMatricula.values() -> retorna todos os valores do enum em lista
        for (StatusMatricula value : StatusMatricula.values()) {
            System.out.println(value.getSituacao());
            System.out.println(value.getDescricao());
        }

        System.out.println(StatusMatricula.getDescricaoPelaSituacao("Ativo"));
    }
}