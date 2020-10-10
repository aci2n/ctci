package misc;

import java.util.ArrayList;

public class SieveOfErathostenes {
    private static boolean[] sieveOfErathostenes(int max) {
        // flags[i]: i * 2 + 1
        boolean[] flags = new boolean[(max + 1) / 2];
        double limit = Math.sqrt(max);
        int prime = 3;

        init(flags);

        while (prime <= limit) {
            crossOff(flags, prime);
            prime = nextPrime(flags, prime);
        }

        return flags;
    }

    private static void init(boolean[] flags) {
        for (int i = 1; i < flags.length; i++) {
            flags[i] = true;
        }
    }

    private static int nextPrime(boolean[] flags, int curr) {
        int index = curr / 2 + 1;

        while (index < flags.length && !flags[index]) {
            index++;
        }

        return index * 2 + 1;
    }

    private static void crossOff(boolean[] flags, int prime) {
        int limit = flags.length * 2 - 2;

        for (int i = prime * prime; i <= limit; i += prime) {
            if (i % 2 == 1) flags[i / 2] = false;
        }
    }

    private static ArrayList<Integer> getPrimesUnder(int max) {
        boolean[] flags = sieveOfErathostenes(max);

        ArrayList<Integer> primes = new ArrayList<>();
        primes.add(2);

        for (int i = 0; i < flags.length; i++) {
            if (flags[i]) {
                primes.add(i * 2 + 1);
            }
        }
        return primes;
    }

    public static void main(String[] args) {
        ArrayList<Integer> primes = getPrimesUnder(2_000_000);
        primes.forEach(System.out::println);
    }
}
