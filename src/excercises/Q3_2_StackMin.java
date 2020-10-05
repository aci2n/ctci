package excercises;

import structs.MyStack;
import structs.Node;

import java.util.EmptyStackException;

public class Q3_2_StackMin {
    private final MyStack<Integer> stack;
    private final MyStack<Node<Integer>> minStack;

    @SafeVarargs
    Q3_2_StackMin(int... values) {
        stack = new MyStack<>();
        minStack = new MyStack<>();

        for (int value : values) {
            push(value);
        }
    }

    public static void main(String[] args) {
        Q3_2_StackMin stack = new Q3_2_StackMin(1, 2, 3, 4, 5);

        while (!stack.isEmpty()) {
            System.out.println(String.format("min: %d, top: %s", stack.min(), stack.pop()));
        }
    }

    public void push(int value) {
        stack.push(value);

        if (minStack.isEmpty() || value < minStack.peek().value) {
            minStack.push(stack.top);
        }
    }

    public int pop() {
        checkEmpty();

        var top = stack.top;
        int value = stack.pop();

        if (top == minStack.peek()) {
            minStack.pop();
        }

        return value;
    }

    public int min() {
        checkEmpty();
        return minStack.peek().value;
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public int peek() {
        checkEmpty();
        return stack.peek();
    }

    private void checkEmpty() {
        if (stack.isEmpty()) {
            throw new EmptyStackException();
        }
    }
}
