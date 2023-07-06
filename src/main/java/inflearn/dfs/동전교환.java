package inflearn.dfs;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * https://cote.inflearn.com/contest/10/problem/08-05
 *
 * level == 사용한 동전의 갯수
 *
 */
public class 동전교환 {
    static int n, m;
    static int min = Integer.MAX_VALUE;
    static Integer[] coins;

    private int dfs(final int level, final int sum) {
        // 시간 복잡도 최소화를 위해 사용한 동전의 갯수가 최소 갯수보다 많아지는 경우 탐색하지 않도록
        if (level > min) {
            return min;
        }
        if (sum > m) {
            return min;
        }
        if (sum == m) {
            min = Math.min(min, level);
            return min;
        }

        for (int i = 0; i < n; i++) {
            dfs(level + 1, sum + coins[i]);
        }

        return min;
    }

    public static void main(String[] args) {
        동전교환 main = new 동전교환();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        coins = new Integer[n];

        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }

        m = sc.nextInt();

        // 동전이 크면 최소 갯수도 그만큼 적어지기 때문에 큰 동전부터 탐색
        Arrays.sort(coins, Collections.reverseOrder());
        System.out.println(main.dfs(0, 0));
    }
}
