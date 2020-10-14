package boj.bruteforce.nm;

import java.util.Arrays;
import java.util.Scanner;

/**
 * N과 M (5)
 * - 입력받은 값을 정렬후 모든 순열을 출력하는 문제
 */
public class Q15654 {
    private static boolean[] isVisit;
    private static int[] result;
    private static int n;
    private static int m;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();

        final int[] numbers = new int[n];
        isVisit = new boolean[n];
        result = new int[m];

        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }

        Arrays.sort(numbers);
        permute(0, numbers);
    }

    private static void permute(final int depth, final int[] numbers) {
        if (depth == m) {
            print(m);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!isVisit[i]) {
                result[depth] = numbers[i];
                isVisit[i] = true;
                permute(depth + 1, numbers);
                isVisit[i] = false;
            }
        }
    }

    private static void print(final int m) {
        for (int i = 0; i < m; i++) {
            System.out.print(result[i] + " ");
        }
        System.out.println();
    }
}
