package boj.bruteforce.nm;

import java.util.Arrays;
import java.util.Scanner;

/**
 * N과 M (8)
 *
 */
public class Q15657 {
    private static int[] numbers;
    private static int[] result;
    private static int n;
    private static int m;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        numbers = new int[n];
        result = new int[m];

        for (int i = 0 ; i < n; i++) {
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

        for (int i = 0; i < n; i++) {
            if (depth == 0 || result[depth - 1] <= numbers[i]) {
                result[depth] = numbers[i];
                permute(depth + 1);
            }
        }
    }

    private static void print() {
        for (int i = 0; i < m; i++) {
            System.out.print(result[i] + " ");
        }
        System.out.println();
    }
}
