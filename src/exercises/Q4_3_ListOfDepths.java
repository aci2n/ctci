package exercises;

import structs.BinaryTreeNode;
import structs.Node;
import structs.Utils;

import java.util.LinkedList;

public class Q4_3_ListOfDepths {
    private static class NodeList extends LinkedList<BinaryTreeNode<Integer>> {
    }

    private static Node<NodeList> listOfDepths(BinaryTreeNode<Integer> root) {
        Node<NodeList> listRoot = new Node<>(null);
        fillList(listRoot, root, 0);
        return listRoot.next;
    }

    private static void fillList(Node<NodeList> parent,
                                 BinaryTreeNode<Integer> root,
                                 int depth) {
        if (root == null) return;

        if (parent.next == null) {
            parent.next = new Node<>(new NodeList());
        }

        parent.next.value.add(root);

        fillList(parent.next, root.left, depth + 1);
        fillList(parent.next, root.right, depth + 1);
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

        a.left = b;
        a.right = c;
        b.left = d;
        c.left = e;
        e.right = f;
        f.left = g;
        f.right = h;
        h.left = i;

        Utils.printTree(a);
        var listRoot = listOfDepths(a);

        for (Node<NodeList> walker = listRoot; walker != null; walker =
                walker.next) {
            for (BinaryTreeNode<Integer> node : walker.value) {
                System.out.print(node.value + " ");
            }
            System.out.println();
        }
    }
}
