public class Q1_8_ZeroMatrix {

    private static void zeroMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return;

        int sentinel = -1;
        int n = matrix.length;
        int m = matrix[0].length;

        for (int i = 0; i < n; i++) {
            assert matrix[i].length == m;

            for (int j = 0; j < m; j++) {
                if (matrix[i][j] != 0)
                    continue;

                fillRowAndColumn(matrix, i, j, sentinel);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == sentinel) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    // O(n + m)
    private static void fillRowAndColumn(int[][] matrix, int row, int column, int value) {
        int n = matrix.length;
        int m = matrix[0].length;

        for (int i = 0; i < n; i++) {
            matrix[i][column] = value;
        }

        for (int j = 0; j < m; j++) {
            matrix[row][j] = value;
        }
    }

    public static void main(String[] args) {
        int[][] test = { { 1, 2, 3, 4, 0 }, { 6, 7, 0, 9, 10 }, { 11, 12, 13, 14, 15 }, { 16, 17, 18, 19, 20 },
                { 21, 22, 23, 24, 25 } };

        Utils.printMatrix(test);
        zeroMatrix(test);
        System.out.println("--zero matrix--");
        Utils.printMatrix(test);
    }
}
