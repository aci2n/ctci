package exercises;

import java.util.Stack;

public class Q8_6_TowersOfHanoi {
    private static void towersOfHanoi(Stack<Integer> source,
                                      Stack<Integer> middle,
                                      Stack<Integer> target,
                                      int count) {
        if (count == 0) return;
        towersOfHanoi(source, target, middle, count - 1);
        target.push(source.pop());
        towersOfHanoi(middle, source, target, count - 1);
    }

    public static void main(String[] args) {
        Stack<Integer> a = new Stack<>();
        Stack<Integer> b = new Stack<>();
        Stack<Integer> c = new Stack<>();
        int size = 10;

        for (int i = 0; i < size; i++) {
            a.push(i);
        }

        towersOfHanoi(a, b, c, a.size());

        assert a.size() == 0;
        assert b.size() == 0;
        assert c.size() == size;

        for (int i = size - 1; i >= 0; i--) {
            assert c.pop() == i;
        }
    }
}
