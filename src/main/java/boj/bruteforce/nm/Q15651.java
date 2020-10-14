package boj.bruteforce.nm;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

/**
 * N과 M (3)
 * 순열을 중복 허용해서 구하는 문제
 * (1, 1) (1, 2) (1, 3) (2, 1) (3, 1) ok
 * (1, 1, 1) (1, 1, 2) (2, 1, 1) (1, 2, 1) ok
 *
 * 시간 초과 조심해야함
 * 한번에 출력할 것
 */
public class Q15651 {
    private static final StringBuilder result = new StringBuilder();
    private static int n;
    private static int m;
    private static int[] numbers;

    public static void main(String[] args) throws IOException {
        final BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        m = scanner.nextInt();
        numbers = new int[m];

        permute(0);
        bufferedWriter.write(result.toString());
        bufferedWriter.flush();
    }

    private static void permute(final int depth) {
        if (m == depth) {
            print();
            return;
        }

        for (int number = 1; number <= n; number++) {
            numbers[depth] = number;
            permute(depth + 1);
        }
    }

    private static void print() {
        for (int number : numbers) {
            result.append(number)
                  .append(" ");
        }
        result.append(System.lineSeparator());
    }
}
