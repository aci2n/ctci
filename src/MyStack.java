import java.util.EmptyStackException;

public class MyStack<T> {
    public static class Node<T> {
        T value;
        Node<T> next;

        Node(T value) {
            this.value = value;
        }
    }

    public Node<T> top;

    @SafeVarargs
    MyStack(T... values) {
        for (T value : values) {
            push(value);
        }
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void push(T value) {
        Node<T> node = new Node<>(value);
        node.next = top;
        top = node;
    }

    public T pop() {
        checkNotEmpty();
        T value = top.value;
        top = top.next;
        return value;
    }

    public T peek() {
        checkNotEmpty();
        return top.value;
    }

    private void checkNotEmpty() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
    }

    public static void main(String[] args) {
        MyStack<Integer> stack = new MyStack<>(1, 2, 3, 4, 5);

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
