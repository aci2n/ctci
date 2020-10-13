package exercises;

public class Q10_5_SparseSearch {
    private static int sparseSearch(String[] strings, String x) {
        int low = 0;
        int high = strings.length - 1;

        while (low <= high) {
            int pos = (low + high) / 2;

            while (pos <= high && strings[pos].isEmpty()) {
                pos++;
            }

            if (pos > high) {
                pos = (low + high) / 2 - 1;

                while (pos >= low && strings[pos].isEmpty()) {
                    pos--;
                }

                if (pos < low) {
                    return -1;
                }
            }

            int diff = strings[pos].compareTo(x);

            if (diff < 0) {
                low = pos + 1;
            } else if (diff > 0) {
                high = pos - 1;
            } else {
                return pos;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        String[] strings = new String[]{"at", "", "", "",
                "ball", "", "", "car", "",
                "", "", "dad", "", ""};

        assert sparseSearch(strings, "at") == 0;
        assert sparseSearch(strings, "ball") == 4;
        assert sparseSearch(strings, "car") == 7;
        assert sparseSearch(strings, "dad") == 11;
        assert sparseSearch(strings, "none") == -1;
    }
}
