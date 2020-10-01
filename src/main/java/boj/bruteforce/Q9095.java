package boj.bruteforce;

import java.util.Scanner;

public class Q9095 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCase = scanner.nextInt();
        int[] dp = new int[12];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int i = 4; i <= 11; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }

        while (testCase-- > 0) {
            System.out.println(sum(scanner.nextInt(), dp));
        }
    }

    private static int sum(final int number, final int[] dp) {
        return dp[number];
    }
}
