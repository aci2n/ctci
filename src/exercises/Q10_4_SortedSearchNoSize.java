package exercises;

import java.util.ArrayList;

public class Q10_4_SortedSearchNoSize {
    private static class Listy {
        ArrayList<Integer> list;

        Listy(int... values) {
            list = new ArrayList<>();

            for (int value : values) {
                list.add(value);
            }
        }

        int elementAt(int index) {
            if (index >= list.size()) return -1;
            return list.get(index);
        }
    }

    private static int sortedSearchNoSize(Listy listy, int x) {
        return sortedSearchNoSize(listy, x, 0, 1000);
    }

    private static int sortedSearchNoSize(Listy listy, int x, int low, int high) {
        if (low > high) {
            if (listy.elementAt(high) == -1) {
                return sortedSearchNoSize(listy, x, low, high + 1000);
            }
            return -1;
        }

        int mid = (low + high) / 2;
        int guess = listy.elementAt(mid);


        if (guess == -1 || guess > x) {
            return sortedSearchNoSize(listy, x, low, mid - 1);
        }

        if (guess < x) {
            return sortedSearchNoSize(listy, x, mid + 1, high);
        }

        return mid;
    }

    public static void main(String[] args) {
        Listy listy = new Listy(1, 3, 5, 7, 9, 9, 11);

        assert sortedSearchNoSize(listy, 1) == 0;
        assert sortedSearchNoSize(listy, 3) == 1;
        assert sortedSearchNoSize(listy, 5) == 2;
        assert sortedSearchNoSize(listy, 7) == 3;
        assert sortedSearchNoSize(listy, 9) == 4;
        assert sortedSearchNoSize(listy, 11) == 6;
    }
}
