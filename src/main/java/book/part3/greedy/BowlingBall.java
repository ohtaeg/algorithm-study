package book.part3.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BowlingBall {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = bufferedReader.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        int[] balls = convertToInteger(bufferedReader.readLine()
                                                     .split(" "));

        int result = select(balls);
        int result2 = solution(balls, n, m);
        System.out.println(result);
        System.out.println(result2);
        bufferedReader.close();
    }

    private static int select(final int[] balls) {
        int count = 0;
        for (int i = 0; i < balls.length - 1; i++) {
            for (int j = i + 1; j < balls.length; j++) {
                if (balls[i] != balls[j]) {
                    count++;
                }
            }
        }
        return count;
    }

    private static int[] convertToInteger(final String[] source) {
        return Arrays.stream(source)
                     .mapToInt(Integer::parseInt)
                     .toArray();
    }

    private static int solution(final int[] balls, int n, final int m) {
        final int[] counts = new int[n + 1];
        for (int i = 0; i < n; i++) {
            counts[balls[i]] += 1;
        }

        int result = 0;
        for (int i = 1; i <= m; i++) {
            n -= counts[i];
            result += counts[i] * n;
        }

        return result;
    }
}
