import classes.*;
import classes.dados.DadosProfessores;
import enums.CargoFuncionario;
import enums.StatusMatricula;
import excecoes.BuscaVazia;
import helper.ScannerHelper;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Universidade uni = new Universidade();
        uni.populeDados();
        uni.start();

    }
}