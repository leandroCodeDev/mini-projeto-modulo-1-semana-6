package classes;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Professor extends Funcionario {
//    Professor - atributos: Nome, idade, tempo de trabalho

    private Date dataNascimento;

    /**
     *
     * @param nome
     * @param dataNascimento format yyyy-MM-dd
     * @param dataContratacao format yyyy-MM-dd
     */
    public Professor (String nome, Double salario, String dataNascimento, String dataContratacao) {
        super (nome, salario, dataContratacao);
        this.dataNascimento = new Date(dataNascimento);
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    /**
     *
     * @param dataNascimento format yyyy-MM-dd
     */
    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = new Date(dataNascimento);
    }
}
