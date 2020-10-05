package excercises;

import java.util.Arrays;
import java.util.Stack;

public class Q1_3_Urlify {

    // O(N)
    private static String urlify(char[] buffer, int length) {
        Stack<Integer> indexes = new Stack<>();

        // O(N)
        for (int i = 0; i < length; i++) {
            if (buffer[i] == ' ') {
                indexes.push(i);
            }
        }

        int limit = length;

        // O(N)
        while (!indexes.empty()) {
            int offset = indexes.size() * 2;
            int index = indexes.pop();

            for (int i = limit - 1; i > index; i--) {
                buffer[i + offset] = buffer[i];
            }

            buffer[index + offset - 2] = '%';
            buffer[index + offset - 1] = '2';
            buffer[index + offset] = '0';

            limit = index;
        }

        return new String(buffer);
    }

    public static void main(String[] args) {
        String[] tests = {"     hola como estas bro todo en orden    ????", "", "todobn"};

        for (String test : tests) {
            char[] chars = test.toCharArray();
            char[] buffer = Arrays.copyOf(chars, chars.length * 3);
            String urlified = urlify(buffer, chars.length);
            System.out.println(String.format("%s: %s", test, urlified));
        }
    }
}