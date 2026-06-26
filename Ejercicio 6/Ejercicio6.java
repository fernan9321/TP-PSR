public class Ejercicio6 {

    public static int[] aplicarRotaciones(int[] nums, int[][] rotaciones) {
        int n = nums.length;

        // guardamos una copia del arreglo original, para no mezclar rotaciones entre si
        int[] original = new int[n];
        for (int i = 0; i < n; i++) {
            original[i] = nums[i];
        }

        // el resultado arranca siendo igual al original
        int[] resultado = new int[n];
        for (int i = 0; i < n; i++) {
            resultado[i] = original[i];
        }

        // aplicamos cada rotacion, siempre mirando el arreglo ORIGINAL
        for (int r = 0; r < rotaciones.length; r++) {
            int start = rotaciones[r][0];
            int end = rotaciones[r][1];

            // correr todo el tramo una posicion hacia la izquierda
            for (int i = start; i < end; i++) {
                resultado[i] = original[i + 1];
            }

            // el primero del tramo pasa al final del tramo
            resultado[end] = original[start];
        }

        return resultado;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        int[][] rotaciones = {{0, 1}, {2, 3}};

        int[] resultado = aplicarRotaciones(nums, rotaciones);

        for (int i = 0; i < resultado.length; i++) {
            System.out.print(resultado[i] + " ");
        }
    }
}