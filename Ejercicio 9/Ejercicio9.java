public class Ejercicio9 {

    public static int[] contarMayoresIzquierda(int[] nums) {
        int n = nums.length;
        int[] resultado = new int[n];

        for (int i = 0; i < n; i++) {
            int contador = 0;

            // miramos todos los elementos a la izquierda de i
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[i]) {
                    contador = contador + 1;
                }
            }

            resultado[i] = contador;
        }

        return resultado;
    }

    public static void main(String[] args) {
        int[] nums = {5, 3, 7, 1};

        int[] resultado = contarMayoresIzquierda(nums);

        for (int i = 0; i < resultado.length; i++) {
            System.out.print(resultado[i] + " ");
        }
        // imprime: 0 1 0 3
    }
}