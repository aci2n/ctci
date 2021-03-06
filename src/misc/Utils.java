package misc;

public final class Utils {
    public static void printMatrix(int[][] matrix) {
        assert matrix != null : "matrix cannot be null";

        int n = matrix.length;
        assert n > 0 : "matrix must have at least 1 row";

        int m = matrix[0].length;
        assert m > 0 : "matrix must have at least 1 column";

        for (int i = 0; i < n; i++) {
            assert matrix[i].length == m : "all matrix rows must be the same size";

            for (int j = 0; j < m; j++) {
                System.out.print(String.format("%02d ", matrix[i][j]));
            }

            System.out.println();
        }
    }

    public static <T> void printStack(MyStack<T> stack) {
        MyStack<T> temp = new MyStack<>();

        while (!stack.isEmpty()) {
            T value = stack.pop();
            System.out.println(value);
            temp.push(value);
        }

        while (!temp.isEmpty()) {
            stack.push(temp.pop());
        }
    }

    public static <T> void printTree(BinaryTreeNode<T> root) {
        printTree(root, 0, "");
    }

    private static <T> void printTree(BinaryTreeNode<T> root, int depth,
                                      String prefix) {
        if (root == null) {
            return;
        }

        String branch = "";

        if (depth > 0) {
            branch = "  ".repeat(depth - 1) + prefix + " → ";
        }

        System.out.println(String.format("%s%s", branch, root.value));
        printTree(root.left, depth + 1, "L");
        printTree(root.right, depth + 1, "R");
    }

    public static boolean arraysEqual(int[] a, int[] b) {
        if (a.length != b.length) return false;
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }

    public static void printArray(int[] array) {
        if (array == null) {
            System.out.println("null");
            return;
        }

        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
