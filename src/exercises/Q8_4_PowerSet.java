package exercises;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Q8_4_PowerSet {
    private static ArrayList<Set<Integer>> powerSet(Set<Integer> set) {
        ArrayList<Set<Integer>> sets = new ArrayList<>();
        Iterator<Integer> iterator = set.iterator();

        if (!iterator.hasNext()) {
            sets.add(new HashSet<>());
            return sets;
        }

        int value = iterator.next();
        iterator.remove();

        for (Set<Integer> subSet : powerSet(set)) {
            Set<Integer> copy = new HashSet<>(subSet);
            copy.add(value);
            sets.add(copy);
            sets.add(subSet);
        }

        set.add(value);

        return sets;
    }

    public static void main(String[] args) {
        Set<Integer> baseSet = new HashSet<>();
        baseSet.add(1);
        baseSet.add(2);
        baseSet.add(3);
        baseSet.add(4);

        ArrayList<Set<Integer>> sets = powerSet(baseSet);

        for (Set<Integer> set : sets) {
            for (int value : set) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}
