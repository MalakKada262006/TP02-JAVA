public class Kadane {

    public static int maxSubarraySum(int[] t) {
        if (t == null || t.length == 0) throw new IllegalArgumentException("Tableau vide");

        int currentSum = t[0];
        int maxSum = t[0];

        for (int i = 1; i < t.length; i++) {
            currentSum = Math.max(t[i], currentSum + t[i]);
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

    public static int[] maxSubarrayWithIndices(int[] t) {
        if (t == null || t.length == 0) throw new IllegalArgumentException("Tableau vide");

        int currentSum = t[0];
        int maxSum = t[0];
        int start = 0, bestStart = 0, bestEnd = 0;

        for (int i = 1; i < t.length; i++) {
            if (t[i] > currentSum + t[i]) {
                currentSum = t[i];
                start = i;
            } else {
                currentSum += t[i];
            }

            if (currentSum > maxSum) {
                maxSum = currentSum;
                bestStart = start;
                bestEnd = i;
            }
        }

        return new int[]{maxSum, bestStart, bestEnd};
    }

    public static void main(String[] args) {
        int[][] tests = {
            {-2, 1, -3, 4, -1, 2, 1, -5, 4}, 
            {1, 2, 3, 4},                   
            {-1, -2, -3},                   
            {5},                             
            {-7},                            
            {-2, -1, 3, 4, -5},              
            {1, -1, 1, -1, 1}                
        };

        for (int[] t : tests) {
            int res = maxSubarraySum(t);
            System.out.print("Tableau : ");
            for (int x : t) System.out.print(x + " ");
            System.out.println("→ Somme max = " + res);
        }

        int[] result = maxSubarrayWithIndices(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
        System.out.println("Somme max = " + result[0] +
                           ", indices = [" + result[1] + " .. " + result[2] + "]");
    }
}

