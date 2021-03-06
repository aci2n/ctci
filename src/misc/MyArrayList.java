package misc;

public class MyArrayList<T> {
    private Object[] buffer;
    private final int growthFactor;
    private int size;

    MyArrayList() {
        buffer = new Object[1];
        growthFactor = 2;
        size = 0;
    }

    public static void main(String[] args) {
        MyArrayList<String> list = new MyArrayList<>();

        list.add("hola");
        list.add("como");
        list.add("estas");
        list.add("yo mal");
        list.add("piola");

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    public void add(T element) {
        if (size < buffer.length) {
            buffer[size++] = element;
            return;
        }

        Object[] expanded = new Object[size * growthFactor];
        copy(expanded);
        buffer = expanded;
        add(element);
    }

    private void copy(Object[] dest) {
        for (int i = 0; i < buffer.length; i++) {
            dest[i] = buffer[i];
        }
    }

    public int size() {
        return size;
    }

    @SuppressWarnings("unchecked")
    public T get(int i) throws IndexOutOfBoundsException {
        if (i >= size) {
            throw new IndexOutOfBoundsException();
        }
        return (T) buffer[i];
    }
}
