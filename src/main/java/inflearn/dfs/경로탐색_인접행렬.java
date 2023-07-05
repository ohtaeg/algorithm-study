package inflearn.dfs;

import java.util.Scanner;

/**
 * 방향 그래프가 주어지면 1번 정점에서 N번 정점으로 가는 모든 경로의 가지수를 출력하시오
 * 첫줄에는 정점의 수와 간선의 수가 주어진다. 그 다음줄부터 M줄에 걸쳐 연결 정보가 주어진다.
 * 5 9
 * 1 2
 * 1 3
 * 1 4
 * 2  1
 * 2 3
 * 2 5
 * 3 4
 * 4 2
 * 4 5
 * 출력
 * 6
 *
 *
 * 1 2 3 4 5
 * 1 2 5
 * 1 3 4 2 5
 * 1 3 4 5
 * 1 4 2 5
 * 1 4 5
 *
 * 1 <-> 2 -> 5
 * |  X  ^   ^
 * #     | /
 * 3  -> 4
 *
 * 경로 탐색시 한번 방문한 노드는 다시는 방문을 하지 않도록 하는것이 중요하다.
 * 즉슨 1 2 3 4 5 검색시 방문한 노드는 재방문하지 못하도록 체크배열을 이용하고
 * 재귀가 끝나면서 다시 방문(1 2 5 등) 할 수 있도록 체크 배열을 풀어준다.
 */
public class 경로탐색_인접행렬 {
    static int n, m, answer = 0;
    static int[][] graph;
    static boolean[] isVisit;

    public void dfs(int vertex) {
        if (vertex == n) {
            answer++;
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (graph[vertex][i] == 1 && !isVisit[i]) {
                isVisit[i] = true;
                dfs(i);
                isVisit[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        경로탐색_인접행렬 main = new 경로탐색_인접행렬();
        Scanner s = new Scanner(System.in);
        n = s.nextInt();
        m = s.nextInt();
        graph = new int[n + 1][m + 1];
        isVisit = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            int a = s.nextInt();
            int b = s.nextInt();
            graph[a][b] = 1;
        }

        isVisit[1] = true;
        main.dfs(1);
        System.out.println(answer);
    }
}
