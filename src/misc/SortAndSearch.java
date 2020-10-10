package misc;

import static misc.Utils.arraysEqual;
import static misc.Utils.printArray;

public class SortAndSearch {
    private static void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    // O(n^2) runtime, O(1) space
    private static void bubbleSort(int[] array) {
        int limit = array.length - 1;

        for (int i = 0; i < limit; i++) {
            for (int j = 0; j < limit - i; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                }
            }
        }
    }

    // O(n^2) runtime, O(1) space
    private static void selectionSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int min = array[i];
            int index = i;

            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < min) {
                    min = array[j];
                    index = j;
                }
            }

            swap(array, i, index);
        }
    }

    // O(n log(n)) runtime, O(n) space
    private static void mergeSort(int[] array) {
        int[] helper = new int[array.length];
        mergeSort(array, helper, 0, array.length - 1);
    }

    private static void mergeSort(int[] array, int[] helper, int low,
                                  int high) {
        if (low < high) {
            int middle = (high + low) / 2;
            mergeSort(array, helper, low, middle);
            mergeSort(array, helper, middle + 1, high);
            merge(array, helper, low, middle, high);
        }
    }

    private static void merge(int[] array, int[] helper, int low,
                              int middle, int high) {
        for (int i = low; i <= high; i++) {
            helper[i] = array[i];
        }

        int left = low;
        int right = middle + 1;
        int current = low;

        while (left <= middle && right <= high) {
            if (helper[left] <= helper[right]) {
                array[current++] = helper[left++];
            } else {
                array[current++] = helper[right++];
            }
        }

        while (left <= middle) {
            array[current++] = helper[left++];
        }
    }

    // O(n log(n)) avg runtime, O(n^2) worst runtime, O(log(n)) space
    private static void quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private static void quickSort(int[] array, int low, int high) {
        int index = partition(array, low, high);

        if (low < index - 1) {
            quickSort(array, low, index - 1);
        }

        if (high > index) {
            quickSort(array, index, high);
        }
    }

    private static int partition(int[] array, int low, int high) {
        int pivot = array[(low + high) / 2];

        while (low <= high) {
            while (array[low] < pivot) low++;
            while (array[high] > pivot) high--;

            if (low <= high) {
                swap(array, low, high);
                low++;
                high--;
            }
        }

        return low;
    }

    private static int[] unsortedArray() {
        return new int[]{8, 3, 2, -1, 9, 9, 1, 5};
    }

    private static int[] sortedArray() {
        return new int[]{-1, 1, 2, 3, 5, 8, 9, 9};
    }

    private static int binarySearch(int[] array, int value) {
        int low = 0;
        int high = array.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (array[mid] < value) low = mid + 1;
            if (array[mid] > value) high = mid - 1;
            else return mid;
        }

        return -1;
    }

    private static int binarySearchRecursive(int[] array, int value) {
        return binarySearchRecursive(array, value, 0, array.length - 1);
    }

    private static int binarySearchRecursive(int[] array, int value, int low, int high) {
        if (low > high) return -1;
        int mid = (low + high) / 2;
        if (array[mid] > value)
            return binarySearchRecursive(array, value, low, mid - 1);
        if (array[mid] < value)
            return binarySearchRecursive(array, value, mid + 1, high);
        return mid;
    }

    public static void main(String[] args) {
        int[] sorted = sortedArray();
        int[] a1 = unsortedArray();
        bubbleSort(a1);
        printArray(a1);
        assert arraysEqual(a1, sorted);

        int[] a2 = unsortedArray();
        selectionSort(a2);
        printArray(a2);
        assert arraysEqual(a2, sorted);

        int[] a3 = unsortedArray();
        mergeSort(a3);
        printArray(a3);
        assert arraysEqual(a3, sorted);

        int[] a4 = unsortedArray();
        quickSort(a4);
        printArray(a4);
        assert arraysEqual(a4, sorted);

        assert binarySearch(a4, -1) == 0;
        assert binarySearchRecursive(a4, -1) == 0;

        assert binarySearch(a4, 3) == 3;
        assert binarySearchRecursive(a4, 3) == 3;
    }
}
