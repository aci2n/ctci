public class MinHeap {
    BinaryTreeNode<Integer> root;

    public MinHeap(int... values) {
        for (int value : values) {
            insert(value);
        }
    }

    public void insert(int value) {
        BinaryTreeNode<Integer> node = new BinaryTreeNode<>(value);

        if (root == null) {
            root = node;
            return;
        }

        insertNode(root, node, getMinDepth(root, 0), 0);
    }

    // O(N)
    private boolean insertNode(BinaryTreeNode<Integer> root, BinaryTreeNode<Integer> node, int limit, int depth) {
        if (depth == limit) {
            if (root.left == null) {
                root.left = node;
                maybeSwapValues(root, node);
                return true;
            }

            if (root.right == null) {
                root.right = node;
                maybeSwapValues(root, node);
                return true;
            }

            return false;
        }

        if (insertNode(root.left, node, limit, depth + 1)) {
            maybeSwapValues(root, root.left);
            return true;
        }

        if (insertNode(root.right, node, limit, depth + 1)) {
            maybeSwapValues(root, root.right);
            return true;
        }

        return false;
    }

    private void maybeSwapValues(BinaryTreeNode<Integer> parent, BinaryTreeNode<Integer> child) {
        if (parent.value > child.value) {
            int temp = parent.value;
            parent.value = child.value;
            child.value = temp;
        }
    }

    // O(log N)
    private int getMinDepth(BinaryTreeNode<Integer> root, int depth) {
        return root.right == null ? depth : getMinDepth(root.right, depth + 1);
    }

    private int getMaxDepth(BinaryTreeNode<Integer> root, int depth) {
        return root.left == null ? depth : getMaxDepth(root.left, depth + 1);
    }

    public int min() {
        if (root == null) {
            throw new RuntimeException("empty heap");
        }
        return root.value;
    }

    private BinaryTreeNode<Integer> removeLastNode(BinaryTreeNode<Integer> root, int limit, int depth) {
        if (depth == limit - 1) {
            if (root.right != null) {
                var removed = root.right;
                root.right = null;
                return removed;
            }

            if (root.left != null) {
                var removed = root.left;
                root.left = null;
                return removed;
            }

            return null;
        }

        var right = removeLastNode(root.right, limit, depth + 1);

        if (right != null) {
            return right;
        }

        var left = removeLastNode(root.left, limit, depth + 1);

        if (left != null) {
            return left;
        }

        return null;
    }

    public int extractMin() {
        if (root == null) {
            throw new RuntimeException();
        }

        int min = root.value;
        int maxDepth = getMaxDepth(root, 0);

        if (maxDepth > 0) {
            var lastNode = removeLastNode(root, maxDepth, 0);
            root.value = lastNode.value;
            relocateMin(root);
        } else {
            root = null;
        }

        return min;
    }

    private void relocateMin(BinaryTreeNode<Integer> root) {
        BinaryTreeNode<Integer> minChild = getMinBetween(root.left, root.right);

        if (minChild != null && root.value > minChild.value) {
            int temp = root.value;
            root.value = minChild.value;
            minChild.value = temp;
            relocateMin(minChild);
        }
    }

    private BinaryTreeNode<Integer> getMinBetween(BinaryTreeNode<Integer> a, BinaryTreeNode<Integer> b) {
        if (a == null)
            return b;
        if (b == null)
            return a;
        if (a.value < b.value)
            return a;
        return b;
    }

    public static void main(String[] args) {
        MinHeap heap = new MinHeap(4, 50, 7, 2, 90, 87, 55, 1);

        System.out.println("--initial--");
        Utils.printTree(heap.root);

        System.out.println("--extract min 1st time--");
        assert heap.extractMin() == 1;
        Utils.printTree(heap.root);

        System.out.println("--extract min 2nd time--");
        assert heap.extractMin() == 2;
        Utils.printTree(heap.root);

        System.out.println("--insert non min--");
        heap.insert(5);
        Utils.printTree(heap.root);

        assert heap.extractMin() == 4;
        assert heap.extractMin() == 5;
        assert heap.extractMin() == 7;
        assert heap.extractMin() == 50;
        assert heap.extractMin() == 55;
        assert heap.extractMin() == 87;
        assert heap.extractMin() == 90;
        assert heap.root == null;
    }
}
