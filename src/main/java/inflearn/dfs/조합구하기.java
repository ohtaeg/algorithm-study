package inflearn.dfs;

import java.util.Scanner;

/**
 * 1부터 N까지 번호가 적힌 구슬이 있다. 이 중 M개를 뽑는 방법의 수를 출력하라
 * 첫번째 줄에 자연수 N과 M이 주어진다.
 * 입력
 * 4 2
 * 출력 사전순으로 오름차순
 * 1 2
 * 1 3
 * 1 4
 * 2 3
 * 2 4
 * 3 4
 */
public class 조합구하기 {
    private static int[] combi;
    private static int n, m;

    public void dfs(int level, int number) {
        if (level == m) {
            for (int x : combi) {
                System.out.print(x + " ");
            }
            System.out.println();
            return;
        }

        for (int i = number; i <= n; i++) {
            combi[level] = i;
            dfs(level + 1,  i + 1);
        }
    }

    public static void main(String[] args) {
        조합구하기 main = new 조합구하기();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        combi = new int[m];
        main.dfs(0, 1);
    }

}
