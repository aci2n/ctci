package exercises;

import structs.BinaryTreeNode;
import structs.Utils;

public class Q4_8_FirstCommonAncestor {
    private static class SearchStatus {
        int count;

        boolean done() {
            return count == 2;
        }
    }

    private static BinaryTreeNode<Integer> getFirstCommonAncestor(BinaryTreeNode<Integer> root,
                                                                  BinaryTreeNode<Integer> first,
                                                                  BinaryTreeNode<Integer> second) {
        return getFirstCommonAncestor(root, first, second, new SearchStatus());
    }

    private static BinaryTreeNode<Integer> getFirstCommonAncestor(BinaryTreeNode<Integer> root,
                                                                  BinaryTreeNode<Integer> first,
                                                                  BinaryTreeNode<Integer> second,
                                                                  SearchStatus status) {
        if (root == null) return null;
        if (root == first) status.count++;
        if (root == second) status.count++;

        int startingCount = status.count;

        if (!status.done()) {
            BinaryTreeNode<Integer> left = getFirstCommonAncestor(root.left, first, second, status);
            if (left != null) return left;
        }

        if (!status.done()) {
            BinaryTreeNode<Integer> right = getFirstCommonAncestor(root.right, first, second, status);
            if (right != null) return right;
        }

        return startingCount == 0 && status.done() ? root : null;
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> a = new BinaryTreeNode<>(1);
        BinaryTreeNode<Integer> b = new BinaryTreeNode<>(2);
        BinaryTreeNode<Integer> c = new BinaryTreeNode<>(3);
        BinaryTreeNode<Integer> d = new BinaryTreeNode<>(4);
        BinaryTreeNode<Integer> e = new BinaryTreeNode<>(5);
        BinaryTreeNode<Integer> f = new BinaryTreeNode<>(6);
        BinaryTreeNode<Integer> g = new BinaryTreeNode<>(7);
        BinaryTreeNode<Integer> h = new BinaryTreeNode<>(8);
        BinaryTreeNode<Integer> i = new BinaryTreeNode<>(9);
        BinaryTreeNode<Integer> j = new BinaryTreeNode<>(10); // not in the tree

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        e.left = f;
        e.right = g;
        c.right = h;
        h.left = i;

        Utils.printTree(a);

        assert getFirstCommonAncestor(a, b, c) == a;
        assert getFirstCommonAncestor(a, h, i) == c;
        assert getFirstCommonAncestor(a, f, i) == a;
        assert getFirstCommonAncestor(a, e, f) == b;
        assert getFirstCommonAncestor(a, d, g) == b;
        assert getFirstCommonAncestor(a, f, g) == e;
        assert getFirstCommonAncestor(a, f, g) == e;
        assert getFirstCommonAncestor(a, f, j) == null;
        assert getFirstCommonAncestor(a, b, b) == a;
    }
}
