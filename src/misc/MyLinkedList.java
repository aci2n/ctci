package misc;

import java.util.function.Consumer;

public class MyLinkedList<T> {
    // making everything public to access inside exercises
    public Node<T> head;

    @SafeVarargs
    public MyLinkedList(T... values) {
        for (T value : values) {
            add(value);
        }
    }

    public static void main(String[] args) {
        MyLinkedList<String> list = new MyLinkedList<>();

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

    public void add(T value) {
        head = addNode(value);
    }

    private Node<T> addNode(T value) {
        Node<T> newNode = new Node<>(value);

        for (Node<T> node = head; node != null; node = node.next) {
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

    private Node<T> deleteNode(T value) {
        Node<T> prev = head;

        for (Node<T> node = head; node != null; node = node.next) {
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
        for (Node<T> node = head; node != null; node = node.next) {
            if (index-- == 0) {
                return node.value;
            }
        }

        return null;
    }

    public Node<T> getNode(int index) {
        for (Node<T> node = head; node != null; node = node.next) {
            if (index-- == 0) {
                return node;
            }
        }

        return null;
    }

    public void forEach(Consumer<T> consumer) {
        for (Node<T> node = head; node != null; node = node.next) {
            consumer.accept(node.value);
        }
    }

    public void printAll() {
        forEach(value -> System.out.println(value));
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void insert(T value, int index) {
        putNode(new Node<T>(value), index);
    }

    public void putNode(Node<T> inserted, int index) {
        head = insertNode(inserted, index);
    }

    private Node<T> insertNode(Node<T> inserted, int index) {
        if (index == 0) {
            inserted.next = head;
            return inserted;
        }

        for (Node<T> node = head; node != null; node = node.next) {
            if (--index == 0) {
                inserted.next = node.next;
                node.next = inserted;
                return head;
            }
        }

        return head;
    }

    public Node<T> tailNode() {
        Node<T> tail = head;

        while (tail.next != null) {
            tail = tail.next;
        }

        return tail;
    }
}
