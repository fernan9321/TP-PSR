import java.util.Arrays;

public class Ejercicio19 {

    public static int secuenciaMasLarga(int[] numeros) {
        if (numeros.length == 0) {
            return 0;
        }

        // copiamos el arreglo para no modificar el original
        int[] copia = Arrays.copyOf(numeros, numeros.length);
        Arrays.sort(copia);

        int longitudMaxima = 1;
        int longitudActual = 1;

        for (int i = 1; i < copia.length; i++) {

            if (copia[i] == copia[i - 1]) {
                // es un número repetido, no cuenta ni rompe la secuencia
                continue;
            } else if (copia[i] == copia[i - 1] + 1) {
                // es el siguiente número consecutivo, la racha sigue creciendo
                longitudActual++;
            } else {
                // se rompió la secuencia, hay que empezar de nuevo
                longitudActual = 1;
            }

            if (longitudActual > longitudMaxima) {
                longitudMaxima = longitudActual;
            }
        }

        return longitudMaxima;
    }

    public static void main(String[] args) {
        int[] caso1 = {10, 4, 20, 1, 3, 2};
        System.out.println("Resultado 1: " + secuenciaMasLarga(caso1));

        int[] caso2 = {0, 3, 7, 1, 8, 2, 5, 8, 4, 6, 0, 1};
        System.out.println("Resultado 2: " + secuenciaMasLarga(caso2));
    }
}