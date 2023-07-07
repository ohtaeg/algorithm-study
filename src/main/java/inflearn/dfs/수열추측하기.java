package inflearn.dfs;

import java.util.Scanner;

/**
 * https://cote.inflearn.com/contest/10/problem/08-08
 */
public class 수열추측하기 {

    private static int[] b, p;
    private static boolean[] isVisit; // 중복해서 뽑지 않기 위해
    private int[][] dy = new int[35][35];
    private static int n, f;
    private static boolean isFinish;

    private int combi(final int n, final int r) {
        if (dy[n][r] > 0) {
            return dy[n][r];
        }

        if (n == r || r ==0) {
            return 1;
        }

        dy[n][r] = combi(n-1, r-1) + combi(n-1, r);
        return dy[n][r];
    }

    private void dfs(final int level, final int sum) {
        if (isFinish) {
            return;
        }
        if (level == n) {
            if (sum == f) {
                for (int i : p) {
                    System.out.print(i + " ");
                }
                isFinish = true;
            }
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!isVisit[i]) {
                isVisit[i] = true;
                p[level] = i;
                dfs(level + 1, sum + p[level] * b[level]);
                isVisit[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        수열추측하기 main = new 수열추측하기();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        f = sc.nextInt();
        b = new int[n];
        p = new int[n];
        isVisit = new boolean[n + 1]; // 1 부터 체크하기 위해 + 1

        for (int i = 0; i < n; i++) {
            b[i] = main.combi(n-1, i);
        }

        main.dfs(0, 0);
    }

}
