package excercises;

import java.util.Arrays;

class Q1_1_IsUnique {
    // without data structures: O(N log N)
    private static boolean isUnique(String str) {
        if (str == null) {
            throw new IllegalArgumentException("str cannot be null");
        }

        char[] chars = str.toCharArray();
        // O(N log N)
        Arrays.sort(chars);

        // O(N)
        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] == chars[i + 1]) {
                return false;
            }
        }

        // runtime: O(N log N + N) -> O(N log N)

        return true;
    }

    public static void main(String[] args) {
        String[] tests = {"abc", "aba", "abx", "", "aaaaaa", null};

        for (String test : tests) {
            try {
                System.out.println(String.format("%s: %b", test, isUnique(test)));
            } catch (Exception e) {
                System.err.println(String.format("%s: %s", test, e.getMessage()));
            }
        }
    }
}