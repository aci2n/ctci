package excercises;

import structs.MyLinkedList;

import java.util.HashMap;
import java.util.Map;

public class Q2_1_RemoveDups {
    // O(1) space O(n2) runtime
    @SuppressWarnings("unused")
    private static MyLinkedList<Integer> removeDupsN2(MyLinkedList<Integer> list) {
        for (var nodeA = list.head; nodeA != null; nodeA = nodeA.next) {
            var prev = nodeA;

            for (var nodeB = nodeA.next; nodeB != null; nodeB = nodeB.next) {
                if (nodeB.value.equals(nodeA.value)) {
                    prev.next = nodeB.next;
                } else {
                    prev = nodeB;
                }
            }
        }

        return list;
    }

    // O(N) space O(N) runtime
    private static MyLinkedList<Integer> removeDupsN(MyLinkedList<Integer> list) {
        Map<Integer, Boolean> map = new HashMap<>();
        MyLinkedList<Integer> deduped = new MyLinkedList<>();

        for (var node = list.head; node != null; node = node.next) {
            if (map.containsKey(node.value)) {
                continue;
            }

            map.put(node.value, true);
            deduped.add(node.value);
        }

        return deduped;
    }

    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<>(1, 6, 2, 6, 8, 3, 10, 2, 1, 9);

        list.printAll();

        System.out.println("--remove dups--");
        var deduped = removeDupsN(list);
        deduped.printAll();
    }
}
