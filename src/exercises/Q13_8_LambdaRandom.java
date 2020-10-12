package exercises;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Q13_8_LambdaRandom {
    private static List<Integer> getRandomSubset(List<Integer> list) {
        Random random = new Random();
        return list.stream()
                .filter(number -> random.nextBoolean())
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);

        for (int i = 0; i < 100; i++) {
            getRandomSubset(list).forEach(number -> System.out.print(number + " "));
            System.out.println();
        }
    }
}
