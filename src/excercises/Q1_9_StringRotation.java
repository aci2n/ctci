package excercises;

public class Q1_9_StringRotation {
    private static boolean isSubstring(String haystack, String needle) {
        return haystack.contains(needle);
    }

    // is s2 a rotation of s1?
    private static boolean isRotation(String s1, String s2) {
        return s1.length() == s2.length() && isSubstring(s1 + s1, s2);
    }

    public static void main(String[] args) {
        String[][] tests = { { "waterbottle", "erbottlewat" }, { "tabacco", "ccotaba" }, { "football", "ballfoo" } };

        for (String[] test : tests) {
            String s1 = test[0];
            String s2 = test[1];
            System.out.println(String.format("%s, %s: %b", s1, s2, isRotation(s1, s2)));
        }
    }
}
