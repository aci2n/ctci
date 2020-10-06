package exercises;

public class Q3_1_ThreeInOne {
    public static void main(String[] args) {
        int[] sizes = {4, 5, 6};
        int totalSize = 0;

        for (int size : sizes) {
            totalSize += size;
        }

        int[] buffer = new int[totalSize];

        for (int i = 0, start = 0; i < sizes.length; i++) {
            int end = start + sizes[i];
            MiniStack stack = new MiniStack(buffer, start, end);
            start = end;

            assert stack.isEmpty();

            for (int j = 0; j < sizes[i]; j++) {
                stack.push(j);
            }

            assert stack.isFull();

            System.out.println(String.format("--stack %d, size %s--", i, sizes[i]));

            for (int j = 0; j < sizes[i]; j++) {
                System.out.println(stack.pop());
            }

            assert stack.isEmpty();
        }
    }

    private static class MiniStack {
        int[] buffer;
        // {start: 0, end: 3} means we have slots [0, 1, 2]
        int start;
        int end;
        int index;

        MiniStack(int[] buffer, int start, int end) {
            this.buffer = buffer;
            this.start = start;
            this.end = end;
            index = start;
        }

        void push(int value) {
            checkOverflow();
            buffer[index++] = value;
        }

        int pop() {
            checkEmpty();
            return buffer[--index];
        }

        int peek() {
            checkEmpty();
            return buffer[index - 1];
        }

        boolean isEmpty() {
            return index == start;
        }

        boolean isFull() {
            return index == end;
        }

        void checkOverflow() {
            if (isFull()) {
                throw new RuntimeException("stack full");
            }
        }

        void checkEmpty() {
            if (isEmpty()) {
                throw new RuntimeException("stack empty");
            }
        }
    }
}
