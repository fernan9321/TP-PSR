public class Ejercicio7 {

    public static int contarSubmarinos(boolean[][][] cubo) {
        int dimX = cubo.length;
        int dimY = cubo[0].length;
        int dimZ = cubo[0][0].length;

        int contador = 0;

        for (int x = 0; x < dimX; x++) {
            for (int y = 0; y < dimY; y++) {
                for (int z = 0; z < dimZ; z++) {

                    if (!cubo[x][y][z]) {
                        continue; // celda vacia, no hay nada que mirar aca
                    }

                    // ---- revisamos si arranca un submarino en direccion X ----
                    boolean esInicioX = (x == 0) || !cubo[x - 1][y][z];
                    if (esInicioX) {
                        int largo = 0;
                        int xx = x;
                        while (xx < dimX && cubo[xx][y][z]) {
                            largo = largo + 1;
                            xx = xx + 1;
                        }
                        if (largo == 3) {
                            contador = contador + 1;
                        }
                    }

                    // ---- revisamos si arranca un submarino en direccion Y ----
                    boolean esInicioY = (y == 0) || !cubo[x][y - 1][z];
                    if (esInicioY) {
                        int largo = 0;
                        int yy = y;
                        while (yy < dimY && cubo[x][yy][z]) {
                            largo = largo + 1;
                            yy = yy + 1;
                        }
                        if (largo == 3) {
                            contador = contador + 1;
                        }
                    }

                    // ---- revisamos si arranca un submarino en direccion Z ----
                    boolean esInicioZ = (z == 0) || !cubo[x][y][z - 1];
                    if (esInicioZ) {
                        int largo = 0;
                        int zz = z;
                        while (zz < dimZ && cubo[x][y][zz]) {
                            largo = largo + 1;
                            zz = zz + 1;
                        }
                        if (largo == 3) {
                            contador = contador + 1;
                        }
                    }
                }
            }
        }

        return contador;
    }

    public static void main(String[] args) {
        // submarino de 3 celdas en direccion X: (0,0,0),(1,0,0),(2,0,0)
        boolean[][][] cubo = new boolean[3][3][3];
        cubo[0][0][0] = true;
        cubo[1][0][0] = true;
        cubo[2][0][0] = true;

        System.out.println(contarSubmarinos(cubo)); // 1
    }
}