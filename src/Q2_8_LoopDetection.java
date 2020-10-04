public class Q2_8_LoopDetection {
    // O(1) space O(NM) runtime; N = list size, M = loop size
    private static Node<Integer> detectLoop(MyLinkedList<Integer> list) {
        var slow = list.head;
        var fast = list.head;

        do {
            if (fast.next == null || fast.next.next == null) {
                return null;
            }

            slow = slow.next;
            fast = fast.next.next;
        } while (slow != fast);

        var nodeInLoop = slow;
        int loopSize = 1;

        for (var walker = nodeInLoop.next; walker != nodeInLoop; walker = walker.next) {
            loopSize++;
        }

        for (var candidate = list.head; candidate != null; candidate = candidate.next) {
            var walker = candidate.next;

            for (int i = 1; i < loopSize; i++) {
                walker = walker.next;
            }

            if (candidate == walker) {
                return candidate;
            }
        }

        throw new RuntimeException();
    }
    
    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<>(0, 1, 2, 3, 4, 5, 6);
        list.tailNode().next = list.getNode(2); // value == node index

        System.out.println(String.format("loop beginning: %s", detectLoop(list)));
    }
}
