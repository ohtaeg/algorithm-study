package book.part2.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1이 될떄 까지
 */
public class One {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bufferedReader.readLine().split(" ");
        final int n = Integer.parseInt(input[0]);
        final int k = Integer.parseInt(input[1]);

        int result = calculateMinimumTimes(n, k);

        System.out.println(result);
        bufferedReader.close();
    }

    private static int calculateMinimumTimes(int n, final int k) {
        int count = 0;
        while (n != 1) {
            count++;
            if (canDivide(n, k)) {
                n /= k;
            } else {
                n--;
            }
        }
        return count;
    }

    private static boolean canDivide(final int n, final int k) {
        return n % k == 0;
    }
}
