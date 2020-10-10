package exercises;

import misc.BinaryTreeNode;
import misc.Utils;

import java.util.ArrayList;
import java.util.LinkedList;

public class Q4_9_BSTSequences_v2 {
    private static void weave(ArrayList<LinkedList<Integer>> results,
                              LinkedList<Integer> listA,
                              LinkedList<Integer> listB,
                              LinkedList<Integer> prefix) {
        if (listA.isEmpty() || listB.isEmpty()) {
            LinkedList<Integer> result = new LinkedList<>(prefix);
            result.addAll(listA);
            result.addAll(listB);
            results.add(result);
            return;
        }

        prefix.addLast(listA.removeFirst());
        weave(results, listA, listB, prefix);
        listA.addFirst(prefix.removeLast());

        prefix.addLast(listB.removeFirst());
        weave(results, listA, listB, prefix);
        listB.addFirst(prefix.removeLast());
    }

    private static ArrayList<LinkedList<Integer>> getBSTSequences(BinaryTreeNode<Integer> root) {
        ArrayList<LinkedList<Integer>> results = new ArrayList<>();

        if (root == null) {
            results.add(new LinkedList<>());
            return results;
        }

        LinkedList<Integer> prefix = new LinkedList<>();
        prefix.add(root.value);

        for (LinkedList<Integer> listA : getBSTSequences(root.left)) {
            for (LinkedList<Integer> listB : getBSTSequences(root.right)) {
                weave(results, listA, listB, prefix);
            }
        }

        return results;
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> a = new BinaryTreeNode<>(10);
        BinaryTreeNode<Integer> b = new BinaryTreeNode<>(5);
        BinaryTreeNode<Integer> c = new BinaryTreeNode<>(15);
        BinaryTreeNode<Integer> d = new BinaryTreeNode<>(20);
        BinaryTreeNode<Integer> e = new BinaryTreeNode<>(2);

        a.left = b;
        a.right = c;
        b.left = e;
        c.right = d;

        Utils.printTree(a);

        for (LinkedList<Integer> sequence : getBSTSequences(a)) {
            for (int value : sequence) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}
