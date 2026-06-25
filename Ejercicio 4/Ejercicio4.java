public class Ejercicio4 {

    public static int[] buscarTarget(int[][] matriz, int target) {
        int filas = matriz.length;
        int columnas = matriz[0].length;

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (matriz[i][j] == target) {
                    return new int[] {i, j};
                }
            }
        }

        // si no lo encontramos en ningun lado
        return new int[] {-1, -1};
    }

    public static void main(String[] args) {
        int[][] matriz = {
            {4, 5, 6},
            {1, 2, 3},
            {7, 8, 9}
        };

        int[] resultado = buscarTarget(matriz, 5);
        System.out.println("{" + resultado[0] + ", " + resultado[1] + "}"); // {0, 1}

        int[] resultado2 = buscarTarget(matriz, 50);
        System.out.println("{" + resultado2[0] + ", " + resultado2[1] + "}"); // {-1, -1}
    }
}