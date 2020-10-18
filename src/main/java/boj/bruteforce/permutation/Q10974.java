package boj.bruteforce.permutation;

import java.util.Scanner;

/**
 * 모든 순열
 */
public class Q10974 {
    private static boolean[] isVisit;
    private static int[] numbers;
    private static int n;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        numbers = new int[n];
        isVisit = new boolean[n];

        permute(0);
    }

    private static void permute(final int depth) {
        if (depth == n) {
            print();
            return;
        }

        for (int i = 0; i < n; i++) { // n = 3, 0 1 2
            if (!isVisit[i]) {
                isVisit[i] = true;
                numbers[depth] = i + 1;
                permute(depth + 1);
                isVisit[i] = false;
            }
        }
    }

    private static void print() {
        for (int i = 0; i < n; i++) {
            System.out.print(numbers[i] + " ");
        }
        System.out.println();
    }
}
