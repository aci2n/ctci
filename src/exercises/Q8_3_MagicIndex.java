package exercises;

public class Q8_3_MagicIndex {
    private static int findMagicIndex(int[] array) {
        return findMagicIndex(array, 0, array.length - 1);
    }

    private static int findMagicIndex(int[] array,
                                      int low,
                                      int high) {
        if (low > high) {
            return -1;
        }

        int mid = (low + high) / 2;

        if (array[mid] > mid) {
            int nextHigh = Math.min(mid - 1, array[mid]);
            return findMagicIndex(array, low, nextHigh);
        }

        if (array[mid] < mid) {
            int nextLow = Math.max(mid + 1, array[mid]);
            return findMagicIndex(array, nextLow, high);
        }

        return mid;
    }

    public static void main(String[] args) {
       int[] array = new int[]{-20, -10, -1, 0, 2, 2, 5, 7, 20};
       //                        0    1   2  3  4  5  6  7   8
       assert findMagicIndex(array) == 7;
    }
}
