package inflearn.dfs;

import java.util.Scanner;

/**
 * 10 이하의 N개의 자연수가 주어지면 이 중 M개를 뽑아 일렬로 나열하는 방법을 모두 출력
 * 입력
 * 첫번째 줄에 N, M이 주어지고 두번째 줄에 N개의 자연수가 주어진다.
 * 3 2
 * 3 6 9
 * 출력
 * 3 6
 * 3 9
 * 6 3
 * 6 9
 * 9 3
 * 9 6
 *
 * 중복된 수열을 구하지 않기 위해 방문 배열을 사용한다.
 */
public class 순열구하기 {

    static int n, m;
    static int[] permutation, numbers;
    static boolean[] isVisit;

    private void dfs(final int level) {
        if (level == m) {
            for (int i = 0; i < m; i++) {
                System.out.print(permutation[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!isVisit[i]) {
                isVisit[i] = true;
                permutation[level] = numbers[i];
                dfs(level + 1);
                isVisit[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        순열구하기 main = new 순열구하기();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        numbers = new int[n];
        permutation = new int[m];
        isVisit = new boolean[n];

        for (int i = 0; i < n; i++) {
            numbers[i] = sc.nextInt();
        }

        main.dfs(0);
    }
}
