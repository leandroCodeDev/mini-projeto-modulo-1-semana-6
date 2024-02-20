package helper;

import java.util.ArrayList;

public class ArrayHelper {
    public static boolean valorExiste(int[] array, int valor) {
        for (int elemento : array) {
            if (elemento == valor) {
                return true;
            }
        }
        return false;
    }

    /**

     Verifica se um objeto existe dentro de um ArrayList.*
     @param lista o ArrayList a ser verificado
     @param objeto o objeto a ser buscado na lista
     @return true se o objeto existe na lista, caso contrário false
     @param <T> o tipo dos elementos na lista e do objeto a ser buscado
     */
    public static <T> boolean objetoExiste(ArrayList<T> lista, T objeto) {
        return lista.contains(objeto);
    }
}