public class Q2_5_SumLists {
    private static MyLinkedList<Integer> sumLists(MyLinkedList<Integer> listA,
            MyLinkedList<Integer> listB) {
        int numberA = readListNumber(listA);
        int numberB = readListNumber(listB);
        int sum = numberA + numberB;
        MyLinkedList<Integer> result = new MyLinkedList<>();

        while (sum > 0) {
            int digit = sum % 10;
            sum -= digit;
            sum /= 10;
            result.add(digit);
        }

        return result;
    }

    private static int readListNumber(MyLinkedList<Integer> list) {
        int number = 0;
        int i = 0;

        for (var node = list.head; node != null; node = node.next) {
            number += node.value * Math.pow(10, i++);
        }

        return number;
    }

    public static void main(String[] args) {
        MyLinkedList<Integer> listA = new MyLinkedList<>(7, 1, 6);
        MyLinkedList<Integer> listB = new MyLinkedList<>(5, 9, 2);

        System.out.println("--list A--");
        listA.printAll();
        System.out.println("--list B--");
        listB.printAll();
        System.out.println("--sum--");
        sumLists(listA, listB).printAll();
    }
}
