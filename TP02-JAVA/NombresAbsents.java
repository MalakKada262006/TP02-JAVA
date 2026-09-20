public class NombresAbsents {

    public static void afficherElementsManquants(int[] t) {
        if (t == null || t.length == 0) {
            System.out.println("Tableau vide → Aucun élément manquant");
            return;
        }

        int n = t.length;
        boolean[] vu = new boolean[n + 1];

        for (int x : t) {
            if (x >= 1 && x <= n) {
                vu[x] = true;
            }
        }

        boolean found = false;
        System.out.print("Éléments manquants : ");
        for (int k = 1; k <= n; k++) {
            if (!vu[k]) {
                System.out.print(k + " ");
                found = true;
            }
        }

        if (!found) {
            System.out.println("Aucun élément manquant");
        } else {
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] tests = {
            {1, 3, 3, 5},   
            {1, 2, 3, 4},   
            {3, 3, 3},     
            {1, 1, 1, 1},   
            {4, 2, 2, 1, 5},
            {1}             
        };

        for (int[] t : tests) {
            System.out.print("Tableau : ");
            for (int x : t) System.out.print(x + " ");
            System.out.println();
            afficherElementsManquants(t);
            System.out.println();
        }
    }
}

