package excercises;

import java.util.HashMap;
import java.util.Map;

public class Q1_4_PalindromePermutation {
    // O(N)
    private static boolean isPalindromePermutation(String str) {
        int nonSpaces = 0;
        Map<Character, Integer> map = new HashMap<>();

        // O(N)
        for (int i = 0; i < str.length(); i++) {
            char c = Character.toLowerCase(str.charAt(i));

            if (c != ' ') {
                int count = map.getOrDefault(c, 0);
                map.put(c, count + 1);
                nonSpaces++;
            }
        }

        // allow 1 uneven character when the non-spaces are uneven, 0 if they're even
        // e.g.: 'tacocat' has an uneven 'o' and that's ok, but 'aooa' cannot have unevens
        int allowedUnevens = nonSpaces % 2;

        // O(N)
        for (int count : map.values()) {
            if (count % 2 == 1) {
                if (allowedUnevens == 0) {
                    return false;
                }
                allowedUnevens--;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String[] tests = { "Tact Coa", "Elle elle", "menem", "o cacao", "oi", "a", "iiixi iixiiooooo"};

        for (String test : tests) {
            System.out.println(String.format("%s: %b", test, isPalindromePermutation(test)));
        }
    }
}
