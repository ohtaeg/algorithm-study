package boj.graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * 연결 요소의 갯수
 * 연결 요소란
 *     1. 연결 요소에 속한 모든 정점을 연결한 경로가 있어야 한다.
 *         1.1 정점이 하나 있어도 연결 요소
 *     2. 서로 다른 연결 요소에 속한 정점들 끼리 연결하는 경로가 있으면 안된다.
 *
 * 알고리즘
 * 1. 노드에 연결된 인접 노드들을 구한다.
 * 2. 첫 노드 (첫 인덱스) 부터 순차적으로 DFS를 한다.
 * 3.   DFS가 가능한 조건은 방문하지 않은 상태여야 한다.
 * 4. 해당 노드의 인접노드들의 모든 방문처리가 끝나면 카운트를 증가시키고 다음 노드 기준으로 2번-4번을 반복한다.
 *     4.1 이미 방문 처리가 된 노드라면 카운트를 증가하지 않는다.
 */
public class Q11724 {
    private static List<Integer>[] graph;
    private static boolean[] isVisit = new boolean[1001];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int n = scanner.nextInt();
        final int m = scanner.nextInt();
        initGraph(n);
        
        for (int i = 0; i < m; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            graph[u].add(v);
            graph[v].add(u);
        }

        int connectCount = 0;
        for (int node = 1; node <= n; node++) {
            if (canVisit(node)) {
                dfs(node);
                connectCount++;
            }
        }

        System.out.println(connectCount);
    }

    private static void initGraph(final int n) {
        graph = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new LinkedList<>();
        }
    }

    private static boolean canVisit(final int node) {
        return !isVisit[node];
    }

    private static void dfs(final int node) {
        isVisit[node] = true;

        for (int nestedNode : graph[node]) {
            if (canVisit(nestedNode)) {
                dfs(nestedNode);
            }
        }
    }
}
