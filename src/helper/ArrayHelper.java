package helper;

public class ArrayHelper {
    public static boolean valorExiste(int[] array, int valor) {
        for (int elemento : array) {
            if (elemento == valor) {
                return true;
            }
        }
        return false;
    }
}