public class Ejercicio2 {

    public static int secuenciaMasLarga(int[] numeros) {
        int n = numeros.length;

        if (n == 0) {
            return 0;
        }

        int maximo = 1;

        // probamos empezar la racha desde cada posicion del arreglo
        for (int i = 0; i < n; i++) {
            int contador = 1;
            int actual = i;

            // mientras no demos toda la vuelta al arreglo
            while (contador < n) {
                int siguiente = (actual + 1) % n; // si llega al final, vuelve al principio

                if (numeros[siguiente] == numeros[actual] + 1) {
                    contador = contador + 1;
                    actual = siguiente;
                } else {
                    break; // se rompio la racha, dejamos de sumar
                }
            }

            if (contador > maximo) {
                maximo = contador;
            }
        }

        return maximo;
    }

    public static void main(String[] args) {
        int[] arreglo1 = {1, 2, 4, 5, 6, 7};
        int[] arreglo2 = {2, 1};

        System.out.println(secuenciaMasLarga(arreglo1)); // 4
        System.out.println(secuenciaMasLarga(arreglo2)); // 2
    }
}