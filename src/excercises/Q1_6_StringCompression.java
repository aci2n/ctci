package excercises;

public class Q1_6_StringCompression {

    private static String compressString(String str) {
        if (str == null) {
            throw new IllegalArgumentException();
        }

        StringBuilder builder = new StringBuilder();

        for (int i = 0, occurrences = 0; i < str.length(); i++, occurrences++) {
            char current = str.charAt(i);
            char next = i == str.length() - 1 ? (char) -1 : str.charAt(i + 1);

            if (current != next) {
                builder.append(current).append(occurrences);
                occurrences = 0;
            }
        }

        if (builder.length() < str.length()) {
            return builder.toString();
        }

        return str;
    }

    public static void main(String[] args) {
        String[] tests = {"aaabbbbccd", "abcd", "abaca"};

        for (String test : tests) {
            System.out.println(String.format("%s: %s", test, compressString(test)));
        }
    }
}
