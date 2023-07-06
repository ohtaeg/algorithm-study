package inflearn.dfs;

import java.util.Scanner;

/**
 * 1부터 N까지 번호가 적힌 구슬이 존재할 때, 중복을 허락하여 M번을 뽑아 일렬로 나열하는 방법을 모두 출력
 * 첫째 줄에 자연수 N과 M이 주어진다.
 * 입력
 * 3 2
 * 출력
 * 1 1
 * 1 2
 * 1 3
 * 2 1
 * 2 2
 * 2 3
 * 3 1
 * 3 2
 * 3 3
 *
 * 이 문제는 상태트리가 여러 가닥으로 뻗어나가는 것이 특징
 */
public class 중복순열 {
    static int n, m;
    static int[] permutation;

    public void dfs(int level) {
        if (level == m) {
            for (int x : permutation) {
                System.out.print(x + " ");
            }
            System.out.println();
        } else {
           for (int i = 1; i <= n; i++) {
               permutation[level] = i;
               dfs(level + 1);
           }
        }
    }

    public static void main(String[] args) {
        중복순열 main = new 중복순열();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        permutation = new int[m];
        main.dfs(0);
    }
}
