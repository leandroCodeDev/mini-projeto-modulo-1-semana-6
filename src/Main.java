import classes.Funcionario;
import classes.Professor;
import classes.dados.DadosProfessores;
import enums.CargoFuncionario;
import enums.StatusMatricula;
import excecoes.BuscaVazia;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws BuscaVazia {
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



        System.out.println(funcionario.getId());

        Funcionario funcionario2 = new Funcionario("Andre", 10000.00, "2024-02-10", CargoFuncionario.EXPERIENTE);


        System.out.println(funcionario2.getId());

        Professor professor1 = new Professor("Andre", 10000.00, "2024-02-10", "2024-02-10", CargoFuncionario.EXPERIENTE);
        Professor professor2 = new Professor("Maria", 10000.00, "2024-02-10", "2024-02-10", CargoFuncionario.EXPERIENTE);


        DadosProfessores dados = new DadosProfessores();

        dados.adicionarProfessor(professor1);
        dados.adicionarProfessor(professor2);

        System.out.println(dados.buscarProfessorPeloIndice(1));
        System.out.println(dados.buscarProfessorPeloID(4));

    }
}