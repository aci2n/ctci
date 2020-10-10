package misc;

public class BinarySearchTree {
    public BinaryTreeNode<Integer> root;

    @SafeVarargs
    public BinarySearchTree(int... values) {
        for(int value : values) {
            insert(value);
        }
    }

    public void insert(int value) {
        var node = new BinaryTreeNode<>(value);

        if (root == null) {
            root = node;
        } else {
            insertNode(root, node);
        }
    }

    private void insertNode(BinaryTreeNode<Integer> head,
                            BinaryTreeNode<Integer> node) {
        if (node.value > head.value) {
            if (head.right == null) {
                head.right = node;
            } else {
                insertNode(head.right, node);
            }
        } else {
            if (head.left == null) {
                head.left = node;
            } else {
                insertNode(head.left, node);
            }
        }
    }
}
