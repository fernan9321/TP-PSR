public class Ejercicio14 {

    public static int contarBarcosDiagonales(boolean[][] tablero) {
        int filas = tablero.length;
        int columnas = tablero[0].length;
        int contadorBarcos = 0;

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {

                if (tablero[i][j]) {

                    // ¿Es el INICIO de un barco diagonal tipo "\" (bajando a la derecha)?
                    boolean hayAnteriorBackslash = (i - 1 >= 0 && j - 1 >= 0 && tablero[i - 1][j - 1]);
                    if (!hayAnteriorBackslash) {
                        int largo = 1;
                        int fila = i + 1;
                        int columna = j + 1;
                        while (fila < filas && columna < columnas && tablero[fila][columna]) {
                            largo++;
                            fila++;
                            columna++;
                        }
                        if (largo >= 2) {
                            contadorBarcos++;
                        }
                    }

                    // ¿Es el INICIO de un barco diagonal tipo "/" (bajando a la izquierda)?
                    boolean hayAnteriorSlash = (i - 1 >= 0 && j + 1 < columnas && tablero[i - 1][j + 1]);
                    if (!hayAnteriorSlash) {
                        int largo = 1;
                        int fila = i + 1;
                        int columna = j - 1;
                        while (fila < filas && columna >= 0 && tablero[fila][columna]) {
                            largo++;
                            fila++;
                            columna--;
                        }
                        if (largo >= 2) {
                            contadorBarcos++;
                        }
                    }
                }
            }
        }

        return contadorBarcos; // el tablero nunca se modifica, solo se lee
    }

    public static void main(String[] args) {
        boolean[][] tablero = new boolean[5][5]; // arranca todo en false
        tablero[0][0] = true;
        tablero[1][1] = true; 
        tablero[2][2] = true;   //aqui se forma un barco diagonal de 3 lineas de largo

        tablero[0][3] = true;
        tablero[1][4] = true;   //aqui se forma un barco diagonal de 2 lineas de largo
    
        int resultado = contarBarcosDiagonales(tablero);
        System.out.println("Cantidad de barcos diagonales: " + resultado);
    }
}