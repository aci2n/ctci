package exercises;

import structs.BinaryTreeNode;

public class Q4_10_CheckSubtree {

    private static boolean isSameTree(BinaryTreeNode<Integer> t1, BinaryTreeNode<Integer> t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        if (!t1.value.equals(t2.value)) return false;

        return isSameTree(t1.left, t2.left) && isSameTree(t1.right, t2.right);
    }

    private static boolean isSubtree(BinaryTreeNode<Integer> t1, BinaryTreeNode<Integer> t2) {
        if (t1 == null) return false;
        if (isSameTree(t1, t2)) return true;

        return isSubtree(t1.left, t2) || isSubtree(t1.right, t2);
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

        assert isSubtree(a, d);
        assert !isSubtree(a, j);
    }
}
