package exercises;

import java.util.ArrayList;
import java.util.Comparator;

public class Q10_10_RankFromStream {
    private static class Ranking {
        ArrayList<Integer> values;
        boolean dirty;

        Ranking() {
            values = new ArrayList<>();
        }

        void track(int x) {
            values.add(x);
            dirty = true;
        }

        int search(int x, int low, int high) {
            while (low <= high) {
                int mid = (low + high) / 2;
                int value = values.get(mid);

                if (x > value) {
                    low = mid + 1;
                } else if (x < value) {
                    high = mid - 1;
                } else {
                    int last = search(x, mid + 1, high);
                    return last == -1 ? mid : last;
                }
            }

            return -1;
        }

        int getRankOfNumber(int x) {
            if (dirty) {
                values.sort(Comparator.comparingInt(a -> a));
                dirty = false;
            }

            return search(x, 0, values.size() - 1);
        }
    }

    @SuppressWarnings("AssertWithSideEffects")
    public static void main(String[] args) {
        int[] stream = new int[]{5, 1, 4, 4, 5, 9, 7, 13, 3};
        Ranking ranking = new Ranking();

        for (int x : stream) {
            ranking.track(x);
        }

        assert ranking.getRankOfNumber(1) == 0;
        assert ranking.getRankOfNumber(3) == 1;
        assert ranking.getRankOfNumber(4) == 3;
    }
}
