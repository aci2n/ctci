public final class Utils {
    public static void printMatrix(int[][] matrix) {
        assert matrix != null : "matrix cannot be null";

        int n = matrix.length;
        assert n > 0 : "matrix must have at least 1 row";

        int m = matrix[0].length;
        assert m > 0 : "matrix must have at least 1 column";

        for (int i = 0; i < n; i++) {
            assert matrix[i].length == m: "all matrix rows must be the same size";
            
            for (int j = 0; j < m; j++) {
                System.out.print(String.format("%02d ", matrix[i][j]));
            }

            System.out.println();
        }
    }
}
