package inflearn.sliding_window;

import java.util.Scanner;

/**
 * N개의 수로 이루어진 수열이 주어진다.
 * 이 수열에서 연속부분수열의 합이 특정 숫자 M이 되는 경우가 몇 번 있는지 구하라.
 * 만약 N=8, M=6이고 수열이 다음과 같다면
 * 1 2 1 3 1 1 1 2
 * 합이 6이 되는 연속 부분 수열은 {2, 1, 3}, {1, 3, 1, 1}, {3, 1, 1, 1}로 총 3가지이다.
 * 첫째줄에 N (1 <= N <= 100,000), M (1 <= M <= 100,000,000) 주어진다.
 * 수열의 원소의 값은 1,000을 넘지 않는다.
 *
 * 이중 포문으로 접근한다면 데이터가 M 최대값이 크기 때문에 시간초과 발생
 * 투포인터로 lt ~ rt 사이의 값이 M인지, 만약 크다면 lt를 움직이고 작다면 rt를 움직인다.
 */
public class 연속부분수열 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.println(solution(n, m , arr));
    }

    private static int solution(int n, int m, int[] sequence) {
        int lt = 0;
        int count = 0;
        int sum = 0;

        for (int rt = 0; rt < n; rt++) {
            sum += sequence[rt];
            if (sum == m) {
                count++;
            }

            while (sum >= m) {
                sum -= sequence[lt++];
                if (sum == m) {
                    count++;
                }
            }
        }


        return count;

    }
}
