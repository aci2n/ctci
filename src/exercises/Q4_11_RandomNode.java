package exercises;

import structs.BinaryTreeNode;

import java.util.ArrayList;

public class Q4_11_RandomNode {
    private static class RandomNodeTree {
        ArrayList<BinaryTreeNode<Integer>> indexedNodes;
        BinaryTreeNode<Integer> root;

        RandomNodeTree(int... values) {
            indexedNodes = new ArrayList<>();

            for (int value : values) {
                insert(value);
            }
        }

        void insert(int value) {
            BinaryTreeNode<Integer> node = new BinaryTreeNode<>(value);
            root = insert(root, node);
            indexedNodes.add(node);
        }

        BinaryTreeNode<Integer> insert(BinaryTreeNode<Integer> head, BinaryTreeNode<Integer> node) {
            if (head == null) return node;

            if (node.value <= head.value) {
                head.left = insert(head.left, node);
                head.left.parent = head;
            } else {
                head.right = insert(head.right, node);
                head.right.parent = head;
            }

            return head;
        }

        BinaryTreeNode<Integer> find(int value) {
            return find(root, value);
        }

        BinaryTreeNode<Integer> find(BinaryTreeNode<Integer> head, int value) {
            if (head == null) return null;
            if (head.value == value) return head;
            return value < head.value ? find(head.left, value) : find(head.right, value);
        }

        void delete(int value) {
            indexedNodes.remove(delete(root, value));
        }

        BinaryTreeNode<Integer> getSmallest(BinaryTreeNode<Integer> head) {
            return head.left == null ? head : getSmallest(head.left);
        }

        void replace(BinaryTreeNode<Integer> oldChild, BinaryTreeNode<Integer> newChild) {
            BinaryTreeNode<Integer> parent = oldChild.parent;

            if (parent == null) {
                root = newChild;
            } else if (parent.left == oldChild) {
                parent.left = newChild;
            } else {
                parent.right = newChild;
            }

            if (newChild != null) {
                newChild.parent = parent;
                newChild.left = oldChild.left == newChild ? null : oldChild.left;
                newChild.right = oldChild.right == newChild ? null : oldChild.right;
            }

            oldChild.left = null;
            oldChild.right = null;
            oldChild.parent = null;
        }

        BinaryTreeNode<Integer> delete(BinaryTreeNode<Integer> head, int value) {
            if (head == null) return null;

            if (head.value == value) {
                if (head.left == null && head.right == null) {
                    replace(head, null);
                } else if (head.left == null) {
                    replace(head, head.right);
                } else if (head.right == null) {
                    replace(head, head.left);
                } else {
                    BinaryTreeNode<Integer> nextInOrder = getSmallest(head.right);
                    replace(head, delete(nextInOrder, nextInOrder.value));
                }

                return head;
            }

            return value < head.value ? delete(head.left, value) : delete(head.right, value);
        }

        BinaryTreeNode<Integer> getRandomNode() {
            return indexedNodes.get((int) Math.floor(Math.random() * indexedNodes.size()));
        }
    }

    public static void main(String[] args) {
        RandomNodeTree tree = new RandomNodeTree(10, 5, 15, 3, 2, 4, 12, 18, 13);

        assert tree.find(10) != null;
        tree.delete(10);
        assert tree.find(10) == null;
        assert tree.root.value == 12;
        tree.delete(3);
        assert tree.find(3) == null;

        for (int i = 0; i < 10; i++) {
            System.out.println(String.format("random value: %d", tree.getRandomNode().value));
        }
    }
}
