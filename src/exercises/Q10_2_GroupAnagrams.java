package exercises;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Stream;

public class Q10_2_GroupAnagrams {
    private static String sortString(String s) {
        char[] chars = s.toCharArray();
        mergeSort(chars, new char[chars.length], 0, chars.length - 1);
        return new String(chars);
    }

    private static void mergeSort(char[] string, char[] helper, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(string, helper, low, mid);
            mergeSort(string, helper, mid + 1, high);
            merge(string, helper, low, mid, high);
        }
    }

    private static void merge(char[] string, char[] helper, int low, int mid, int high) {
        for (int i = low; i <= high; i++) {
            helper[i] = string[i];
        }

        int left = low;
        int right = mid + 1;
        int current = low;

        while (left <= mid && right <= high) {
            if (helper[left] <= helper[right]) {
                string[current++] = helper[left++];
            } else {
                string[current++] = helper[right++];
            }
        }

        while (left <= mid) {
            string[current++] = helper[left++];
        }
    }

    private static void groupAnagrams(String[] strings) {
        HashMap<String, ArrayList<String>> anagrams = new HashMap<>();

        for (String s : strings) {
            anagrams.computeIfAbsent(sortString(s), k -> new ArrayList<>()).add(s);
        }

        int i = 0;

        for (ArrayList<String> group : anagrams.values()) {
            for (String s : group) {
                strings[i++] = s;
            }
        }
    }

    public static void main(String[] args) {
        String[] strings = new String[]{"ana", "baba", "dad", "naa", "add", "oto", "too"};
        Stream.of(strings).forEach(System.out::println);

        System.out.println("--group anagrams--");
        groupAnagrams(strings);
        Stream.of(strings).forEach(System.out::println);
    }
}
