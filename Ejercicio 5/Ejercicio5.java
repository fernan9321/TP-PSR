public class Ejercicio5 {

    public static boolean esVocal(char letra) {
        return letra == 'a' || letra == 'e' || letra == 'i' || letra == 'o' || letra == 'u';
    }

    public static int maxConsonantes(String s, int k) {
        int maximo = 0;

        // recorremos todas las posiciones donde puede empezar una subcadena de largo k
        for (int i = 0; i <= s.length() - k; i++) {
            int contador = 0;

            // contamos las consonantes de esa subcadena
            for (int j = i; j < i + k; j++) {
                char letra = s.charAt(j);
                if (!esVocal(letra)) {
                    contador = contador + 1;
                }
            }

            if (contador > maximo) {
                maximo = contador;
            }
        }

        return maximo;
    }

    public static void main(String[] args) {
        String texto = "abcuuudef";
        int k = 3;

        System.out.println(maxConsonantes(texto, k)); // 2
    }
}