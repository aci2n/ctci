package exercises;

import structs.BinaryTreeNode;
import structs.Utils;

import java.util.ArrayList;
import java.util.LinkedList;

public class Q4_9_BSTSequences_v2 {
    private static void weaveLeft(ArrayList<LinkedList<Integer>> results,
                                  LinkedList<Integer> left,
                                  LinkedList<Integer> right,
                                  LinkedList<Integer> prefix) {
        if (right.isEmpty()) {
            return;
        }

        if (left.isEmpty()) {
            LinkedList<Integer> result = new LinkedList<>(prefix);
            result.addAll(right);
            results.add(result);
            return;
        }

        prefix.addLast(left.removeFirst());
        weave(results, left, right, prefix);
        left.addFirst(prefix.removeLast());
    }

    private static void weave(ArrayList<LinkedList<Integer>> results,
                              LinkedList<Integer> listA,
                              LinkedList<Integer> listB,
                              LinkedList<Integer> prefix) {
        weaveLeft(results, listA, listB, prefix);
        weaveLeft(results, listB, listA, prefix);
    }

    private static ArrayList<LinkedList<Integer>> weaveAll(ArrayList<LinkedList<Integer>> results,
                                                           ArrayList<LinkedList<Integer>> listsA,
                                                           ArrayList<LinkedList<Integer>> listsB) {
        LinkedList<Integer> prefix = new LinkedList<>();

        for (LinkedList<Integer> listA : listsA) {
            for (LinkedList<Integer> listB : listsB) {
                weave(results, listA, listB, prefix);
            }
        }

        return results;
    }

    private static ArrayList<LinkedList<Integer>> getBSTSequences(BinaryTreeNode<Integer> root) {
        ArrayList<LinkedList<Integer>> results = new ArrayList<>();

        if (root == null) {
            results.add(new LinkedList<>());
            return results;
        }

        if (root.left == null && root.right == null) {
            LinkedList<Integer> base = new LinkedList<>();
            base.addFirst(root.value);
            results.add(base);
            return results;
        }

        weaveAll(results, getBSTSequences(root.left), getBSTSequences(root.right));

        for (LinkedList<Integer> list : results) {
            list.addFirst(root.value);
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
