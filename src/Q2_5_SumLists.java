public class Q2_5_SumLists {
    private static CustomLinkedList<Integer> sumLists(CustomLinkedList<Integer> listA,
            CustomLinkedList<Integer> listB) {
        int numberA = readListNumber(listA);
        int numberB = readListNumber(listB);
        int sum = numberA + numberB;
        CustomLinkedList<Integer> result = new CustomLinkedList<>();

        while (sum > 0) {
            int digit = sum % 10;
            sum -= digit;
            sum /= 10;
            result.add(digit);
        }

        return result;
    }

    private static int readListNumber(CustomLinkedList<Integer> list) {
        int number = 0;
        int i = 0;

        for (var node = list.head; node != null; node = node.next) {
            number += node.value * Math.pow(10, i++);
        }

        return number;
    }

    public static void main(String[] args) {
        CustomLinkedList<Integer> listA = new CustomLinkedList<>(7, 1, 6);
        CustomLinkedList<Integer> listB = new CustomLinkedList<>(5, 9, 2);

        System.out.println("--list A--");
        listA.printAll();
        System.out.println("--list B--");
        listB.printAll();
        System.out.println("--sum--");
        sumLists(listA, listB).printAll();
    }
}
