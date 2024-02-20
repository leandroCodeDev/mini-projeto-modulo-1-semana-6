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
        do {
            try {
                System.out.println(mensagem);
                int valor = scanner.nextInt();
                limparLinha();
                return valor;
            } catch (Exception e) {
                System.out.println("Informe o valor correto");
                scanner.nextLine();
            }
        } while (true);
    }

    public static double lerDouble(String mensagem) {
        do {
            try {
                System.out.println(mensagem);
                double valor = scanner.nextDouble();
                limparLinha();
                return valor;
            } catch (Exception e) {
                System.out.println("Informe o valor correto");
                scanner.nextLine();
            }
        } while (true);
    }

    public static String lerString(String mensagem) {
        System.out.println(mensagem);
        String valor = scanner.next();
        valor += scanner.nextLine();
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
