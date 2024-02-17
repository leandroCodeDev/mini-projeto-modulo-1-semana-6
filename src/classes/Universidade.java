package classes;

import classes.dados.*;

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
        dadosProfessores= new DadosProfessores();
        dadosDiretores = new DadosDiretores();
        dadosCurso = new DadosCurso();
        dadosTurma = new DadosTurma();

    }


    public void start() {
        if (sessaoAberta) {
            if (this.alunoLogado != null) {
                this.menuAluno();
            }else{
                if (funcionarioLogado instanceof Diretor){
                    this.menuDiretor();
                }else {
                    this.menuProfessor();
                }
            }
        }else{
            this.selecionarMenu();
        }
    }

    private void selecionarMenu() {
        System.out.println("seleciona menu");
    }


    public void menuAluno(){
        System.out.println("menu aluno");
    }

    public void menuProfessor(){
        System.out.println("menu professor");
    }
    public void menuDiretor(){
        System.out.println("Seja bem vindo:"+ this.funcionarioLogado.getNome());
        //teste com sub menu
        System.out.println("1 - Listar Turma");
        System.out.println("2 - Lista Curso");
        System.out.println("3 - Lista Professor");
        System.out.println("4 - Lista Diretores");
        System.out.println("5 - Criar Curso");

        Scanner scan = new Scanner(System.in);
        System.out.println("Selecine uma opção:");
        int opcao = scan.nextInt();

         switch (opcao){
             case(1):
                 this.dadosTurma.listar();
                 break;
             case(2):
                 this.dadosCurso.listar();
                 break;
             case(3):
                 this.dadosProfessores.listar();
                 break;
             case(4):
                 this.dadosDiretores.listar();
                 break;
             case(5):
                 this.criarCurso();

         }
    }

    public void criarCurso(){
        if(funcionarioLogado instanceof Diretor) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Cadastro de novo curso:");
            System.out.println("Informe o nome do curso:");
            String nome = scan.nextLine();

            System.out.println("Selecione o ID do professor responsável pelo curso:");
            this.dadosProfessores.listar();
            int id = scan.nextInt();
            Professor professor = dadosProfessores.buscarProfessorPeloIndice(id);
            Curso novoCurso = new Curso(nome,professor);
            this.dadosCurso.adicionarCurso(novoCurso);
            System.out.println("Curso cadastrado com sucesso.");
            this.dadosCurso.listar();
        } else {
            System.out.println("Você não tem autorização.");
        }
    }


    /**
     * escolher turma
     */

}