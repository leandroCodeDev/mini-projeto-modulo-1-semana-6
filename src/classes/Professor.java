package classes;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Professor {
//    Professor - atributos: Nome, idade, tempo de trabalho
    private String nome;
    private Date dataContratacao;

    private Date dataNascimento;

    /**
     *
     * @param nome
     * @param dataNascimento format yyyy-MM-dd
     */
    public Professor (String nome, String dataNascimento) {
        this.nome = nome;
        this.dataNascimento = new Date(dataNascimento);
        this.dataContratacao = new Date();
    }

    /**
     *
     * @param nome
     * @param dataNascimento format yyyy-MM-dd
     * @param dataContratacao format yyyy-MM-dd
     */
    public Professor (String nome, String dataNascimento, String dataContratacao) {
        this.nome = nome;
        this.dataNascimento = new Date(dataNascimento);
        this.dataContratacao = new Date(dataContratacao);
    }

    /**
     *
     * @param nome
     * @param dataNascimento format yyyy-MM-dd
     */
    public Professor (String nome, Date dataNascimento) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.dataContratacao = new Date();
    }

    /**
     *
     * @param nome
     * @param dataNascimento format yyyy-MM-dd
     * @param dataContratacao format yyyy-MM-dd
     */
    public Professor (String nome, Date dataNascimento, Date dataContratacao) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.dataContratacao = dataContratacao;
    }

    public String getNome() {
        return nome;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataContratacao() {
        return dataContratacao;
    }

    public void setDataContratacao(Date dataContratacao) {
        this.dataContratacao = dataContratacao;
    }

    /**
     *
     * @param dataContratacao format yyyy-MM-dd
     */
    public void setDataContratacao(String dataContratacao) {
        this.dataContratacao = new Date(dataContratacao);
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
