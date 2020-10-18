package boj.bruteforce.nm;

import java.util.Arrays;
import java.util.Scanner;

public class Q15666 {
    private static int[] numbers;
    private static int[] permutation;
    private static int n;
    private static int m;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        numbers = new int[n];
        permutation = new int[m];

        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }

        Arrays.sort(numbers);
        permute(0);
    }

    private static void permute(final int depth) {
        if (depth == m) {
            print();
            return;
        }

        final boolean[] isUsed = new boolean[10001];

        for (int i = 0; i < n; i++) {
            if (isDescending(depth, i) && !isUsed[numbers[i]]) {
                isUsed[numbers[i]] = true;
                permutation[depth] = numbers[i];
                permute(depth + 1);
            }
        }
    }

    private static boolean isDescending(final int depth, final int i) {
        return depth == 0 || permutation[depth - 1] <= numbers[i];
    }

    private static void print() {
        for (int i = 0; i < m; i++) {
            System.out.print(permutation[i] + " ");
        }
        System.out.println();
    }
}
