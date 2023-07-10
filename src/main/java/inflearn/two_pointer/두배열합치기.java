package inflearn.two_pointer;

import java.util.Scanner;

/**
 * https://cote.inflearn.com/contest/10/problem/03-01
 *
 * 오름차순으로 정렬된 두 배열이 주어지면 두 배열을 오름차순으로 합쳐서 출력
 * 퀵 정렬해도 O(NlogN)
 * 투포인터로 O(N)
 */
public class 두배열합치기 {

    private static int[] solution(final int n, final int m, final int[] a, final int[] b) {
        int[] answer = new int[n + m];
        int p1 = 0;
        int p2 = 0;

        int index = 0;
        while (p1 < n && p2 < m) {
            if (a[p1] < b[p2]) {
                answer[index++] = a[p1++];
            } else {
                answer[index++] = b[p2++];
            }
        }

        while (p1 < n) {
            answer[index++] = a[p1++];
        }

        while (p2 < m) {
            answer[index++] = b[p2++];
        }

        return answer;

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        int m = scanner.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = scanner.nextInt();
        }

        for (int x : solution(n, m, a, b)) {
            System.out.print(x + " ");
        }

    }
}
