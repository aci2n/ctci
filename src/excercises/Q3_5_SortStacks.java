public class Q3_5_SortStacks {
    private static void sortStack(MyStack<Integer> stack) {
        MyStack<Integer> aux = new MyStack<>();
        int min = Integer.MAX_VALUE;
        int occurrences = 0;

        while (!stack.isEmpty()) {
            while (!stack.isEmpty()) {
                int value = stack.pop();

                if (value < min) {
                    min = value;
                    occurrences = 1;
                } else if (value == min) {
                    occurrences++;
                }

                aux.push(value);
            }

            while (!aux.isEmpty()) {
                int value = aux.pop();

                if (value > min) {
                    stack.push(value);
                } else if (value < min) {
                    aux.push(value);
                    break;
                }
            }

            while (occurrences-- > 0) {
                aux.push(min);
            }

            min = Integer.MAX_VALUE;
        }

        while (!aux.isEmpty()) {
            stack.push(aux.pop());
        }
    }

    public static void main(String[] args) {
        MyStack<Integer> stack = new MyStack<>(1, 5, 7, 2, 1, 0);

        System.out.println("--before sort--");
        Utils.printStack(stack);

        System.out.println("--after sort--");
        sortStack(stack);
        Utils.printStack(stack);
    }
}
