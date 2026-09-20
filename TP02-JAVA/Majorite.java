import java.util.HashMap;
import java.util.Map;

public class Majorite {

    public static int elementMajoritaireNaif(int[] t) {
        if (t == null || t.length == 0) return -1;
        int n = t.length;

        Map<Integer, Integer> freq = new HashMap<>();
        for (int x : t) {
            freq.put(x, freq.getOrDefault(x, 0) + 1);
            if (freq.get(x) > n / 2) return x;
        }
        return -1;
    }

    public static int elementMajoritaire(int[] t) {
        if (t == null || t.length == 0) return -1;

        int candidat = 0, compteur = 0;
        for (int x : t) {
            if (compteur == 0) {
                candidat = x;
                compteur = 1;
            } else if (x == candidat) {
                compteur++;
            } else {
                compteur--;
            }
        }

        int n = t.length;
        int occurrences = 0;
        for (int x : t) {
            if (x == candidat) occurrences++;
        }

        return (occurrences > n / 2) ? candidat : -1;
    }

    public static void main(String[] args) {
        int[][] tests = {
            {3, 3, 4, 3, 5},        
            {1, 2, 3, 2, 2},        
            {1, 2, 3, 4},          
            {1, 1, 2, 2},           
            {7},                    
            {-2, -2, -2, -2, 1, 3}, 
            {}                      
        };

        for (int[] t : tests) {
            int res = elementMajoritaire(t);
            System.out.print("Tableau : ");
            for (int x : t) System.out.print(x + " ");
            System.out.println("→ Élément majoritaire = " + res);
        }
    }
}

