package inflearn.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class 다익스트라 {
    static int[] dis;
    static List<List<Edge>> graph;

    public static void main(String[] args) {
        다익스트라 test = new 다익스트라();

        test.solution(6,
                new int[][]{
                        {1, 2, 12}
                        , {1, 3, 4}
                        , {2, 1, 2}
                        , {2, 3, 5}
                        , {2, 5, 5}
                        , {3, 4, 5}
                        , {4, 2, 2}
                        , {4, 5, 5}
                        , {6, 4, 5}
                }
        );
    }

    public void solution(int n, int[][] vertexes) {
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        dis = new int[n + 1];

        Arrays.fill(dis, Integer.MAX_VALUE);

        for (int i = 0; i < vertexes.length; i++) {
            graph.get(vertexes[i][0]).add(new Edge(vertexes[i][1], vertexes[i][2]));
        }

        move(1);
    }

    private void move(final int v) {

        PriorityQueue<Edge> queue = new PriorityQueue<>();
        queue.offer(new Edge(v, 0));
        dis[v] = 0;

        while (!queue.isEmpty()) {
            Edge edge = queue.poll();
            int vertex = edge.vertex;
            int cost = edge.cost;

            if (cost > dis[vertex]) {
                continue;
            }

            for (Edge nextEdge : graph.get(vertex)) {
                if (dis[nextEdge.vertex] > cost + nextEdge.cost) {
                    dis[nextEdge.vertex] = cost + nextEdge.cost;
                    queue.offer(new Edge(nextEdge.vertex, cost + nextEdge.cost));
                }
            }
        }

    }
}

class Edge implements Comparable<Edge> {
    public int vertex;
    public int cost;

    public Edge(final int vertex, final int cost) {
        this.vertex = vertex;
        this.cost = cost;
    }

    @Override
    public int compareTo(final Edge o) {
        return this.cost - o.cost;
    }
}
