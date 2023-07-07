package inflearn.dfs;

import java.util.Scanner;

/**
 * https://cote.inflearn.com/contest/10/problem/08-07
 * nCr
 * 종료조건 r == 0 or n == r
 */
public class 조합의수 {
    private int dfs(final int n, final int r) {
        if (n == r || r == 0) {
            return 1;
        }
        return dfs(n - 1, r - 1) + dfs (n - 1, r);
    }

    public static void main(String[] args) {
        조합의수 main = new 조합의수();

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int r = sc.nextInt();

        System.out.println(main.dfs(n, r));
    }
}
