public class Ejercicio20 {

    public static int maxVocalesEnVentana(String s, int k) {
        int maxVocales = 0;

        // recorremos todas las posiciones donde puede empezar una ventana de tamaño k
        for (int inicio = 0; inicio <= s.length() - k; inicio++) {
            int contadorVocales = 0;

            // contamos las vocales dentro de esta ventana
            for (int j = inicio; j < inicio + k; j++) {
                char caracter = s.charAt(j);

                if (esVocal(caracter)) {
                    contadorVocales++;
                }
            }

            // si esta ventana tiene más vocales que las anteriores, actualizamos el máximo
            if (contadorVocales > maxVocales) {
                maxVocales = contadorVocales;
            }
        }

        return maxVocales;
    }

    public static boolean esVocal(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    public static void main(String[] args) {
        String s = "abcuuudef";

        System.out.println("k=2 -> " + maxVocalesEnVentana(s, 2));
        System.out.println("k=3 -> " + maxVocalesEnVentana(s, 3));
        System.out.println("k=5 -> " + maxVocalesEnVentana(s, 5));
    }
}