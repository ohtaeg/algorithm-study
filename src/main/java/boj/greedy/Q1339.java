package boj.greedy;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 단어 수학
 */
public class Q1339 {
    private static final char ALPHABET_A = 'A';

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int[] sums = new int[26];
        final int n = Integer.valueOf(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            final char[] alphabets = scanner.nextLine()
                                            .toCharArray();
            calculatePlaceNumber(alphabets, sums);
        }

        System.out.println(sumAlphabets(sums));
    }

    private static void calculatePlaceNumber(final char[] alphabets, final int[] sums) {
        int size = alphabets.length;

        for (char alphabet : alphabets) {
            int placeNumber = (int) Math.pow(10, --size);
            sums[alphabet - ALPHABET_A] += placeNumber;
        }
    }

    private static int sumAlphabets(final int[] sums) {
        int result = 0;
        int maxValue = 9;

        sort(sums);
        for (int i = sums.length - 1; i >= 0; i--) {
            if (sums[i] == 0) {
                break;
            }
            result += sums[i] * maxValue--;
        }

        return result;
    }

    private static void sort(final int[] sums) {
        Arrays.sort(sums);
    }
}
