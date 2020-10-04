public class Q2_6_Palindrome {
    private static class Match {
        CustomLinkedList<Integer>.Node nextNode;
        boolean matched;

        Match(CustomLinkedList<Integer>.Node nextNode, boolean matched) {
            this.nextNode = nextNode;
            this.matched = matched;
        }
    }

    // O(N) space O(N) runtime
    private static boolean isPalindrome(CustomLinkedList<Integer> list) {
        int size = 0;

        for (var node = list.head; node != null; node = node.next) {
            size++;
        }

        return matchNode(list.head, size, 0).matched;
    }

    private static Match matchNode(CustomLinkedList<Integer>.Node head, int size, int depth) {
        if (depth == size / 2) {
            return new Match(size % 2 == 0 ? head : head.next, true);
        }

        Match match = matchNode(head.next, size, depth + 1);
        boolean matched = match.matched && head.value == match.nextNode.value;
        return new Match(match.nextNode.next, matched);
    }

    public static void main(String[] args) {
        CustomLinkedList<Integer> listA = new CustomLinkedList<>(1, 2, 3, 2, 1);
        CustomLinkedList<Integer> listB = new CustomLinkedList<>(1, 2, 3, 3, 2, 1);
        CustomLinkedList<Integer> listC = new CustomLinkedList<>(1, 3, 4, 4, 1);

        System.out.println(String.format("listA: %b", isPalindrome(listA)));
        System.out.println(String.format("listB: %b", isPalindrome(listB)));
        System.out.println(String.format("listC: %b", isPalindrome(listC)));
    }
}
