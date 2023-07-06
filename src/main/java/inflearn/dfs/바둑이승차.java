package inflearn.dfs;

import java.util.Scanner;

/**
 * https://cote.inflearn.com/contest/10/problem/08-02
 *
 * 이 문제도 부분집합과 유사하게 접근하면 된다.
 */
public class 바둑이승차 {

    static int c, n, answer;
    static int[] dogs;

    public int dfs(int level, int sum) {
        if (sum > c) {
            return answer;
        }

        if (level == n) {
            answer = Integer.max(answer, sum);
        } else {
            dfs(level + 1, sum + dogs[level]);
            dfs(level + 1, sum);
        }

        return answer;

    }

    public static void main(String[] args) {
        바둑이승차 main = new 바둑이승차();
        Scanner sc = new Scanner(System.in);
        c = sc.nextInt();
        n = sc.nextInt();

        dogs = new int[n];
        for (int i = 0; i < n; i++) {
            dogs[i] = sc.nextInt();
        }

        System.out.println(main.dfs(0, 0));
    }
}
