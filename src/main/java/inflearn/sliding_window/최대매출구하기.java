package inflearn.sliding_window;

import java.util.Scanner;

/**
 * https://cote.inflearn.com/contest/10/problem/03-03
 * <p>
 * O(n^2) -> O(N)
 * sum + arr[i] - arr[i-k]
 */
public class 최대매출구하기 {

    public static int solution(int[] a, int k) {
        // sum = sum + arr[i] - arr[i-k]
        int answer = Integer.MIN_VALUE;
        int sum = 0;
        // 첫번째 슬라이드 초기화
        for (int i = 0; i < k; i++) {
            sum += a[i];
        }

        answer = sum;

        for (int i = k; i < a.length; i++) {
            sum += (a[i] - a[i - k]);
            answer = Integer.max(answer, sum);
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        System.out.println(solution(a, k));
    }
}
