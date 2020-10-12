package exercises;

public class Q10_8_FindDuplicates {
    private static void printDuplicates(int[] array, int max) {
        byte[] bitVector = new byte[max / 8 + 1];

        for (int value : array) {
            int v = value - 1;
            int index = v / 8;
            int mask = 1 << (v % 8);

            if ((bitVector[index] & mask) == mask) {
                System.out.println(value);
            } else {
                bitVector[index] |= mask;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 5, 8, 3, 2, 1, 9, 1999, 898, 32000, 32000, 1999, 2};
        printDuplicates(array, 32000);
    }
}
