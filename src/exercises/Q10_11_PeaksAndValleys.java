package exercises;

import misc.Utils;

public class Q10_11_PeaksAndValleys {
    private static void mergeSort(int[] array) {
        mergeSort(array, new int[array.length], 0, array.length - 1);
    }

    private static void mergeSort(int[] array, int[] helper, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(array, helper, low, mid);
            mergeSort(array, helper, mid + 1, high);
            merge(array, helper, low, mid, high);
        }
    }

    private static void merge(int[] array, int[] helper, int low, int mid, int high) {
        for (int i = low; i <= high; i++) {
            helper[i] = array[i];
        }

        int left = low;
        int right = mid + 1;
        int current = low;

        while (left <= mid && right <= high) {
            if (helper[left] >= helper[right]) {
                array[current++] = helper[left++];
            } else {
                array[current++] = helper[right++];
            }
        }

        while (left <= mid) {
            array[current++] = helper[left++];
        }
    }

    private static int[] peaksAndValleys(int[] array) {
        int n = array.length;
        int mid = n / 2;
        int[] result = new int[n];

        mergeSort(array);

        for (int i = 0; i < mid; i++) {
            result[i * 2] = array[i];
            result[i * 2 + 1] = array[n - 1 - i];
        }

        result[n - 1] = array[mid];

        return result;
    }

    public static void main(String[] args) {
        int[] array = new int[]{5, 3, 1, 2, 3};

        System.out.println("--source--");
        Utils.printArray(array);
        System.out.println("--peaks & valleys--");
        Utils.printArray(peaksAndValleys(array));

        array = new int[]{4, 5, 4, 1};
        System.out.println("--source--");
        Utils.printArray(array);
        System.out.println("--peaks & valleys--");
        Utils.printArray(peaksAndValleys(array));
    }
}
