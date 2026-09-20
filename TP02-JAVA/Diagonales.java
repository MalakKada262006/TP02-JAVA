public class Diagonales {

    public static int differenceDiagonales(int[][] m) {
        int n = m.length;
        int sommePrincipale = 0;
        int sommeSecondaire = 0;

        for (int i = 0; i < n; i++) {
            sommePrincipale += m[i][i];
            sommeSecondaire += m[i][n - 1 - i];
        }

        int diff = Math.abs(sommePrincipale - sommeSecondaire);

        System.out.println("Somme diagonale principale = " + sommePrincipale);
        System.out.println("Somme diagonale secondaire = " + sommeSecondaire);
        System.out.println("Différence absolue = " + diff);

        return diff;
    }

    public static void main(String[] args) {
        int[][] m1 = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        int[][] m2 = {
            {1, 3, 5},
            {2, 4, 6},
            {7, 8, 9}
        };

        int[][] m3 = {
            {-1, 2},
            {3, -4}
        };

        System.out.println("Matrice 1 :");
        differenceDiagonales(m1);
        System.out.println();

        System.out.println("Matrice 2 :");
        differenceDiagonales(m2);
        System.out.println();

        System.out.println("Matrice 3 :");
        differenceDiagonales(m3);
    }
}

