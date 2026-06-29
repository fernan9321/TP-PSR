public class Ejercicio15 {

    public static int[] restarUno(int[] digitos) {
        int n = digitos.length;
        int[] resultado = new int[n];

        // copiamos el arreglo original para no modificarlo
        for (int i = 0; i < n; i++) {
            resultado[i] = digitos[i];
        }

        int posicion = n - 1;
        boolean hayPrestamo = true; // empezamos queriendo restar 1

        while (posicion >= 0 && hayPrestamo) {
            if (resultado[posicion] > 0) {
                resultado[posicion] = resultado[posicion] - 1;
                hayPrestamo = false; // ya restamos, no hace falta seguir pidiendo prestado
            } else {
                resultado[posicion] = 9; // pedimos prestado: el 0 se convierte en 9
                hayPrestamo = true; // seguimos pidiendo prestado al dígito anterior
            }
            posicion--;
        }

        // si el primer dígito quedó en 0 y hay más de un dígito, lo quitamos
        if (resultado[0] == 0 && resultado.length > 1) {
            int[] sinCeroInicial = new int[resultado.length - 1];
            for (int i = 0; i < sinCeroInicial.length; i++) {
                sinCeroInicial[i] = resultado[i + 1];
            }
            return sinCeroInicial;
        }

        return resultado;
    }

    public static void main(String[] args) {
        int[] caso1 = {1, 0, 0};
        int[] resultado1 = restarUno(caso1);
        imprimir(resultado1);

        int[] caso2 = {1, 2, 3};
        int[] resultado2 = restarUno(caso2);
        imprimir(resultado2);
    }

    public static void imprimir(int[] arreglo) {
        System.out.print("{");
        for (int i = 0; i < arreglo.length; i++) {
            System.out.print(arreglo[i]);
            if (i < arreglo.length - 1) System.out.print(", ");
        }
        System.out.println("}");
    }
}