package exercises;

public class Q10_3_SearchRotatedArray {
    private static int binarySearch(int[] array, int value, int low, int high) {
        while (low <= high) {
            int mid = (low + high) / 2;
            if (array[mid] > value) high = mid - 1;
            else if (array[mid] < value) low = mid + 1;
            else return mid;
        }
        return -1;
    }

    private static int getInflection(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i + 1] < array[i]) return i + 1;
        }
        return 0;
    }

    private static int searchRotatedArray(int[] array, int value) {
        int inflection = getInflection(array);

        // check the larger values first
        if (inflection != 0 && value >= array[0]) {
            return binarySearch(array, value, 0, inflection - 1);
        }

        return binarySearch(array, value, inflection, array.length - 1);
    }

    public static void main(String[] args) {
        int[] array = new int[]{15, 16, 19, 20, 24, 1, 3, 4, 5, 7, 10, 14};
        assert searchRotatedArray(array, 15) == 0;
        assert searchRotatedArray(array, 5) == 8;
        assert searchRotatedArray(array, 20) == 3;
        assert searchRotatedArray(array, 16) == 1;
        assert searchRotatedArray(array, 14) == 11;
        assert searchRotatedArray(array, 1) == 5;

        array = new int[]{1, 3, 4, 5, 7, 10, 14};
        assert searchRotatedArray(array, 1) == 0;
        assert searchRotatedArray(array, 3) == 1;
        assert searchRotatedArray(array, 5) == 3;
        assert searchRotatedArray(array, 14) == 6;
    }
}
