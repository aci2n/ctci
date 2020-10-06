package exercises;

import structs.BinaryTreeNode;
import structs.Utils;

public class Q4_6_Successor {
    private static BinaryTreeNode<Integer> getMinNode(BinaryTreeNode<Integer> root) {
        if (root.left == null) return root;
        return getMinNode(root);
    }

    private static BinaryTreeNode<Integer> getFirstZurditoAncestor(BinaryTreeNode<Integer> node) {
        if (node.parent == null) return null;
        if (node.parent.left == node) return node.parent;
        return getFirstZurditoAncestor(node.parent);
    }

    private static BinaryTreeNode<Integer> getSuccessor(BinaryTreeNode<Integer> node) {
        if (node.right != null) return getMinNode(node.right);
        return getFirstZurditoAncestor(node);
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> a = new BinaryTreeNode<>(100);
        BinaryTreeNode<Integer> b = new BinaryTreeNode<>(40);
        BinaryTreeNode<Integer> c = new BinaryTreeNode<>(70);
        BinaryTreeNode<Integer> d = new BinaryTreeNode<>(30);
        BinaryTreeNode<Integer> e = new BinaryTreeNode<>(15);
        BinaryTreeNode<Integer> f = new BinaryTreeNode<>(35);
        BinaryTreeNode<Integer> g = new BinaryTreeNode<>(20);
        BinaryTreeNode<Integer> h = new BinaryTreeNode<>(28);
        BinaryTreeNode<Integer> i = new BinaryTreeNode<>(38);

        a.setLeft(b);
        a.setRight(c);
        b.setLeft(d);
        d.setLeft(e);
        d.setRight(f);
        e.setRight(g);
        f.setRight(i);
        g.setRight(h);

        Utils.printTree(a);

        assert getSuccessor(i) == b;
        assert getSuccessor(h) == d;
        assert getSuccessor(d) == f;
        assert getSuccessor(e) == g;
    }
}
