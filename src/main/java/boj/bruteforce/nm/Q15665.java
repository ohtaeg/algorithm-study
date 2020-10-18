package boj.bruteforce.nm;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

/**
 * N과 M (11)
 * 입력값에 중복되는 숫자가 들어온다.
 * 중복되는 수열 출력 x
 * 수열에 같은 숫자가 포함될 수 있다.
 * 시간 초과 조심
 *
 * 4 2
 * 9 7 9 1
 *
 * 1 1
 * 1 7
 * 1 9
 * 7 1
 * 7 7
 * 7 9
 * 9 1
 * 9 7
 * 9 9
 *
 */
public class Q15665 {
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

        final boolean[] isUsed = new boolean[10001];
        for (int i = 0; i < n; i++) {
            if (!isUsed[numbers[i]]) {
                permutation[depth] = numbers[i];
                isUsed[numbers[i]] = true;
                permute(depth + 1);
            }
        }
    }

    private static void print() {
        for (int i = 0; i < m; i++) {
            RESULT.append(permutation[i] + " ");
        }
        RESULT.append(System.lineSeparator());
    }
}
