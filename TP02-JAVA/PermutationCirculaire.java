public class PermutationCirculaire {

    public static boolean estPermutationCirculaire(int[] t) {
        if (t == null || t.length == 0) return false;

        int n = t.length;
        boolean[] vu = new boolean[n + 1]; 

        for (int x : t) {
            if (x < 1 || x > n) return false; 
            if (vu[x]) return false;          
            vu[x] = true;
        }

        int pos = -1;
        for (int i = 0; i < n; i++) {
            if (t[i] == 1) {
                pos = i;
                break;
            }
        }
        if (pos == -1) return false; 
        for (int k = 0; k < n; k++) {
            int idx = (pos + k) % n;
            int attendu = k + 1;
            if (t[idx] != attendu) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        int[][] tests = {
            {1},
            {1,2,3,4,5},
            {2,3,4,5,1},
            {4,5,1,2,3},
            {3,1,2,4,5},
            {1,2,2,3,4},
            {0,1,2,3,4},
            {1,2,3,4,6}
        };

        for (int[] t : tests) {
            System.out.print("Tableau : ");
            for (int x : t) System.out.print(x + " ");
            System.out.println("→ " + estPermutationCirculaire(t));
        }
    }
}

