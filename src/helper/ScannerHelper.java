package helper;

import java.util.Scanner;

public class ScannerHelper {
    private static final ScannerHelper instance = new ScannerHelper();
    private static Scanner scanner;
    private ScannerHelper() {
        scanner = new Scanner(System.in);
    }

    public static ScannerHelper getInstance() {
        return instance;
    }

    public static int lerInteiro(String mensagem) {
        System.out.print(mensagem);
        int valor = scanner.nextInt();
        limparLinha();
        return valor;
    }

    public static double lerDouble(String mensagem) {
        System.out.print(mensagem);
        double valor = scanner.nextDouble();
        limparLinha();
        return valor;
    }

    public static String lerString(String mensagem) {
        System.out.print(mensagem);
        String valor = scanner.next();
        limparLinha();
        return valor;
    }

    public static void fecharScanner() {
        scanner.close();
    }

    private static void limparLinha() {
        scanner.nextLine();
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}
