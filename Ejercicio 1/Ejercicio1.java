public class Ejercicio1 {

    public static boolean esEspiral(int[][] matriz) {
        int filas = matriz.length;
        int columnas = matriz[0].length;
        int total = filas * columnas;

        int arriba = 0;
        int abajo = filas - 1;
        int izquierda = 0;
        int derecha = columnas - 1;

        int esperado = 1;

        while (arriba <= abajo && izquierda <= derecha) {

            // recorrer la fila de arriba, de izquierda a derecha
            for (int columna = izquierda; columna <= derecha; columna++) {
                if (matriz[arriba][columna] != esperado) {
                    return false;
                }
                esperado = esperado + 1;
            }
            arriba = arriba + 1;

            // recorrer la columna derecha, de arriba a abajo
            for (int fila = arriba; fila <= abajo; fila++) {
                if (matriz[fila][derecha] != esperado) {
                    return false;
                }
                esperado = esperado + 1;
            }
            derecha = derecha - 1;

            // recorrer la fila de abajo, de derecha a izquierda
            if (arriba <= abajo) {
                for (int columna = derecha; columna >= izquierda; columna--) {
                    if (matriz[abajo][columna] != esperado) {
                        return false;
                    }
                    esperado = esperado + 1;
                }
                abajo = abajo - 1;
            }

            // recorrer la columna izquierda, de abajo a arriba
            if (izquierda <= derecha) {
                for (int fila = abajo; fila >= arriba; fila--) {
                    if (matriz[fila][izquierda] != esperado) {
                        return false;
                    }
                    esperado = esperado + 1;
                }
                izquierda = izquierda + 1;
            }
        }

        return esperado - 1 == total;
    }

    public static void main(String[] args) {
        int[][] matriz1 = {
            {1, 2, 3},
            {8, 9, 4},
            {7, 6, 5}
        };

        int[][] matriz2 = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        System.out.println(esEspiral(matriz1)); // true
        System.out.println(esEspiral(matriz2)); // false
    }
}