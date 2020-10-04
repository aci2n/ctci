public class Q2_4_Partition {
    // O(1) space O(N) runtime
    private static void partition(MyLinkedList<Integer> list, int part) {
        Node<Integer> leftNodeSearchStart = null;

        for (var rightNode = list.head; rightNode != null; rightNode = rightNode.next) {
            int rightNodeValue = rightNode.value;

            if (rightNodeValue < part) {
                continue;
            }

            if (leftNodeSearchStart == null) {
                leftNodeSearchStart = rightNode.next;
            }

            var leftNode = searchNextLeftNode(leftNodeSearchStart, part);

            if (leftNode == null) {
                return;
            }

            rightNode.value = leftNode.value;
            leftNode.value = rightNodeValue;
            leftNodeSearchStart = leftNode.next;
        }
    }

    private static Node<Integer> searchNextLeftNode(Node<Integer> head, int part) {
        for (var node = head; node != null; node = node.next) {
            if (node.value < part) {
                return node;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<>(3, 5, 8, 5, 10, 2, 1, 2, 1, 1, 1);   
        list.printAll();

        System.out.println("--partition 5--");
        partition(list, 5);
        list.printAll();
    }
}
