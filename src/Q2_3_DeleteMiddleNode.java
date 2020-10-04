public class Q2_3_DeleteMiddleNode {
    private static void deleteMiddleNode(Node<Integer> node) {
        if (node.next == null) {
            throw new IllegalArgumentException("cannot delete tail");
        }

        while (node != null) {
            node.value = node.next.value;

            if (node.next.next == null) {
                node.next = null;
            }

            node = node.next;
        }
    }

    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<>(0, 1, 2, 3, 4, 5);
        list.printAll();

        System.out.println("--delete node 2--");
        var node = list.getNode(2);
        deleteMiddleNode(node);
        list.printAll();
    }
}
