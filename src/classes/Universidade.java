package classes;

import classes.dados.*;
import enums.CargoFuncionario;
import enums.StatusMatricula;
import helper.ArrayHelper;
import helper.DataHelper;
import helper.ScannerHelper;

import javax.xml.crypto.Data;
import java.text.ParseException;
import java.util.Scanner;

public class Universidade {


    private Aluno alunoLogado;
    private Funcionario funcionarioLogado;
    private DadosAlunos dadosAlunos;
    private DadosProfessores dadosProfessores;
    private DadosDiretores dadosDiretores;
    private DadosCurso dadosCurso;
    private DadosTurma dadosTurma;


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
        alunoLogado = null;
        funcionarioLogado = null;
        dadosAlunos = new DadosAlunos();
        dadosProfessores = new DadosProfessores();
        dadosDiretores = new DadosDiretores();
        dadosCurso = new DadosCurso();
        dadosTurma = new DadosTurma();

    }


    public void start() {

        if (this.alunoLogado != null) {
            this.menuAluno();
        } else if (funcionarioLogado instanceof Diretor) {
            this.menuDiretor();
        } else if (funcionarioLogado instanceof Professor) {
            this.menuProfessor();
        } else {
            this.selecionarMenu();
        }
    }

    private void selecionarMenu() {
        int[] opcaoesValidas = {1, 2, 3};
        int opcao = 0;
        do {
            String questao = "seleciona Area de Acesso \n" +
                    " 1  - Diretor\n" +
                    " 2  - Professor\n" +
                    " 3  - Aluno\n\n" +
                    " Selecine uma opção:\n";
            opcao = ScannerHelper.lerInteiro(questao);
        } while (!ArrayHelper.valorExiste(opcaoesValidas, opcao));

        switch (opcao) {
            case (1):
                this.logarDiretor();
                break;
            case (2):
                this.logarProfessor();
                break;
            case (3):
                this.logarAluno();
                break;
        }

        this.start();
    }

    private void logarAluno() {
        int count = 0;
        do {
            if (count == 5) {
                System.out.println("Voce exedeu o numero de tentativas.");
                break;
            }
            String nome = ScannerHelper.lerString("Informe o seu nome:");
            this.alunoLogado = dadosAlunos.buscaPeloNome(nome);
            count++;
        } while (this.alunoLogado == null);


    }

    private void logarProfessor() {
        int count = 0;
        do {
            if (count == 5) {
                System.out.println("Voce exedeu o numero de tentativas.");
                break;
            }
            String nome = ScannerHelper.lerString("Informe o seu nome:");
            this.funcionarioLogado = dadosProfessores.buscaPeloNome(nome);
            count++;
        } while (this.funcionarioLogado == null);

    }

    private void logarDiretor() {
        int count = 0;
        do {
            if (count == 5) {
                System.out.println("Voce exedeu o numero de tentativas.");
                break;
            }
            String nome = ScannerHelper.lerString("Informe o seu nome:");
            this.funcionarioLogado = dadosDiretores.buscaPeloNome(nome);
            count++;
        } while (this.funcionarioLogado == null);
    }


    public void menuAluno() {
        do {
            int[] opcaoesValidas = {1, 2, 3, 4, 5};
            int opcao = 0;
            do {
                String questao = "Seja bem vindo: " + this.alunoLogado.getNome() +
                        " \n 1  - Listar Cursos da universidade\n" +
                        " 2  - Listar seus Cursos\n" +
                        " 3  - Adicioinar Curso\n" +
                        " 4  - Remover Curso\n";

                if (this.alunoLogado.getMatricula() != StatusMatricula.FORMADO) {
                    if (this.alunoLogado.getMatricula() == StatusMatricula.ATIVO) {
                        questao += " 5  - Trancar Matricula \n\n";
                    } else {
                        questao += " 5  - Ativa Matricula \n\n";
                    }
                }
                questao += " Selecione uma opção:";
                opcao = ScannerHelper.lerInteiro(questao);
            } while (!ArrayHelper.valorExiste(opcaoesValidas, opcao));

            switch (opcao) {
                case (1):
                    this.dadosCurso.listar();
                    break;
                case (2):
                    this.alunoLogado.listarCursoMatriculados();
                    break;
                case (3):
                    this.AdicionarCursoEmAluno();
                    break;
                case (4):
                    this.removerCursoEmAluno();
                    break;
                case (5):
                    if (this.alunoLogado.getMatricula() != StatusMatricula.FORMADO) {
                        if (this.alunoLogado.getMatricula() == StatusMatricula.ATIVO) {
                            this.trancarMatriculaAluno();
                        } else {
                            this.ativarMatriculaAluno();
                        }
                    }
                    break;
            }
            int querSair = ScannerHelper.lerInteiro("Digite um número (digite 0 para sair): \n");
            if (querSair == 0) {
                System.out.println("Você escolheu sair.");
                break; // Parar o laço se o número for 0
            }
        } while (true);
    }

    private void ativarMatriculaAluno() {
        Boolean status = this.alunoLogado.ativarMatricula();
        if (status) {
            System.out.println("Matricula ativada com sucesso");
        } else {
            System.out.println("Ocorreu um erro ao tentar  ativar a Matricula");
        }
    }

    private void trancarMatriculaAluno() {
        Boolean status = this.alunoLogado.trancarMatricula();
        if (status) {
            System.out.println("Matricula trancada com sucesso");
        } else {
            System.out.println("Ocorreu um erro ao tentar  trancar a Matricula");
        }
    }

    private void removerCursoEmAluno() {
        System.out.println("Selecione um curso para ser removido");
        this.alunoLogado.listarCursoMatriculados();
        int opcao = ScannerHelper.lerInteiro("Informa o id da Curso a ser removido");
        this.alunoLogado.removerCurso(opcao);
        System.out.println("Curso removido com sucesso");
        this.alunoLogado.listarCursoMatriculados();
    }

    private void AdicionarCursoEmAluno() {
        System.out.println("Selecione um curso para se matricular");
        this.dadosCurso.listar();
        int opcao = ScannerHelper.lerInteiro("Informa o id da Curso");
        Curso curso = dadosCurso.buscarCursoPeloIndice(opcao);
        this.alunoLogado.adicionarCurso(curso);
        System.out.println("Curso adicionado com sucesso");
        this.alunoLogado.listarCursoMatriculados();
    }

    public void menuProfessor() {
        do {
            int[] opcoes = {1, 2, 3};
            int opcao = 0;
            do {
                String questao = " Seja bem vindo:" + this.funcionarioLogado.getNome() +
                        "\n 1  - Listar Alunos \n" +
                        " 2  - Adicionar alunos a uma turma \n" +
                        " 3  - Remover alunos a uma turma \n\n" +
                        "Selecine uma opção:";
                opcao = ScannerHelper.lerInteiro(questao);
            } while (!ArrayHelper.valorExiste(opcoes, opcao));
            switch (opcao) {
                case (1):
                    this.dadosAlunos.listar();
                    break;
                case (2):
                    this.adicionarAlunoTurma();
                    break;
                case (3):
                    this.removerAlunoTurma();
                    break;

            }
            int querSair = ScannerHelper.lerInteiro("Digite um número (digite 0 para sair): \n");
            if (querSair == 0) {
                System.out.println("Você escolheu sair.");
                break; // Parar o laço se o número for 0
            }
        } while (true);

    }

    private void removerAlunoTurma() {
        System.out.println("Selecione o Curso");
        this.dadosTurma.listar();
        int id = ScannerHelper.lerInteiro("Informa o id da Turma");
        Turma turma = dadosTurma.buscarTurmaPeloIndice(id);
        turma.listarAlunos();
        int idAluno = ScannerHelper.lerInteiro("Selecione o id do aluno para remover da turma: " + turma.toString());
        turma.removerAluno(idAluno);
        System.out.println("Aluno foi removido com sucesso da turma" + turma.toString());
    }

    private void adicionarAlunoTurma() {
        System.out.println("Selecione a Turma");
        this.dadosTurma.listar();
        int id = ScannerHelper.lerInteiro("Informa o id da Turma");
        Turma turma = dadosTurma.buscarTurmaPeloIndice(id);
        this.dadosAlunos.listar();
        int idAluno = ScannerHelper.lerInteiro("Selecione o id do aluno para adicionar a turma: " + turma.toString());
        Aluno aluno = dadosAlunos.buscarAlunoPeloIndice(idAluno);
        turma.adiconarAluno(aluno);
        System.out.println("Aluno " + aluno.getNome() + " foi adicionado com sucesso na turma" + turma.toString());
        turma.listarAlunos();
    }

    public void menuDiretor() {
        do {
            int[] opcoes = {1, 2, 3, 4, 5, 6, 7};
            int opcao = 0;
            do {
                String questao = " Seja bem vindo:" + this.funcionarioLogado.getNome() +
                        "\n 1  - Listar Alunos\n" +
                        " 2  - Lista Professor\n" +
                        " 3  - Criar Aluno\n" +
                        " 4  - Criar Professor\n" +
                        " 5  - Deletar Aluno\n" +
                        " 6  - Deletar Professor\n" +
                        " 7  - Promover Professor \n\n" +
                        " Selecine uma opção:";
                opcao = ScannerHelper.lerInteiro(questao);
            } while (!ArrayHelper.valorExiste(opcoes, opcao));
            switch (opcao) {
                case (1):
                    this.dadosAlunos.listar();
                    break;
                case (2):
                    this.dadosProfessores.listar();
                    break;
                case (3):
                    this.criarAluno();
                    break;
                case (4):
                    this.criarProfessor();
                    break;
                case (5):
                    this.deletarAluno();
                    break;
                case (6):
                    this.deletarProfessor();
                    break;
                case (7):
                    this.promoverProfessor();
                    break;
            }
            int querSair = ScannerHelper.lerInteiro("Digite um número (digite 0 para sair): \n");
            if (querSair == 0) {
                System.out.println("Você escolheu sair.");
                break; // Parar o laço se o número for 0
            }
        } while (true);
    }

    private void deletarAluno() {
        System.out.println("Selecione o Aluno a ser deletada");
        dadosAlunos.listar();
        int id = ScannerHelper.lerInteiro("Informa o id do Aluno");
        dadosAlunos.removerAluno(dadosAlunos.buscarAlunoPeloIndice(id));
        System.out.println("Aluno deletada com sucesso");
        dadosAlunos.listar();

    }

    private void criarAluno() {
        if (funcionarioLogado instanceof Diretor) {
            try {
                Scanner scan = new Scanner(System.in);
                System.out.println("Cadastre um novo Aluno:");
                String nome = ScannerHelper.lerString("Informe o nome do Aluno:");
                String data = ScannerHelper.lerString("Informe a data de anivesário do Aluno: \n" +
                        "No formato dd/mm/aaaa: Ex: 29/03/2024");
                Aluno aluno = new Aluno(nome, DataHelper.converterStringParaData(data));
                System.out.println("Aluno cadastrada com sucesso.");
                this.dadosAlunos.adicionarAluno(aluno);
                this.dadosAlunos.listar();
            } catch (ParseException e) {
                System.out.println("Ocorreu um erro ao tentar criar a data");
            } catch (Exception e) {
                System.out.println("Ocorreu um erro inesperado ao tentar criar o Aluno");
            } finally {
                System.out.println("Fim da rotina Criar Aluno");
            }
        } else {
            System.out.println("Você não tem autorização.");
        }
    }

    private void promoverProfessor() {
        if (funcionarioLogado instanceof Diretor) {
            System.out.println("Selecione o Professor a ser promovido");
            dadosProfessores.listar();
            int id = ScannerHelper.lerInteiro("Informa o id do Professor");
            Professor professor = dadosProfessores.buscarProfessorPeloIndice(id);
            professor.promover();
            System.out.println("Professor promovido com sucesso");
            System.out.println(professor.toString());
        } else {
            System.out.println("Você não tem autorização.");
        }
    }

    public void deletarTurma() {
        System.out.println("Selecione Turma a ser deletada");
        dadosTurma.listar();
        int id = ScannerHelper.lerInteiro("Informa o id da Turma");
        dadosTurma.removerTurma(dadosTurma.buscarTurmaPeloIndice(id));
        System.out.println("Turma deletada com sucesso");
    }


    public void deletarCurso() {
        System.out.println("Selecione o Curso a ser deletada");
        dadosCurso.listar();
        int id = ScannerHelper.lerInteiro("Informa o id da Curso");
        Curso curso = dadosCurso.buscarCursoPeloIndice(id);
        for (Aluno aluno : dadosAlunos.getAlunos()) {
            aluno.getCursos().remove(curso);
        }
        dadosCurso.removerCurso(curso);

        System.out.println("Curso deletada com sucesso");

    }

    public void deletarProfessor() {
        System.out.println("Selecione o Professor a ser deletada");
        dadosProfessores.listar();
        int id = ScannerHelper.lerInteiro("Informa o id da Professor");
        Professor professor = dadosProfessores.buscarProfessorPeloIndice(id);
        if (funcionarioLogado == professor) {
            System.out.println("Selecione um professor diferente para deletar");
        } else {
            dadosProfessores.removerProfessor(professor);
            System.out.println("Professor deletada com sucesso");
        }
    }

    public void deletarDiretor() {
        System.out.println("Selecione o Diretor a ser deletada");
        dadosDiretores.listar();
        int id = ScannerHelper.lerInteiro("Informa o id da Diretor");
        Diretor diretor = dadosDiretores.buscarDiretorPeloIndice(id);
        if (funcionarioLogado == diretor) {
            System.out.println("Selecione um diretor diferente para deletar");
        } else {
            dadosDiretores.removerDiretor(diretor);
            System.out.println("Professor deletada com sucesso");
        }

    }


    public void criarCurso() {
        if (funcionarioLogado instanceof Diretor) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Cadastro de novo curso:");
            String nome = ScannerHelper.lerString("Informe o nome do curso:");
            System.out.println("Selecione o ID do professor responsável pelo curso:");
            this.dadosProfessores.listar();
            int id = ScannerHelper.lerInteiro("");
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
            String nome = ScannerHelper.lerString("Informe o ano da turma:");
            System.out.println("Selecione o ID do curso da turma:");
            this.dadosCurso.listar();
            int id = ScannerHelper.lerInteiro("");
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

    public void criarProfessor() {
        if (funcionarioLogado instanceof Diretor) {
            try {

                System.out.println("Cadastre o novo professor:");
                String nome = ScannerHelper.lerString("Informe o nome do professor:");
                double salario = ScannerHelper.lerDouble("Informe o salário do professor:");
                String data = ScannerHelper.lerString("Informe a data de anivesário do professor: \n" +
                        "No formato dd/mm/aaaa: Ex: 29/03/2024");
                String dataContratacao = ScannerHelper.lerString("Informe a data de contratação do professor: \n" +
                        "No formato dd/mm/aaaa: Ex: 29/03/2024");
                int opcaoCargo = ScannerHelper.lerInteiro("Selecione a senioridade do professor:\n" +
                        "1 - Iniciante: \n" +
                        "2 - Avançado: \n" +
                        "3 - Experiente: \n");

                CargoFuncionario cargoFuncionario = null;

                switch (opcaoCargo) {
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
                Professor professor = new Professor(nome, salario, DataHelper.converterStringParaData(data), DataHelper.converterStringParaData(dataContratacao), cargoFuncionario);
                this.dadosProfessores.adicionarProfessor(professor);
                System.out.println("Professor cadastrado com sucesso.");
                this.dadosProfessores.listar();
            } catch (ParseException e) {
                System.out.println("Ocorreu um erro ao tentar criar a data");
            } catch (Exception e) {
                System.out.println("Ocorreu um erro inesperado ao tenatr criar o professor");
            } finally {
                System.out.println("Fim da rotina Criar professor");
            }
        } else {
            System.out.println("Você não tem autorização.");
        }

    }


    public void populeDados() {
        try {
            this.getDadosTurma().adicionarTurma(new Turma("2024", new Curso("FMT")));
            this.getDadosTurma().adicionarTurma(new Turma("2023", new Curso("FMT1")));
            this.getDadosTurma().adicionarTurma(new Turma("2022", new Curso("FMT2")));
            this.getDadosTurma().adicionarTurma(new Turma("2021", new Curso("FMT3")));
            this.getDadosProfessores().adicionarProfessor(new Professor("Prof 1", 10.00, DataHelper.converterStringParaData("02/02/2024"), DataHelper.converterStringParaData("02/02/2024"), CargoFuncionario.AVANCADO));
            this.getDadosProfessores().adicionarProfessor(new Professor("Prof 2", 10.00, DataHelper.converterStringParaData("03/03/2024"), DataHelper.converterStringParaData("03/03/2024"), CargoFuncionario.EXPERIENTE));
            this.getDadosProfessores().adicionarProfessor(new Professor("Prof 3", 10.00, DataHelper.converterStringParaData("04/04/2024"), DataHelper.converterStringParaData("04/04/2024"), CargoFuncionario.INICIANTE));
            this.getDadosProfessores().adicionarProfessor(new Professor("Prof 4", 10.00, DataHelper.converterStringParaData("06/06/2024"), DataHelper.converterStringParaData("06/06/2024"), CargoFuncionario.AVANCADO));
            this.getDadosDiretores().adicionarDiretor(new Diretor("Dir 1", 10.00, DataHelper.converterStringParaData("02/02/2024"), CargoFuncionario.AVANCADO));
            this.getDadosDiretores().adicionarDiretor(new Diretor("Dir 2", 10.00, DataHelper.converterStringParaData("03/03/2024"), CargoFuncionario.EXPERIENTE));
            this.getDadosDiretores().adicionarDiretor(new Diretor("Dir 3", 10.00, DataHelper.converterStringParaData("04/04/2024"), CargoFuncionario.INICIANTE));
            this.getDadosDiretores().adicionarDiretor(new Diretor("Dir 4", 10.00, DataHelper.converterStringParaData("06/06/2024"), CargoFuncionario.AVANCADO));
            this.getDadosCurso().adicionarCurso(new Curso("FMT", this.getDadosProfessores().buscarProfessorPeloIndice(0)));
            this.getDadosCurso().adicionarCurso(new Curso("FMT1", this.getDadosProfessores().buscarProfessorPeloIndice(1)));
            this.getDadosCurso().adicionarCurso(new Curso("FMT2", this.getDadosProfessores().buscarProfessorPeloIndice(2)));
            this.getDadosCurso().adicionarCurso(new Curso("FMT3", this.getDadosProfessores().buscarProfessorPeloIndice(0)));
            this.getDadosAlunos().adicionarAluno(new Aluno("aluno 1", DataHelper.converterStringParaData("02/02/2024")));
            this.getDadosAlunos().adicionarAluno(new Aluno("aluno 2", DataHelper.converterStringParaData("03/03/2024")));
            this.getDadosAlunos().adicionarAluno(new Aluno("aluno 3", DataHelper.converterStringParaData("04/04/2024")));
            this.getDadosAlunos().adicionarAluno(new Aluno("aluno 5", DataHelper.converterStringParaData("06/06/2024")));
            this.getDadosAlunos().adicionarAluno(new Aluno("aluno 4", DataHelper.converterStringParaData("05/05/2024")));
            this.getDadosAlunos().adicionarAluno(new Aluno("aluno 6", DataHelper.converterStringParaData("09/07/2024")));

            this.setAlunoLogado(this.getDadosAlunos().buscarAlunoPeloIndice(0));
//        this.getAlunoLogado().adicionarCurso(this.getDadosCurso().buscarCursoPeloIndice(0));
//        this.getAlunoLogado().adicionarCurso(this.getDadosCurso().buscarCursoPeloIndice(1));
//        this.getAlunoLogado().setMatricula(StatusMatricula.FORMADO);
//        this.getAlunoLogado().setMatricula(StatusMatricula.TRANCADO);
//        this.setFuncionarioLogado(this.getDadosProfessores().buscarProfessorPeloIndice(0));
//        this.setFuncionarioLogado(this.getDadosDiretores().buscarDiretorPeloIndice(0));
        } catch (ParseException e) {
            throw new RuntimeException("ocorreu um Erro:" + e.getMessage());
        }


    }

}