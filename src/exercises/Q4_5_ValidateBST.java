package exercises;

import structs.BinaryTreeNode;
import structs.Utils;

public class Q4_5_ValidateBST {
    private static class Result {
        private int min;
        private int max;

        private Result(int value) {
            min = value;
            max = value;
        }
    }

    private static boolean isBST(BinaryTreeNode<Integer> root) {
        if (root == null) return false;
        return validateBST(root) != null;
    }

    private static Result validateBST(BinaryTreeNode<Integer> root) {
        Result result = new Result(root.value);

        if (root.left != null) {
            Result left = validateBST(root.left);
            if (left == null || left.max > root.value) return null;
            result.min = left.min;
        }

        if (root.right != null) {
            Result right = validateBST(root.right);
            if (right == null || right.min <= root.value) return null;
            result.max = right.max;
        }

        return result;
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> a = new BinaryTreeNode<>(6);
        BinaryTreeNode<Integer> b = new BinaryTreeNode<>(3);
        BinaryTreeNode<Integer> c = new BinaryTreeNode<>(4);
        BinaryTreeNode<Integer> d = new BinaryTreeNode<>(8);
        BinaryTreeNode<Integer> e = new BinaryTreeNode<>(7);
        BinaryTreeNode<Integer> f = new BinaryTreeNode<>(9);

        // 6 -> 3, 8
        a.left = b;
        a.right = d;

        // 3 -> X, 4
        b.right = c;

        // 8 -> 7, 9
        d.left = e;
        d.right = f;

        Utils.printTree(a);
        assert isBST(a);

        // 8 -> 5, 9
        e.value = 6; // <= root, should be on the left
        assert !isBST(a);
    }
}
