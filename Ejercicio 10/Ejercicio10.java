public class Ejercicio10 {

    public static int largoMaximo(int[] nums) {
        int n = nums.length;
        int maxLargo = 0;
        int actual = 0;
        int i = 0;

        while (i < n) {
            int j = i;

            // avanzamos mientras el numero se repita (armamos el bloque)
            while (j < n && nums[j] == nums[i]) {
                j = j + 1;
            }

            int largoBloque = j - i;

            if (largoBloque == 2) {
                // el bloque es valido (justo 2 repetidos), sigue la racha
                actual = actual + 2;
                if (actual > maxLargo) {
                    maxLargo = actual;
                }
            } else {
                // el bloque no sirve (aparecio 1 vez, o 3 o mas), se corta la racha
                actual = 0;
            }

            i = j; // saltamos al siguiente bloque
        }

        return maxLargo;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 3, 3, 4, 1};

        System.out.println(largoMaximo(nums)); // 4
    }
}