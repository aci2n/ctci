package excercises;

import structs.BinarySearchTree;
import structs.Utils;

public class Q4_2_MinimalTree {
    private static BinarySearchTree createMinimalTree(
            int[] values) {
        BinarySearchTree tree = new BinarySearchTree();
        fillMinimalSearchTree(tree, values, 0, values.length);
        return tree;
    }

    private static void fillMinimalSearchTree(BinarySearchTree tree,
                                              int[] values,
                                              int start,
                                              int end) {
        if (start == end) return;
        int middle = start + (end - start) / 2;
        tree.insert(values[middle]);
        fillMinimalSearchTree(tree, values, start, middle);
        fillMinimalSearchTree(tree, values, middle + 1, end);
    }

    public static void main(String[] args) {
        BinarySearchTree tree = createMinimalTree(new int[]{0, 1, 2, 3, 4, 5,
                6, 7, 8, 9, 10, 11, 12, 13, 14});
        Utils.printTree(tree.root);
    }
}
