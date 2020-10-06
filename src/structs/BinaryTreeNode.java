package structs;

public class BinaryTreeNode<T> {
    public T value;
    public BinaryTreeNode<T> left;
    public BinaryTreeNode<T> right;
    public BinaryTreeNode<T> parent;

    public BinaryTreeNode(T value) {
        this.value = value;
    }

    public void setLeft(BinaryTreeNode<T> left) {
        this.left = left;
        left.parent = this;
    }

    public void setRight(BinaryTreeNode<T> right) {
        this.right = right;
        right.parent = this;
    }
}
