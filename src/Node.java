public class Node<T> {
    public T value;
    public Node<T> next;

    Node(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.format("[value: %s]", value);
    }
}
