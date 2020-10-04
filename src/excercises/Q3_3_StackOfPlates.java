import java.util.EmptyStackException;

public class Q3_3_StackOfPlates {
    private static class SetOfStacks<T> {
        MyStack<MyStack<T>> stackOfStacks = new MyStack<>();
        int maxStackSize;

        SetOfStacks(int maxStackSize) {
            this.maxStackSize = maxStackSize;
        }

        public void push(T value) {
            if (isEmpty() || stackOfStacks.peek().size() == maxStackSize) {
                stackOfStacks.push(new MyStack<>());
            }
            stackOfStacks.peek().push(value);
        }

        public T pop() {
            checkNotEmpty();

            MyStack<T> currentStack = stackOfStacks.peek();
            T value = currentStack.pop();

            if (currentStack.size() == 0) {
                stackOfStacks.pop();
            }

            return value;
        }

        private void checkNotEmpty() {
            if (isEmpty()) {
                throw new EmptyStackException();
            }
        }

        private boolean isEmpty() {
            return stackOfStacks.isEmpty();
        }

        public T peek() {
            checkNotEmpty();
            return stackOfStacks.peek().peek();
        }

        public int size() {
            if (isEmpty()) {
                return 0;
            }
            return (stackOfStacks.size() - 1) * maxStackSize + stackOfStacks.peek().size();
        }

        public T popAt(int index) {
            return recursivePop(index, 0, null);
        }

        private T recursivePop(int target, int depth, T fill) {
            checkNotEmpty();

            MyStack<T> current = stackOfStacks.pop();
            T popped;
                
            if (depth == target) {
                popped = current.pop();
            } else {
                popped = recursivePop(target, depth + 1, removeBottom(current));
            }

            if (fill != null) {
                current.push(fill);
            }

            if (!current.isEmpty()) {
                stackOfStacks.push(current);
            }

            return popped;
        }
        
        private T removeBottom(MyStack<T> stack) {
            MyStack<T> inverted = new MyStack<>();

            while (!stack.isEmpty()) {
                inverted.push(stack.pop());
            }

            T bottom = inverted.pop();

            while (!inverted.isEmpty()) {
                stack.push(inverted.pop());
            }

            return bottom;
        }
    }


    public static void main(String[] args) {
        SetOfStacks<Integer> stacks = new SetOfStacks<>(2);
        int testValues = 10;
        
        for (int i = 0; i < testValues; i++) {
            assert stacks.size() == i;
            stacks.push(i);
            assert stacks.size() == i + 1;
        }

        // pop the third stack from last which has values [2, 3]
        assert stacks.popAt(3) == 3;
        assert stacks.size() == testValues - 1;

        // pop the third again, should have the previous bottom value of the second (4)
        assert stacks.popAt(3) == 4;
        assert stacks.size() == testValues - 2;

        for (int i = testValues - 3; i >= 0 ; i--) {
            int popped = stacks.pop();
            assert popped != 3 && popped != 4;
            assert stacks.size() == i;
        }

        assert stacks.isEmpty();
    }
}
