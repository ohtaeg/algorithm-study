package book.part2.dfsbfs.bfs.example;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 인접 리스트를 이용한 BFS 구현
 * 인접 리스트의 공간 복잡도는 O(N + M)
 */
public class ListBFS implements BFS {
    private static final int INFINITY = 999999999;

    private final List<Integer>[] graph;
    private final boolean[] isVisit;

    public ListBFS(final int nodeCount) {
        this.graph = init(nodeCount);
        this.isVisit = new boolean[nodeCount + 1];
    }

    private List<Integer>[] init(final int nodeCount) {
        List<Integer>[] graph = new LinkedList[nodeCount + 1];
        for (int i = 0; i <= nodeCount; i++) {
            graph[i] = new LinkedList<>();
        }
        return graph;
    }

    @Override
    public void connectNode(final int node, final int otherNode) {
        this.graph[node].add(otherNode);
        this.graph[otherNode].add(node);
    }

    @Override
    public void search(final int node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(node);
        setVisit(node);

        while (!queue.isEmpty()) {
            int target = queue.poll();
            System.out.print(target + " ");

            for (int otherNode : this.graph[target]) {
                if (canVisit(otherNode)) {
                    queue.add(otherNode);
                    setVisit(otherNode);
                }
            }
        }
    }

    private boolean canVisit(final int node) {
        return this.isVisit[node] == false;
    }

    private void setVisit(final int node) {
        this.isVisit[node] = true;
    }

    @Override
    public void printGraph() {
        System.out.println("인접 리스트 출력");
        for (int node = 1; node < graph.length; node++) {
            System.out.print("노드 " + node + " : ");
            for (int otherNode : graph[node]) {
                System.out.print(otherNode + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
