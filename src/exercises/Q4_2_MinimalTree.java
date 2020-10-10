package exercises;

import misc.BinaryTreeNode;
import misc.Utils;

public class Q4_2_MinimalTree {
    private static BinaryTreeNode<Integer> createMinimalTree(int[] values) {
        return fillMinimalSearchTree(values, 0, values.length - 1);
    }

    private static BinaryTreeNode<Integer> fillMinimalSearchTree(
            int[] values,
            int start,
            int end) {
        if (start > end) return null;

        int middle = start + (end - start) / 2;
        var node = new BinaryTreeNode<>(values[middle]);

        node.left = fillMinimalSearchTree(values, start, middle - 1);
        node.right = fillMinimalSearchTree(values, middle + 1, end);

        return node;
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = createMinimalTree(new int[]{
                0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14});
        Utils.printTree(root);
    }
}
