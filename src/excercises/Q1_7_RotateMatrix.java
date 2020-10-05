package excercises;

import structs.Utils;

public class Q1_7_RotateMatrix {
    // O(n^2)
    @SuppressWarnings("unused")
    private static int[][] rotateMatrix(int[][] matrix) {
        int n = matrix.length;
        int[][] rotated = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rotated[j][n - 1 - i] = matrix[i][j];
            }
        }

        return rotated;
    }

    private static int[][] rotateMatrixInPlace(int[][] matrix) {
        int n = matrix.length; // always a square matrix
        int maxI = n / 2;

        for (int i = 0; i < maxI; i++) {
            int maxJ = n - i - 1;

            for (int j = i; j < maxJ; j++) {
                int oppI = maxJ;
                int oppJ = n - 1 - j;

                int a = matrix[i][j];
                int b = matrix[j][oppI];
                int c = matrix[oppI][oppJ];
                int d = matrix[oppJ][i];

                matrix[i][j] = d;
                matrix[j][oppI] = a;
                matrix[oppI][oppJ] = b;
                matrix[oppJ][i] = c;
            }
        }

        return matrix;
    }

    public static void main(String[] args) {
        int[][] test = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25}};

        Utils.printMatrix(test);
        System.out.println("--rotate--");
        Utils.printMatrix(rotateMatrixInPlace(test));
    }
}
