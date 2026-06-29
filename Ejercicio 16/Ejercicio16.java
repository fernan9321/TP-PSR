public class Ejercicio16 {

    public static int buscarInicioVentana(String numero, int k, int target) {
        // recorremos todas las posiciones donde puede empezar una ventana de tamaño k
        for (int inicio = 0; inicio <= numero.length() - k; inicio++) {
            int suma = 0;

            // sumamos los dígitos de esta ventana
            for (int j = inicio; j < inicio + k; j++) {
                char caracter = numero.charAt(j);
                int digito = caracter - '0'; // convertimos el char a número
                suma = suma + digito;
            }

            // si esta ventana suma exactamente el target, ya encontramos lo que buscábamos
            if (suma == target) {
                return inicio;
            }
        }

        return -1; // recorrimos todo y ninguna ventana dio el target
    }

    public static void main(String[] args) {
        String numero = "123456";
        int k = 3;
        int target = 15;

        int resultado = buscarInicioVentana(numero, k, target);
        System.out.println("Índice de inicio: " + resultado);
    }
}