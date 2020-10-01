package boj.bruteforce;

import java.util.Scanner;

/**
 * 날짜 계산
 * x가 16일때 e는 = x - 1 % 15 == 0
 * x가 16일때 s는 = x - 1 % 28 == 0
 * x가 16일때 m은 = x - 1 % 19 == 0
 */
public class Q1476 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int e = scanner.nextInt();
        final int s = scanner.nextInt();
        final int m = scanner.nextInt();
        final int year = calculateYear(e,s,m);
        System.out.println(year);
    }

    private static int calculateYear(final int e, final int s, final int m) {
        int year = 0;

        while (true) {
            year++;
            if ((year - e) % 15 == 0 && (year - s) % 28 == 0 && (year - m) % 19 == 0) {
                break;
            }
        }
        return year;
    }
}
