import java.util.HashMap;

public class Q2_7_Intersection {
    // O(A) space O(A + B) runtime
    private static CustomLinkedList<Integer>.Node intersect(CustomLinkedList<Integer> listA, CustomLinkedList<Integer> listB) {
        HashMap<CustomLinkedList<Integer>.Node, Integer> map = new HashMap<>();

        for (var node = listA.head; node != null; node = node.next) {
            map.put(node, 1);
        }

        for (var node = listB.head; node != null; node = node.next) {
            if (map.containsKey(node)) {
                return node;
            }
        }

        return null;
    }

    // O(1) space O(A + B) runtime
    @SuppressWarnings("unused")
    private static boolean intersect2(CustomLinkedList<Integer> listA, CustomLinkedList<Integer> listB) {
        return listA.tailNode() == listB.tailNode();
    }

    public static void main(String[] args) {
        CustomLinkedList<Integer> listA = new CustomLinkedList<>(1, 2, 3, 4, 5);
        CustomLinkedList<Integer> listB = new CustomLinkedList<>(2, 5, 6);

        System.out.println("--before insertion--");
        System.out.println(intersect(listA, listB));

        var nodeFromA = listA.getNode(3); // value == 4
        listB.putNode(nodeFromA, 2);

        System.out.println("--after insertion--");
        var intersectingNode = intersect(listA, listB);
        assert intersectingNode == nodeFromA;
        System.out.println(intersectingNode.value);
    }
}
