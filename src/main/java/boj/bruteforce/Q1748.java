package boj.bruteforce;

import java.util.Scanner;

/**
 * 수 이어 쓰기 1
 * N - (N의 자리 - 1) = n 자리의 갯수를 구할 수 있다.
 * N = 12 일때
 * 1의 자리의 갯수는 12 - (1 - 1) = 12개
 * 10의 자리의 갯수는 12 - (10 - 1) = 3개
 * 총 15개이다.
 * 1의 자리 12개 => 1, 2, 3, 4, 5, 6, 7, 8, 9, 1(0), 1(1), 1(2) => 12개
 * 10의 자리 3개 => (1)0, (1)1, (1)2
 */
public class Q1748 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int length = 0;
        for (int placeValue = 1; placeValue <= n; placeValue *= 10) {
            length += n - (placeValue - 1);
        }
        System.out.println(length);
    }
}
