public class Ejercicio3 {

    public static int[] multiplicarPorK(int[] digitos, int k) {
        int n = digitos.length;
        int[] resultado = new int[n + 1]; // por si el resultado tiene un digito mas
        int acarreo = 0;

        // recorremos los digitos de derecha a izquierda, como al multiplicar a mano
        for (int i = n - 1; i >= 0; i--) {
            int producto = digitos[i] * k + acarreo;
            resultado[i + 1] = producto % 10; // me quedo con el digito
            acarreo = producto / 10;          // lo que sobra, pasa a la siguiente cuenta
        }

        resultado[0] = acarreo;

        // si no quedo acarreo, sacamos el cero de adelante que no hace falta
        if (resultado[0] == 0) {
            int[] sinCero = new int[n];
            for (int i = 0; i < n; i++) {
                sinCero[i] = resultado[i + 1];
            }
            return sinCero;
        }

        return resultado;
    }

    public static void main(String[] args) {
        int[] numero1 = {1, 2, 3};
        int[] numero2 = {9, 9};

        imprimir(multiplicarPorK(numero1, 3)); // 3 6 9
        imprimir(multiplicarPorK(numero2, 2)); // 1 9 8
    }

    public static void imprimir(int[] arreglo) {
        for (int i = 0; i < arreglo.length; i++) {
            System.out.print(arreglo[i] + " ");
        }
        System.out.println();
    }
}