public class Ejercicio13 {

    public static int maxParesEnVentana(String numero, int k) {
        int maxPares = 0;

        // recorremos todas las posiciones donde puede empezar una ventana de tamaño k
        for (int inicio = 0; inicio <= numero.length() - k; inicio++) {
            int contadorPares = 0;

            // contamos los dígitos pares dentro de esta ventana
            for (int j = inicio; j < inicio + k; j++) {
                char caracter = numero.charAt(j);
                int digito = caracter - '0'; // convertimos el char a número

                if (digito % 2 == 0) {
                    contadorPares++;
                }
            }

            // si esta ventana tiene más pares que las anteriores, actualizamos el máximo
            if (contadorPares > maxPares) {
                maxPares = contadorPares;
            }
        }

        return maxPares;
    }

    public static void main(String[] args) {
        String numero = "1234567890";
        int k = 3;

        int resultado = maxParesEnVentana(numero, k);
        System.out.println("Máximo de dígitos pares en ventana de " + k + ": " + resultado);
    }
}