public class Ejercicio17 {

    public static int monedasMinimas(int[] monedas, int monto) {
        int INFINITO = monto + 1; // valor que representa "no se puede lograr" (nunca se necesitan más monedas que el monto mismo)

        int[] dp = new int[monto + 1];
        dp[0] = 0; // para lograr monto 0, no se necesita ninguna moneda

        // llenamos la tabla desde 1 hasta el monto pedido
        for (int i = 1; i <= monto; i++) {
            dp[i] = INFINITO; // arrancamos suponiendo que no se puede

            // probamos usar cada moneda como "última moneda" para llegar a i
            for (int j = 0; j < monedas.length; j++) {
                int moneda = monedas[j];

                if (moneda <= i && dp[i - moneda] != INFINITO) {
                    int candidato = dp[i - moneda] + 1;
                    if (candidato < dp[i]) {
                        dp[i] = candidato;
                    }
                }
            }
        }

        if (dp[monto] == INFINITO) {
            return -1; // no se pudo lograr el monto con ninguna combinación
        } else {
            return dp[monto];
        }
    }

    public static void main(String[] args) {
        int[] monedas1 = {1, 5, 2};
        int monto1 = 13;
        System.out.println("Resultado 1: " + monedasMinimas(monedas1, monto1));

        int[] monedas2 = {3};
        int monto2 = 4;
        System.out.println("Resultado 2: " + monedasMinimas(monedas2, monto2));
    }
}