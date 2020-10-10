package exercises;

import misc.BinaryTreeNode;

public class Q4_12_PathsWithSum {
    static int countPathsWithSum(BinaryTreeNode<Integer> root, int target) {
        return countPathsWithSum(root, target, 0, false);
    }

    static int countPathsWithSum(BinaryTreeNode<Integer> root,
                                 int target,
                                 int sum,
                                 boolean started) {
        if (root == null) return 0;

        int updated = root.value + sum;
        int result = updated == target ? 1 : 0;

        result += countPathsWithSum(root.left, target, updated, true);
        result += countPathsWithSum(root.right, target, updated, true);

        if (!started) {
            result += countPathsWithSum(root.left, target, sum, false);
            result += countPathsWithSum(root.right, target, sum, false);
        }

        return result;
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> a = new BinaryTreeNode<>(10);
        BinaryTreeNode<Integer> b = new BinaryTreeNode<>(5);
        BinaryTreeNode<Integer> c = new BinaryTreeNode<>(15);
        BinaryTreeNode<Integer> d = new BinaryTreeNode<>(3);
        BinaryTreeNode<Integer> e = new BinaryTreeNode<>(12);
        BinaryTreeNode<Integer> f = new BinaryTreeNode<>(18);
        BinaryTreeNode<Integer> g = new BinaryTreeNode<>(2);
        BinaryTreeNode<Integer> h = new BinaryTreeNode<>(4);
        BinaryTreeNode<Integer> i = new BinaryTreeNode<>(13);
        BinaryTreeNode<Integer> j = new BinaryTreeNode<>(-1);

        a.left = b;
        a.right = c;
        b.left = d;
        d.left = g;
        d.right = h;
        c.left = e;
        c.right = f;
        e.right = i;
        g.left = j;

        assert countPathsWithSum(a, 15) == 2;
        assert countPathsWithSum(a, 18) == 2;
        assert countPathsWithSum(a, 13) == 1;
        assert countPathsWithSum(a, 12) == 2;
        assert countPathsWithSum(a, -1) == 1;
        assert countPathsWithSum(a, 1) == 1;
        assert countPathsWithSum(a, 4) == 2;
    }
}
