package inflearn.bfs;

import java.util.*;

/**
 * 1번 정점에서 각 정점으로 가는 최소 이동 간선수를 출력
 * 첫째 줄에 정점의 수 N, 간선의 수 M이 주어지고 그 다음부터 M줄에 걸쳐 연결 정보가 주어진다.
 6 9
 1 3
 1 4
 2 1
 2 5
 3 4
 4 5
 4 6
 6 2
 6 5

 출력 예제
 2 : 3
 3 : 1
 4 : 1
 5 : 2
 6 : 2
 */
public class 그래프최단거리 {

    static int n, m, answer = 0;
    static List<List<Integer>> graph;
    static boolean[] isVisit;
    static int[] distance;

    public void bfs(int vertex) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(vertex);

        isVisit[vertex] = true;
        distance[vertex] = 0;

        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();
            for (int nextVertex : graph.get(currentVertex)) {
                if (!isVisit[nextVertex]) {
                    isVisit[nextVertex] = true;
                    queue.offer(nextVertex);
                    distance[nextVertex] = distance[currentVertex] + 1;
                }
            }
        }
    }


    public static void main(String[] args) {
        그래프최단거리 main = new 그래프최단거리();
        Scanner s = new Scanner(System.in);
        n = s.nextInt();
        m = s.nextInt();
        graph = new ArrayList<>();
        isVisit = new boolean[n + 1];
        distance = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int a = s.nextInt();
            int b = s.nextInt();
            graph.get(a).add(b);
        }

        main.bfs(1);

        for (int i = 2; i <= n; i++) {
            System.out.println(i + " : " + distance[i]);
        }
    }
}
