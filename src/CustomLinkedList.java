import java.util.function.Consumer;

public class CustomLinkedList<T> {
    public class Node {
        T value;
        Node next;

        Node(T value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return String.format("[value: %s]", value);
        }
    }

    @SafeVarargs
    CustomLinkedList(T... values) {
        for (T value : values) {
            add(value);
        }
    }

    // making everything public to access inside excercises
    public Node head;

    public void add(T value) {
        head = addNode(value);
    }

    private Node addNode(T value) {
        Node newNode = new Node(value);

        for (Node node = head; node != null; node = node.next) {
            if (node.next == null) {
                node.next = newNode;
                return head;
            }
        }

        return newNode;
    }

    public void delete(T value) {
        head = deleteNode(value);
    }

    private Node deleteNode(T value) {
        Node prev = head;

        for (Node node = head; node != null; node = node.next) {
            if (!node.value.equals(value)) {
                prev = node;
                continue;
            }

            if (node == head) {
                return head.next;
            }

            prev.next = node.next;
            return head;
        }

        return head;
    }

    public T get(int index) {
        for (Node node = head; node != null; node = node.next) {
            if (index-- == 0) {
                return node.value;
            }
        }

        return null;
    }

    public Node getNode(int index) {
        for (Node node = head; node != null; node = node.next) {
            if (index-- == 0) {
                return node;
            }
        }

        return null;
    }

    public void forEach(Consumer<T> consumer) {
        for (Node node = head; node != null; node = node.next) {
            consumer.accept(node.value);
        }
    }

    public void printAll() {
        forEach(value -> System.out.println(value));
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void putNode(Node inserted, int index) {
        head = insertNode(inserted, index);
    }

    private Node insertNode(Node inserted, int index) {
        if (index == 0) {
            inserted.next = head;
            return inserted;
        }

        for (Node node = head; node != null; node = node.next) {
            if (--index == 0) {
                inserted.next = node.next;
                node.next = inserted;
                return head;
            }
        }

        return head;
    }

    public Node tailNode() {
        Node tail = head;

        while (tail.next != null) {
            tail = tail.next;
        }

        return tail;
    }

    public static void main(String[] args) {
        CustomLinkedList<String> list = new CustomLinkedList<>();

        list.add("hola");
        list.add("como");
        list.add("va");
        list.add("todo");
        list.printAll();

        System.out.println("--delete 'va'--");
        list.delete("va");
        list.printAll();

        System.out.println("--delete 'hola'--");
        list.delete("hola");
        list.printAll();
    }
}
