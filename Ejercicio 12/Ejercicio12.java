public class Ejercicio12 {

    public static boolean buscarTarget(int[][] matriz, int target) {
        for (int fila = 0; fila < matriz.length; fila++) {
            for (int columna = 0; columna < matriz[fila].length; columna++) {
                if (matriz[fila][columna] == target) {
                    return true; // lo encontramos, no hace falta seguir buscando
                }
            }
        }
        return false; // recorrimos todo y no estaba
    }

    public static void main(String[] args) {
        int[][] matriz = {
            {10, 8, 6},
            {7, 5, 3},
            {1, 0, -1}
        };

        int target = 5;
        boolean resultado = buscarTarget(matriz, target);
        System.out.println("¿Está el " + target + "? " + resultado);
    }
}