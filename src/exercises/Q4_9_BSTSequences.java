package exercises;

import structs.BinaryTreeNode;
import structs.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;

public class Q4_9_BSTSequences {
    private static void fillOrderMap(HashMap<Integer, Integer> map, BinaryTreeNode<Integer> root, Integer parent) {
        if (root == null) return;
        map.put(root.value, parent);
        fillOrderMap(map, root.left, root.value);
        fillOrderMap(map, root.right, root.value);
    }

    private static void findBSTSequences(ArrayList<ArrayList<Integer>> sequences,
                                         LinkedList<Integer> sequence,
                                         HashMap<Integer, Integer> orderMap) {
        if (orderMap.isEmpty()) {
            sequences.add(new ArrayList<>(sequence));
            return;
        }

        for (var entry : orderMap.entrySet()) {
            Integer candidate = entry.getKey();
            Integer constraint = entry.getValue();

            if (constraint == null || sequence.contains(constraint)) {
                HashMap<Integer, Integer> newOrderMap = new LinkedHashMap<>(orderMap);
                newOrderMap.remove(candidate);
                sequence.add(candidate);
                findBSTSequences(sequences, sequence, newOrderMap);
                sequence.removeLast();
            }
        }
    }

    private static ArrayList<ArrayList<Integer>> findBSTSequences(BinaryTreeNode<Integer> root) {
        HashMap<Integer, Integer> orderMap = new LinkedHashMap<>();
        fillOrderMap(orderMap, root, null);
        ArrayList<ArrayList<Integer>> sequences = new ArrayList<>();
        findBSTSequences(sequences, new LinkedList<>(), orderMap);
        return sequences;
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

        var sequences = findBSTSequences(a);

        for (var sequence : sequences) {
            for (int value : sequence) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}
