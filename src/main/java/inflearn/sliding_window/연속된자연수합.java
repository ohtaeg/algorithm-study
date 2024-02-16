package inflearn.sliding_window;

import java.util.Scanner;

/**
 * 양의 정수 N (7 <= N < 1000) 이 입력되면 2개 이상의 연속된 자연수의 합으로 정수 N을 표현하는 방법의 가짓수를 출력하라
 * 만약 N이 15이면
 * 7 8
 * 4 5 6
 * 1 2 3 4 5
 * 총 3가지이다.
 */
public class 연속된자연수합 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(solution(n));
        System.out.println(solutionByMath(n));
    }

    /**
     * 투포인터 해결 방법
     * @param n
     * @return
     */
    private static int solution(final int n) {
        int left = 0;
        int sum = 0;
        int count = 0;

        for (int right = 1; right < n / 2 + 1; right++) {
            sum += right;

            if (sum == n) {
                count++;
            }

            while (sum >= n) {
                sum -= left++;
                if (sum == n) {
                    count++;
                }
            }
        }

        return count;
    }

    /**
     * 수학적 해결
     * @param n
     * @return
     */
    private static int solutionByMath(int n) {
        int count = 0;
        int m = 1;
        n--;
        while (n > 0) {
            m++;
            n -= m;
            if (n % m == 0) {
                count++;
            }
        }

        return count;
    }
}
