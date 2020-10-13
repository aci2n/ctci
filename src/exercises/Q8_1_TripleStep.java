package exercises;

public class Q8_1_TripleStep {

    private static int countPathsTopDown(int steps) {
        return countPathsTopDown(steps, new int[steps]);
    }

    private static int countPathsTopDown(int steps, int[] memo) {
        if (steps < 0) return 0;
        if (steps == 0) return 1;
        if (memo[steps - 1] != 0) return memo[steps - 1];

        int paths = 0;

        for (int i = 1; i <= 3; i++) {
            paths += countPathsTopDown(steps - i, memo);
        }

        memo[steps - 1] = paths;

        return paths;
    }

    private static int countPathsBottomUp(int steps) {
        int[] memo = new int[steps + 1];

        memo[0] = 1;

        for (int i = 1; i <= steps; i++) {
            int result = 0;
            int limit = Math.min(i, 3);

            for (int j = 1; j <= limit; j++) {
                result += memo[i - j];
            }

            memo[i] = result;
        }

        return memo[steps];
    }

    public static void main(String[] args) {
        assert countPathsTopDown(3) == 4;
        assert countPathsTopDown(4) == 7;
        assert countPathsBottomUp(3) == 4;
        assert countPathsBottomUp(4) == 7;
    }
}
