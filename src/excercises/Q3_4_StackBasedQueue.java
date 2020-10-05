package excercises;

import structs.MyStack;

public class Q3_4_StackBasedQueue {
    public static void main(String[] args) {
        StackBasedQueue<Integer> queue = new StackBasedQueue<>(0, 1, 2, 3, 4);

        while (!queue.isEmpty()) {
            System.out.println(queue.remove());
        }
    }

    private static class StackBasedQueue<T> {
        private final MyStack<T> inverter = new MyStack<>();
        private final MyStack<T> stack = new MyStack<>();

        @SafeVarargs
        StackBasedQueue(T... values) {
            for (T value : values) {
                add(value);
            }
        }

        public void add(T value) {
            stack.push(value);
        }

        public T remove() {
            return getBottom(true);
        }

        public T peek() {
            return getBottom(false);
        }

        private T getBottom(boolean remove) {
            checkNotEmpty();

            if (inverter.isEmpty()) {
                while (!stack.isEmpty()) {
                    inverter.push(stack.pop());
                }
            }

            return remove ? inverter.pop() : inverter.peek();
        }

        public boolean isEmpty() {
            return stack.isEmpty() && inverter.isEmpty();
        }

        public int size() {
            return stack.size() + inverter.size();
        }

        private void checkNotEmpty() {
            if (isEmpty()) {
                throw new RuntimeException("stack empty");
            }
        }
    }
}
