package boj.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * GCD 합
 * 문제의 포인트는 N개의 수를 2개씩 짝지어서 GCD를 구하고 더하는 것
 * 데이터의 크기가 최대 백만이고 데이터의 갯수가 100개의 제한이 있을때
 * n개인 수들을 2개씩 짝지어 만드는 모든 경우의 수는 n * (n-1) / 2
 * 해당 문제는 합을 구하는 것이기 떄문에 (100 * 99 / 2) * 백만을 하면 정수값 범위를 넘는걸 조심해야한다.
 */
public class Q9613 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bufferedReader.readLine());
        int[][] arr = new int[t][];

        for (int i = 0; i < t; i++) {
            String[] line = bufferedReader.readLine().split(" ");
            int n = Integer.parseInt(line[0]);
            arr[i] = new int[n];
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(line[j + 1]);
            }
        }

        for (int i = 0; i < t; i++) {
            long lineSum = 0;
            for (int j = 0; j < arr[i].length - 1; j++) {
                int left = arr[i][j];
                for (int k = j + 1; k < arr[i].length; k++) {
                    int right = arr[i][k];
                    lineSum += gcd(left, right);
                }
            }
            System.out.println(lineSum);
        }

    }

    private static int gcd(final int left, final int right) {
        if (right == 0) {
            return left;
        }
        return gcd(right, left % right);
    }
}
