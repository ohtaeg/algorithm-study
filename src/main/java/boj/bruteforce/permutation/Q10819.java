package boj.bruteforce.permutation;

import java.util.Scanner;

/**
 * 차이를 최대로
 */
public class Q10819 {
    private static int max = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int n = scanner.nextInt();
        int[] sources = new int[n];

        for (int i = 0; i < sources.length; i++) {
            sources[i] = scanner.nextInt();
        }

        permute(sources, 0);
        System.out.println(max);
    }

    private static void permute(final int[] sources, final int depth) {
        final int length = sources.length;
        int result = 0;

        if (length == depth) {
            for (int i = 0; i < length - 1; i++) {
                result += Math.abs(sources[i] - sources[i + 1]);
            }
            max = Math.max(max, result);
            return;
        }

        for (int i = depth; i < length; i++) {
            swap(sources, i, depth);
            permute(sources, depth + 1);
            swap(sources, i, depth);
        }
    }

    private static void swap(final int[] sources, final int i, final int depth) {
        int temp = sources[i];
        sources[i] = sources[depth];
        sources[depth] = temp;
    }
}
