package inflearn.dfs;

import java.util.Scanner;

/**
 * https://cote.inflearn.com/contest/10/problem/08-03
 *
 * 이 문제도 부분집합과 유사하게 접근하면 된다.
 */
public class 최대점수구하기 {

    static int n, timeLimit, maxScore;
    static int[] scores;
    static int[] times;

    public int dfs(int level, int timeSum, int scoreSum) {
        if (timeSum > timeLimit) {
            return maxScore;
        }

        if (level == n) {
            maxScore = Integer.max(maxScore, scoreSum);
            return maxScore;
        }

        dfs(level + 1, timeSum + times[level], scoreSum + scores[level]);
        dfs(level + 1, timeSum, scoreSum);

        return maxScore;
    }

    public static void main(String[] args) {
        최대점수구하기 main = new 최대점수구하기();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        timeLimit = sc.nextInt();

        scores = new int[n];
        times = new int[n];

        for (int i = 0; i < n; i++) {
            scores[i] = sc.nextInt();
            times[i] = sc.nextInt();
        }

        System.out.println(main.dfs(0, 0, 0));
    }
}
