package excercises;

import java.util.HashMap;
import java.util.Map;

public class Q1_2_CheckPermutation {

    // O(a + b)
    private static boolean checkPermutation(String a, String b) {
        if (a == null || b == null) {
            throw new IllegalArgumentException();
        }

        if (a.length() != b.length()) {
            return false;
        }

        Map<Character, Integer> map = new HashMap<>();

        // O(a)
        for (int i = 0; i < a.length(); i++) {
            char c = a.charAt(i);
            int count = map.getOrDefault(c, 0);
            map.put(c, count + 1);
        }

        // O(b)
        for (int i = 0; i < b.length(); i++) {
            char c = b.charAt(i);
            int count = map.getOrDefault(c, 0);

            if (count == 0) {
                return false;
            }

            map.put(c, count - 1);
        }

        return true;
    }

    public static void main(String[] args) {
        String[][] tests = {{"aba", "aab"}, {"abcd", "abce"}, {"andasdasda", "dna"}};

        for (String[] test : tests) {
            String a = test[0];
            String b = test[1];
            System.out.println(String.format("%s, %s: %b", a, b, checkPermutation(a, b)));
        }
    }
}
