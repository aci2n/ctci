package exercises;

import structs.MyLinkedList;

public class Q2_2_KthToLast {
    // O(k) space O(N) runtime
    private static int kthToLast(MyLinkedList<Integer> list, int k) {
        int[] buffer = new int[k + 1];
        int index = 0;
        int size = 0;

        for (var node = list.head; node != null; node = node.next) {
            buffer[index] = node.value;
            index = index == k ? 0 : index + 1;
            size++;
        }

        if (k >= size) {
            throw new IndexOutOfBoundsException();
        }

        return buffer[index];
    }

    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<>(5, 4, 3, 2, 1, 0);
        System.out.println(String.format("%dth to last: %d", 0, kthToLast(list, 0)));
        System.out.println(String.format("%dth to last: %d", 2, kthToLast(list, 2)));
        System.out.println(String.format("%dth to last: %d", 5, kthToLast(list, 5)));
    }
}
