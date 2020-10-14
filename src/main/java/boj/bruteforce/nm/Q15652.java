package boj.bruteforce.nm;

import java.util.Scanner;

/**
 * N과 M (4)
 * depth 1번째 숫자는 depth 0번째 숫자와 같거나 크다.
 * depth 2번째 숫자는 depth 1번째 숫자와 같거나 크다.
 * n번째 숫자는 n-1번째 숫자와 같거나 크다.
 */
public class Q15652 {
    private static int[] numbers;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int n = scanner.nextInt();
        final int m = scanner.nextInt();

        numbers = new int[n];

        permute(0, n,m);
    }

    private static void permute(final int depth, final int n, final int m) {
        if (depth == m) {
            print(m);
            return;
        }

        for (int i = 0; i < n; i++) {
            int number = i + 1;
            if (depth == 0 || numbers[depth - 1] <= number) {
                numbers[depth] = number;
                permute(depth + 1, n, m);
            }
        }
    }

    private static void print(final int m) {
        for (int i = 0; i < m; i++) {
            System.out.print(numbers[i] + " ");
        }
        System.out.println();
    }
}
