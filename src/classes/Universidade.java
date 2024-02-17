package classes;

import classes.dados.*;
import enums.CargoFuncionario;

import java.util.Scanner;

public class Universidade {

    private boolean sessaoAberta;
    private Aluno alunoLogado;
    private Funcionario funcionarioLogado;
    private DadosAlunos dadosAlunos;
    private DadosProfessores dadosProfessores;
    private DadosDiretores dadosDiretores;
    private DadosCurso dadosCurso;
    private DadosTurma dadosTurma;


    public boolean isSessaoAberta() {
        return sessaoAberta;
    }

    public void setSessaoAberta(boolean sessaoAberta) {
        this.sessaoAberta = sessaoAberta;
    }

    public Aluno getAlunoLogado() {
        return alunoLogado;
    }

    public void setAlunoLogado(Aluno alunoLogado) {
        this.alunoLogado = alunoLogado;
    }

    public Funcionario getFuncionarioLogado() {
        return funcionarioLogado;
    }

    public void setFuncionarioLogado(Funcionario funcionarioLogado) {
        this.funcionarioLogado = funcionarioLogado;
    }

    public DadosAlunos getDadosAlunos() {
        return dadosAlunos;
    }

    public void setDadosAlunos(DadosAlunos dadosAlunos) {
        this.dadosAlunos = dadosAlunos;
    }

    public DadosProfessores getDadosProfessores() {
        return dadosProfessores;
    }

    public void setDadosProfessores(DadosProfessores dadosProfessores) {
        this.dadosProfessores = dadosProfessores;
    }

    public DadosDiretores getDadosDiretores() {
        return dadosDiretores;
    }

    public void setDadosDiretores(DadosDiretores dadosDiretores) {
        this.dadosDiretores = dadosDiretores;
    }

    public DadosCurso getDadosCurso() {
        return dadosCurso;
    }

    public void setDadosCurso(DadosCurso dadosCurso) {
        this.dadosCurso = dadosCurso;
    }

    public DadosTurma getDadosTurma() {
        return dadosTurma;
    }

    public void setDadosTurma(DadosTurma dadosTurma) {
        this.dadosTurma = dadosTurma;
    }

    public Universidade() {
        sessaoAberta = false;
        alunoLogado = null;
        funcionarioLogado = null;
        dadosAlunos = new DadosAlunos();
        dadosProfessores = new DadosProfessores();
        dadosDiretores = new DadosDiretores();
        dadosCurso = new DadosCurso();
        dadosTurma = new DadosTurma();

    }


    public void start() {
        if (sessaoAberta) {
            if (this.alunoLogado != null) {
                this.menuAluno();
            } else {
                if (funcionarioLogado instanceof Diretor) {
                    this.menuDiretor();
                } else {
                    this.menuProfessor();
                }
            }
        } else {
            this.selecionarMenu();
        }
    }

    private void selecionarMenu() {
        System.out.println("seleciona menu");
    }


    public void menuAluno() {
        System.out.println("menu aluno");
    }

    public void menuProfessor() {
        System.out.println("menu professor");
    }

    public void menuDiretor() {
        System.out.println("Seja bem vindo:" + this.funcionarioLogado.getNome());
        //teste com sub menu
        System.out.println("1 - Listar Turma");
        System.out.println("2 - Lista Curso");
        System.out.println("3 - Lista Professor");
        System.out.println("4 - Lista Diretores");
        System.out.println("5 - Criar Curso");
        System.out.println("6 - Criar Turma");
        System.out.println("7 - Criar Professor");

        Scanner scan = new Scanner(System.in);
        System.out.println("Selecine uma opção:");
        int opcao = scan.nextInt();

        switch (opcao) {
            case (1):
                this.dadosTurma.listar();
                break;
            case (2):
                this.dadosCurso.listar();
                break;
            case (3):
                this.dadosProfessores.listar();
                break;
            case (4):
                this.dadosDiretores.listar();
                break;
            case (5):
                this.criarCurso();
                break;
            case (6):
                this.criarTurma();
                break;
            case (7):
                this.criarProfessor();

        }
    }

    public void criarCurso() {
        if (funcionarioLogado instanceof Diretor) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Cadastro de novo curso:");
            System.out.println("Informe o nome do curso:");
            String nome = scan.nextLine();

            System.out.println("Selecione o ID do professor responsável pelo curso:");
            this.dadosProfessores.listar();
            int id = scan.nextInt();
            Professor professor = dadosProfessores.buscarProfessorPeloIndice(id);
            Curso novoCurso = new Curso(nome, professor);
            this.dadosCurso.adicionarCurso(novoCurso);
            System.out.println("Curso cadastrado com sucesso.");
            this.dadosCurso.listar();
        } else {
            System.out.println("Você não tem autorização.");
        }
    }

    public void criarTurma() {
        if (funcionarioLogado instanceof Diretor) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Cadastre a nova turma:");
            System.out.println("Informe o ano da turma:");
            String nome = scan.nextLine();

            System.out.println("Selecione o ID do curso da turma:");
            this.dadosCurso.listar();
            int id = scan.nextInt();
            Curso curso = dadosCurso.buscarCursoPeloIndice(id);
            Turma novaTurma = new Turma(nome, curso);
            this.dadosTurma.adicionarTurma(novaTurma);
            System.out.println("Turma cadastrada com sucesso.");
            this.dadosTurma.listar();
        } else {
            System.out.println("Você não tem autorização.");
        }


        /**
         * escolher turma
         */

    }
   public void criarProfessor(){
       if (funcionarioLogado instanceof Diretor) {
           Scanner scan = new Scanner(System.in);
           System.out.println("Cadastre o novo professor:");
           System.out.println("Informe o nome do professor:");
           String nome = scan.nextLine();
           System.out.println("Informe o salário do professor:");
           double salario = scan.nextDouble();
           System.out.println("Informe a data de anivesário do professor:");
           System.out.println("No formato aaaa-mm-dd: Ex: 2024-12-29");
           String data = scan.next();
           System.out.println("Informe a data de contratação do professor:");
           System.out.println("No formato aaaa-mm-dd: Ex: 2024-12-29");
           String dataContratacao = scan.next();
           System.out.println("Selecione a senioridade do professor:");
           System.out.println("1 - Iniciante: ");
           System.out.println("2 - Avançado: ");
           System.out.println("3 - Experiente: ");
           int opcaoCargo = scan.nextInt();

           CargoFuncionario cargoFuncionario = null;

           switch (opcaoCargo){
               case 1:
                   cargoFuncionario = CargoFuncionario.INICIANTE;
                   break;
               case 2:
                   cargoFuncionario = CargoFuncionario.AVANCADO;
                   break;
               case 3:
                   cargoFuncionario = CargoFuncionario.EXPERIENTE;
                   break;
           }

           Professor professor = new Professor(nome, salario, data, dataContratacao, cargoFuncionario);
           this.dadosProfessores.adicionarProfessor(professor);

           System.out.println("Professor cadastrado com sucesso.");
           this.dadosProfessores.listar();
       } else {
           System.out.println("Você não tem autorização.");
       }

   }

}