import java.util.Stack;

public class MaxRectangle {

    static class Rectangle {
        int top;
        int left;
        int bottom;
        int right;
        int area;

        @Override
        public String toString() {
            return "Rectangle [top=" + top + ", left=" + left +
                   ", bottom=" + bottom + ", right=" + right +
                   ", area=" + area + "]";
        }
    }

    public static int maxRectangle(int[][] m) {
        return trouverMaxRectangle(m).area;
    }

    public static Rectangle trouverMaxRectangle(int[][] m) {
        if (m.length == 0 || m[0].length == 0) return new Rectangle();

        int R = m.length, C = m[0].length;
        int[] heights = new int[C];
        Rectangle best = new Rectangle();
        best.area = 0;

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (m[i][j] == 0) heights[j] = 0;
                else heights[j] += 1;
            }

            Rectangle candidate = largestRectangleInHistogram(heights, i);
            if (candidate.area > best.area) {
                best = candidate;
            }
        }

        return best;
    }

    private static Rectangle largestRectangleInHistogram(int[] heights, int bottomRow) {
        Stack<Integer> stack = new Stack<>();
        Rectangle best = new Rectangle();
        best.area = 0;

        for (int j = 0; j <= heights.length; j++) {
            int h = (j == heights.length ? 0 : heights[j]);
            while (!stack.isEmpty() && h < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int right = j - 1;
                int left = stack.isEmpty() ? 0 : stack.peek() + 1;
                int area = height * (right - left + 1);

                if (area > best.area) {
                    best.area = area;
                    best.top = bottomRow - height + 1;
                    best.bottom = bottomRow;
                    best.left = left;
                    best.right = right;
                }
            }
            stack.push(j);
        }
        return best;
    }

    public static void main(String[] args) {
        int[][] m = {
            {0,1,1,0,1},
            {1,1,1,1,0},
            {1,1,1,1,0},
            {1,1,0,0,1}
        };

        Rectangle r = trouverMaxRectangle(m);
        System.out.println("Max rectangle : " + r);
    }
}

