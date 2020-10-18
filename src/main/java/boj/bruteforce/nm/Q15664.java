package boj.bruteforce.nm;

import java.util.Arrays;
import java.util.Scanner;

/**
 * N과 M (10)
 * 입력값에 중복되는 숫자가 들어온다.
 * 중복되는 수열 출력 x
 *
 * depth 1번째 숫자는 depth 0번째 숫자와 같거나 크다.
 * depth 2번째 숫자는 depth 1번째 숫자와 같거나 크다.
 * n번째 숫자는 n-1번째 숫자와 같거나 크다.
 *
 * 4 2
 * 9 7 9 1
 * 
 * 1 7
 * 1 9
 * 7 9
 * 9 9
 *
 */
public class Q15664 {
    private static boolean[] isVisit;
    private static int[] numbers;
    private static int[] result;
    private static int n;
    private static int m;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        isVisit = new boolean[n];
        numbers = new int[n];
        result = new int[m];

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
            if (!isVisit[i] && isDescending(depth, i) && !isUsed[numbers[i]]) {
                result[depth] = numbers[i];
                isUsed[numbers[i]] = true;
                isVisit[i] = true;
                permute(depth + 1);
                isVisit[i] = false;
            }
        }
    }

    private static boolean isDescending(final int depth, final int i) {
        return depth == 0 || result[depth - 1] <= numbers[i];
    }


    private static void print() {
        for (int i = 0; i < m; i++) {
            System.out.print(result[i] + " ");
        }
        System.out.println();
    }
}
