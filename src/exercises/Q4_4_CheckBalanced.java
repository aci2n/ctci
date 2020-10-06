package exercises;

import structs.BinaryTreeNode;
import structs.Utils;

public class Q4_4_CheckBalanced {
    private static boolean isBalanced(BinaryTreeNode<Integer> root) {
        return Math.abs(getHeight(root.left, 0) - getHeight(root.right, 0)) <= 1;
    }

    private static int getHeight(BinaryTreeNode<Integer> root, int depth) {
        if (root == null) return depth;

        return Math.max(
                getHeight(root.left, depth + 1),
                getHeight(root.right, depth + 1));
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
        assert getHeight(a, 0) == 5;

        System.out.println("--make tree balanced--");
        f.left = null;
        Utils.printTree(a);

        assert isBalanced(a);
        assert getHeight(a, 0) == 4;

        e.right = null;
        assert isBalanced(a);
        assert getHeight(a, 0) == 3;

        c.left = null;
        assert isBalanced(a);
        assert getHeight(a, 0) == 3;
    }
}
