public class MyQueue<T> {
    public Node<T> head;
    public Node<T> tail;

    @SafeVarargs
    MyQueue(T... values) {
        for (T value : values) {
            add(value);
        }
    }

    public void add(T value) {
        Node<T> node = new Node<>(value);

        if (head == null) {
            head = tail = node;
            return;
        }

        tail.next = node;
        tail = node;
    }

    public T remove() {
        checkNotEmpty();
        T value = head.value;
        head = head.next;

        if (head == null) {
            // do not keep pointer to off-queue element to allow GC
            tail = null;
        }

        return value;
    }

    public T peek() {
        checkNotEmpty();
        return head.value;
    }

    public boolean isEmpty() {
        return head == null;
    }

    private void checkNotEmpty() {
        if (isEmpty()) {
            throw new RuntimeException("empty queue");
        }
    }

    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<>(1, 2, 3, 4, 5);

        while (!queue.isEmpty()) {
            System.out.println(queue.remove());
        }
    }
}
