package exercises;

import misc.Utils;

public class Q10_1_SortedMerge {
    private static void sortedMerge(int[] arrayA, int[] arrayB) {
        int a = arrayA.length - arrayB.length - 1;
        int b = arrayB.length - 1;

        while (a >= 0 && b >= 0) {
            if (arrayB[b] < arrayA[a]) {
                arrayA[a + b + 1] = arrayA[a];
                a--;
            } else {
                arrayA[a + b + 1] = arrayB[b];
                b--;
            }
        }

        while (b >= 0) {
            arrayA[b] = arrayB[b];
            b--;
        }
    }

    public static void main(String[] args) {
        int[] arrayA = new int[]{1, 3, 15, 18, 0, 0, 0};
        int[] arrayB = new int[]{1, 5, 9};
        int[] expected = new int[]{1, 1, 3, 5, 9, 15, 18};

        sortedMerge(arrayA, arrayB);

        Utils.printArray(arrayA);
        assert Utils.arraysEqual(arrayA, expected);

        arrayA = new int[]{8, 0, 0, 0};
        arrayB = new int[]{4, 6, 9};
        expected = new int[]{4, 6, 8, 9};

        sortedMerge(arrayA, arrayB);

        Utils.printArray(arrayA);
        assert Utils.arraysEqual(arrayA, expected);
    }
}
