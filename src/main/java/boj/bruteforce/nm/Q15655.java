package boj.bruteforce.nm;

import java.util.Arrays;
import java.util.Scanner;

/**
 * N과 M (6)
 * 숫자를 입력받고 입력받은 수중에서 자기 자신은 뽑지않으며 오름차순 순열 구하는 문제
 */
public class Q15655 {
    private static boolean[] isVisit;
    private static int[] result;
    private static int n;
    private static int m;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        isVisit = new boolean[n];
        result = new int[m];

        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }

        Arrays.sort(numbers);
        permute(0, 0, numbers);
    }

    private static void permute(final int depth, final int start, final int[] numbers) {
        if (depth == m) {
            print(m);
            return;
        }

        for (int i = start; i < n; i++) {
            if (!isVisit[i]) {
                result[depth] = numbers[i];
                isVisit[i] = true;
                permute(depth + 1, i + 1, numbers);
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
