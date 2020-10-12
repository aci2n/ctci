package exercises;

public class Q10_9_SortedMatrixSearch {
    private static class Point {
        int i;
        int j;

        public Point(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return i == point.i && j == point.j;
        }
    }

    private static Point findPoint(int[][] matrix, int value) {
        int n = matrix.length - 1;
        int m = matrix[0].length - 1;

        assert n > 0;
        assert m > 0;

        for (int i = 0; i <= n && m > 0; i++) {
            for (int j = 0; j <= m; j++) {
                if (matrix[i][j] == value) {
                    return new Point(i, j);
                }

                if (matrix[i][j] > value) {
                    m = j - 1;
                    break;
                }
            }
        }

        return null;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 8, 20, 27},
                {4, 19, 23, 35},
                {6, 25, 30, 40},
                {9, 38, 39, 52}
        };

        assert new Point(0, 1).equals(findPoint(matrix, 8));
        assert new Point(0, 0).equals(findPoint(matrix, 1));
        assert new Point(1, 2).equals(findPoint(matrix, 23));
        assert new Point(3, 3).equals(findPoint(matrix, 52));
        assert new Point(3, 2).equals(findPoint(matrix, 39));
        assert new Point(2, 1).equals(findPoint(matrix, 25));
        assert findPoint(matrix, 53) == null;
        assert findPoint(matrix, 0) == null;
    }
}
