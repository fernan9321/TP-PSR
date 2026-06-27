public class Ejercicio11 {

    public static int[] sumarEnBaseK(int[] A, int[] B, int K) {
        int n = A.length;
        int[] resultadoTemp = new int[n + 1]; // un lugar extra por si hay acarreo final
        int acarreo = 0;

        // recorremos de derecha a izquierda, como se suma a mano
        for (int i = n - 1; i >= 0; i--) {
            int suma = A[i] + B[i] + acarreo;
            resultadoTemp[i + 1] = suma % K;
            acarreo = suma / K;
        }
        resultadoTemp[0] = acarreo;

        if (acarreo == 0) {
            // no hubo acarreo final -> devolvemos un arreglo del mismo tamaño que A y B
            int[] resultado = new int[n];
            for (int i = 0; i < n; i++) {
                resultado[i] = resultadoTemp[i + 1];
            }
            return resultado;
        } else {
            // hubo acarreo final -> el resultado tiene un dígito más
            return resultadoTemp;
        }
    }

    public static void main(String[] args) {
        int[] A = {1, 2};
        int[] B = {1, 8};
        int K = 10;

        int[] resultado = sumarEnBaseK(A, B, K);

        System.out.print("Resultado: {");
        for (int i = 0; i < resultado.length; i++) {
            System.out.print(resultado[i]);
            if (i < resultado.length - 1) System.out.print(", ");
        }
        System.out.println("}");
    }
}