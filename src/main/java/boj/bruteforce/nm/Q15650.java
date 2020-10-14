package boj.bruteforce.nm;

import java.util.Scanner;

/**
 * N과 M (2)
 * 중복 순열을 허용 X
 * 같은 숫자 허용 X
 * (1, 2) (1, 3) (1, 4)
 * (2, 3) (2, 4)
 * (3, 4)
 */
public class Q15650 {
    private static int[] NUMBERS;
    private static int N;
    private static int M;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();
        NUMBERS = new int[M];

        permute(0, 1);
    }

    private static void permute(final int depth, final int start) {
        if (depth == M) {
            print();
            return;
        }

        for (int number = start; number <= N; number++) {
            NUMBERS[depth] = number;
            permute(depth + 1, number + 1);
        }
    }

    private static void print() {
        for (int number : NUMBERS) {
            System.out.print(number + " ");
        }
        System.out.println();
    }
}
