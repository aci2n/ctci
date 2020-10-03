public class Q1_5_OneAway {
    private static class ShorterLonger {
        String shorter;
        String longer;
        int diff;
    }

    private static ShorterLonger getShorterLonger(String a, String b) {
        ShorterLonger sl = new ShorterLonger();
        int diff = a.length() - b.length();

        if (diff >= 0) {
            sl.longer = a;
            sl.shorter = b;
            sl.diff = diff;
        } else {
            sl.longer = b;
            sl.shorter = a;
            sl.diff = -diff;
        }

        return sl;
    }

    private static boolean isOneAway(String a, String b) {
        ShorterLonger sl = getShorterLonger(a, b);

        if (sl.diff > 1) {
            return false;
        }

        int i = 0;
        int j = 0;
        boolean edited = false;

        // O(min(a, b))
        while (i < sl.shorter.length()) {
            if (sl.shorter.charAt(i) == sl.longer.charAt(j)) {
                i++;
                j++;
                continue;
            }

            if (edited) {
                return false;
            }

            if (sl.diff == 0) {
                i++;
            }

            j++;
            edited = true;
        }

        return true;
    }

    public static void main(String[] args) {
        String[][] tests = { { "pale", "ple" }, { "pales", "pale" }, { "pale", "bale" }, { "pale", "bake" }, {"ple", "pale"}, {"macc", "macacs"} };

        for (String[] test : tests) {
            String a = test[0];
            String b = test[1];
            boolean oneAway = isOneAway(a, b);
            System.out.println(String.format("%s, %s: %b", a, b, oneAway));
        }
    }
}
