public class Spirale {

    public static int[][] construireSpirale(int n) {
        int[][] m = new int[n][n];
        int val = 1;
        int top = 0, bottom = n - 1, left = 0, right = n - 1;

        while (top <= bottom && left <= right) {
            for (int j = left; j <= right; j++) {
                m[top][j] = val++;
            }
            top++;

            for (int i = top; i <= bottom; i++) {
                m[i][right] = val++;
            }
            right--;

            if (top > bottom || left > right) break;

            for (int j = right; j >= left; j--) {
                m[bottom][j] = val++;
            }
            bottom--;

            for (int i = bottom; i >= top; i--) {
                m[i][left] = val++;
            }
            left++;
        }

        return m;
    }

    public static void afficherMatrice(int[][] m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                System.out.printf("%3d", m[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[] tests = {1, 2, 3, 4, 5};

        for (int n : tests) {
            System.out.println("n = " + n);
            int[][] matrice = construireSpirale(n);
            afficherMatrice(matrice);
            System.out.println();
        }
    }
}

