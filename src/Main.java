import classes.*;
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

//
//        Funcionario funcionario = new Funcionario("Andre", 10000.00, "2024-02-10", CargoFuncionario.INICIANTE);
//        System.out.println(funcionario.toString());
//        System.out.println(funcionario.getCargo());
//        funcionario.promover();
//        System.out.println("Funcionario promovido");
//        System.out.println(funcionario.getCargo());
//        funcionario.promover();
//        System.out.println("Funcionario promovido");
//        System.out.println(funcionario.getCargo());
//        funcionario.promover();
//        System.out.println("Funcionario promovido");
//        System.out.println(funcionario.getCargo());
//
//
//
//        System.out.println(funcionario.getId());
//
//        Funcionario funcionario2 = new Funcionario("Andre", 10000.00, "2024-02-10", CargoFuncionario.EXPERIENTE);
//
//
//        System.out.println(funcionario2.getId());
//
//        Professor professor1 = new Professor("Andre", 10000.00, "2024-02-10", "2024-02-10", CargoFuncionario.EXPERIENTE);
//        Professor professor2 = new Professor("Maria", 10000.00, "2024-02-10", "2024-02-10", CargoFuncionario.EXPERIENTE);
//
//
//        DadosProfessores dados = new DadosProfessores();
//
//        dados.adicionarProfessor(professor1);
//        dados.adicionarProfessor(professor2);
//
//        System.out.println(dados.buscarProfessorPeloIndice(1));
//        System.out.println(dados.buscarProfessorPeloID(4));
//
//
//
//


        Universidade uni = new Universidade();



        uni.getDadosTurma().adicionarTurma(new Turma("2024",new Curso("FMT")));
        uni.getDadosTurma().adicionarTurma(new Turma("2023",new Curso("FMT1")));
        uni.getDadosTurma().adicionarTurma(new Turma("2022",new Curso("FMT2")));
        uni.getDadosTurma().adicionarTurma(new Turma("2021",new Curso("FMT3")));

        uni.getDadosProfessores().adicionarProfessor(new Professor("Prof 1", 10.00, "2024-02-02", "2024-02-02", CargoFuncionario.AVANCADO));
        uni.getDadosProfessores().adicionarProfessor(new Professor("Prof 2", 10.00, "2024-02-02", "2024-02-02", CargoFuncionario.EXPERIENTE));
        uni.getDadosProfessores().adicionarProfessor(new Professor("Prof 3", 10.00, "2024-02-02", "2024-02-02", CargoFuncionario.INICIANTE));
        uni.getDadosProfessores().adicionarProfessor(new Professor("Prof 4", 10.00, "2024-02-02", "2024-02-02", CargoFuncionario.AVANCADO));


        uni.getDadosDiretores().adicionarDiretor(new Diretor("Dir 1", 10.00, "2024-02-02", CargoFuncionario.AVANCADO));
        uni.getDadosDiretores().adicionarDiretor(new Diretor("Dir 2", 10.00, "2024-02-02", CargoFuncionario.EXPERIENTE));
        uni.getDadosDiretores().adicionarDiretor(new Diretor("Dir 3", 10.00, "2024-02-02", CargoFuncionario.INICIANTE));
        uni.getDadosDiretores().adicionarDiretor(new Diretor("Dir 4", 10.00, "2024-02-02", CargoFuncionario.AVANCADO));


        uni.getDadosCurso().adicionarCurso(new Curso("FMT",uni.getDadosProfessores().buscarProfessorPeloIndice(0)));
        uni.getDadosCurso().adicionarCurso(new Curso("FMT1",uni.getDadosProfessores().buscarProfessorPeloIndice(1)));
        uni.getDadosCurso().adicionarCurso(new Curso("FMT2",uni.getDadosProfessores().buscarProfessorPeloIndice(2)));
        uni.getDadosCurso().adicionarCurso(new Curso("FMT3",uni.getDadosProfessores().buscarProfessorPeloIndice(0)));

        uni.getDadosAlunos().adicionarAluno(new Aluno("aluno 1","2024-02-02"));
        uni.getDadosAlunos().adicionarAluno(new Aluno("aluno 2","2024-03-03"));
        uni.getDadosAlunos().adicionarAluno(new Aluno("aluno 3","2024-04-04"));
        uni.getDadosAlunos().adicionarAluno(new Aluno("aluno 5","2024-06-06"));
        uni.getDadosAlunos().adicionarAluno(new Aluno("aluno 4","2024-05-05"));
        uni.getDadosAlunos().adicionarAluno(new Aluno("aluno 6","2024-07-09"));


        uni.setSessaoAberta(true);

//        uni.setAlunoLogado(new Aluno("aluno", "2024-02-02"));
//        uni.getAlunoLogado().adicionarCurso(uni.getDadosCurso().buscarCursoPeloIndice(0));
//        uni.getAlunoLogado().adicionarCurso(uni.getDadosCurso().buscarCursoPeloIndice(1));
//        uni.getAlunoLogado().setMatricula(StatusMatricula.FORMADO);
//        uni.getAlunoLogado().setMatricula(StatusMatricula.TRANCADO);

        uni.setFuncionarioLogado(uni.getDadosProfessores().buscarProfessorPeloIndice(0));

        //        uni.setFuncionarioLogado(uni.getDadosDiretores().buscarDiretorPeloIndice(0));
        uni.start();


    }
}