public class Ejercicio18 {

    public static int[] sumarUno(int[] digitos) {
        int n = digitos.length;
        int[] resultado = new int[n];

        // copiamos el arreglo original para no modificarlo
        for (int i = 0; i < n; i++) {
            resultado[i] = digitos[i];
        }

        int posicion = n - 1;
        boolean hayAcarreo = true; // empezamos queriendo sumar 1

        while (posicion >= 0 && hayAcarreo) {
            if (resultado[posicion] < 9) {
                resultado[posicion] = resultado[posicion] + 1;
                hayAcarreo = false; // ya sumamos, no hace falta seguir acarreando
            } else {
                resultado[posicion] = 0; // el 9 se convierte en 0
                hayAcarreo = true; // seguimos acarreando 1 al dígito anterior
            }
            posicion--;
        }

        // si todavía queda acarreo después de revisar todos los dígitos
        // (ej: {9,9} -> {1,0,0}), hay que agregar un dígito más al principio
        if (hayAcarreo) {
            int[] conDigitoExtra = new int[n + 1];
            conDigitoExtra[0] = 1;
            for (int i = 0; i < n; i++) {
                conDigitoExtra[i + 1] = resultado[i];
            }
            return conDigitoExtra;
        }

        return resultado;
    }

    public static void main(String[] args) {
        int[] caso1 = {1, 2, 3};
        imprimir(sumarUno(caso1));

        int[] caso2 = {9};
        imprimir(sumarUno(caso2));

        int[] caso3 = {9, 9};
        imprimir(sumarUno(caso3));
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