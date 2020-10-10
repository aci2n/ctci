package exercises;

import misc.BinaryTreeNode;
import misc.Utils;

public class Q4_4_CheckBalanced {
    private static boolean isBalanced(BinaryTreeNode<Integer> root) {
        return getHeight(root, 1) != -1;
    }

    private static int getHeight(BinaryTreeNode<Integer> root, int depth) {
        if (root == null) return depth;
        int heightLeft = getHeight(root.left, depth + 1);
        if (heightLeft == -1) return -1;
        int heightRight = getHeight(root.right, depth + 1);
        if (heightRight == -1) return -1;
        int diff = Math.abs(heightLeft - heightRight);
        if (diff > 1) return -1;
        return Math.max(heightLeft, heightRight);
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> a = new BinaryTreeNode<>(1);
        BinaryTreeNode<Integer> b = new BinaryTreeNode<>(2);
        BinaryTreeNode<Integer> c = new BinaryTreeNode<>(3);
        BinaryTreeNode<Integer> d = new BinaryTreeNode<>(4);
        BinaryTreeNode<Integer> e = new BinaryTreeNode<>(5);
        BinaryTreeNode<Integer> f = new BinaryTreeNode<>(6);
        BinaryTreeNode<Integer> g = new BinaryTreeNode<>(7);

        a.left = b;
        a.right = c;
        b.left = d;
        c.left = e;
        e.right = f;
        f.left = g;

        Utils.printTree(a);
        assert !isBalanced(a);

        f.left = null;
        assert !isBalanced(a);

        e.right = null;
        assert isBalanced(a);

        c.left = null;
        assert isBalanced(a);

        a.right = null;
        assert !isBalanced(a);
    }
}
