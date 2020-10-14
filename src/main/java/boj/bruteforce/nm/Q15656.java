package boj.bruteforce.nm;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

/**
 * N과 M (7)
 * 증복허용하는 모든 순열을 만드는 문제
 * 시간 초과 조심해야함.
 */
public class Q15656 {
    private static final BufferedWriter BUFFERED_WRITER = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder RESULT = new StringBuilder();

    private static int[] numbers;
    private static int[] permutation;
    private static int n;
    private static int m;

    public static void main(String[] args) throws IOException {
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
        BUFFERED_WRITER.write(RESULT.toString());
        BUFFERED_WRITER.flush();
    }

    private static void permute(final int depth) {
        if (depth == m) {
            print();
            return;
        }

        for (int i = 0; i < n; i++) {
            permutation[depth] = numbers[i];
            permute(depth + 1);
        }
    }

    private static void print() {
        for (int i = 0; i < m; i++) {
            RESULT.append(permutation[i] + " ");
        }
        RESULT.append(System.lineSeparator());
    }
}
