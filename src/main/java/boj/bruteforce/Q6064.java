package boj.bruteforce;

import java.util.Scanner;

/**
 * 카잉 달력
 * 이 문제는 날짜 계산과 비슷하지만 고려해야 될 문제가 2개가 있다.
 * 1. 종료조건이 고민이였는데 N과 M의 최소공배수를 G라고 한다면 이 G번째 해가 달력의 마지막이기 때문에 첫번째 해부터 G번째 해까지 <X,Y>
 * 로 표현되는 해가 없다면 <X,Y> 가 유효하지 않은 표현이다. 즉 k가 주어진 m, n의 공배수보다 클 수 없기에 커지게 된다면 -1을 리턴하면 된다.
 * 2. 날짜 계산처럼 year를 1씩 증가시켜서 푼다면 시간초과가 난다.
 * 시간 초과를 어떻게 개선할 수 있을까?
 *
 * year % M = x, x는 m 주기로 나타난다
 * year % N = y, y는 n 주기로 나타난다
 * year를 m, n으로 나눈 값이 x와 y 가 된다
 * year를 m 만큼 증가시켜 바로 다음 주기의 해가 n으로 나눴을떄 y가 나오는지 검사 하여
 * 1부터 증가하던 방식을 m번만큼 점프하여 증가하는 식으로 구함.
 *
 * 코드에서 중간에 (year - 1) % n + 1 == y 코드가 있는데
 * year를 -1 해주고 n을 나눈 나머지에 + 1을 한 이유는
 * m이 10이고, x가 10일때
 * year x
 * 1    1
 * 2    2
 *   ...
 * 10   10 -> year % m 해버리면 x는 0이되버린다. 0이 되지 않게 x에 -1을 하고 마지막에 +1 해주었다.
 * 11   1
 */
public class Q6064 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCase = scanner.nextInt();
        while (testCase-- > 0) {
            final int m = scanner.nextInt();
            final int n = scanner.nextInt();
            final int x = scanner.nextInt();
            final int y = scanner.nextInt();

            int k = calculate(m, n, x, y);
            System.out.println(k);
        }
    }

    private static int calculate(final int m, final int n, final int x, final int y) {
        int maxYear = lcm(m, n);

        for (int year = x; year <= maxYear; year += m) {
            if ((year - 1) % n + 1 == y) {
                return year;
            }
        }

        return -1;
    }

    private static int lcm(final int m, final int n) {
        return m * n / gcd(m ,n);
    }

    private static int gcd(final int m, final int n) {
        if (n == 0) {
            return m;
        }
        return gcd(n, m % n);
    }
}
