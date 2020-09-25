package boj.basic;

import java.io.IOException;
import java.util.Scanner;

/**
 * 숨바꼭질 6
 * 3명의 동생이있고 수빈이의 위치가 3이고 동생들이 위치가 1, 7, 11일때
 * 3 + D, 3 - D 간격으로 이동했을떄 수빈이는 1, 7, 11위치로 갈 수 있는 간격 D중 최대값을 구해야 하는 문제
 */
public class Q17087 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        final int n = scanner.nextInt();
        final int x = scanner.nextInt();
        final int[] diff = new int[n];

        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs(x - scanner.nextInt());
        }
        
        int left = diff[0];
        for (int i = 1; i < n; i++) {
            int right = diff[i];
            left = gcd(left, right);
        }

        System.out.println(left);
    }

    private static int gcd(final int left, final int right) {
        if (right == 0) {
            return left;
        }
        return gcd(right, left % right);
    }
}
