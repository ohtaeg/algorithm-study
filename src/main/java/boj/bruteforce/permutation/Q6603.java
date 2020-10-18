package boj.bruteforce.permutation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 로또
 */
public class Q6603 {
    private static int[] lotto = new int[6];
    private static int[] numbers;
    private static int n;
    private static final StringBuilder result = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            final String[] source = bufferedReader.readLine()
                                                  .split(" ");
            n = Integer.parseInt(source[0]);
            if (n == 0) {
                break;
            }

            if (result.toString().length() > 0) {
                result.append(System.lineSeparator());
            }

            numbers = new int[n];
            for (int i = 0; i < n; i++) {
                numbers[i] = Integer.parseInt(source[i + 1]);
            }
            permute(0, 0);
        }
        System.out.println(result.toString());
    }

    private static void permute(final int depth, final int startIndex) {
        if (depth == 6) {
            print();
            return;
        }

        for (int i = startIndex; i < n; i++) {
            lotto[depth] = numbers[i];
            permute(depth + 1, i + 1);
        }
    }

    private static void print() {
        for (int i = 0; i < 6; i++) {
            result.append(lotto[i] + " ");
        }
        result.append(System.lineSeparator());
    }
}
