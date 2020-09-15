package book.part2.dfsbfs.dfs.example;

import java.util.Stack;

/**
 * 인접 행렬을 이용한 DFS 구현
 * 인접행렬은 크기가 노드와 간선의 갯수와 상관 없이 노드 갯수 * 노드 갯수 이기 때문에 공간 복잡도가 O(N ^ 2)
 */
public class ArrayDFS implements DFS {
    private static final int INFINITY = 999999999;
    private static final int CONNECT = 1;

    private final int[][] graph;
    private final boolean[] isVisit;

    public ArrayDFS(final int nodeCount) {
        this.graph = new int[nodeCount + 1][nodeCount + 1];
        this.isVisit = new boolean[nodeCount + 1];
    }

    @Override
    public void connectNode(final int node, final int otherNode) {
        this.graph[node][otherNode] = CONNECT;
        this.graph[otherNode][node] = CONNECT;
    }

    @Override
    public void searchRecursive(final int node) {
        System.out.print(node + " ");
        setVisit(node);

        for (int otherNode = 1; otherNode < this.graph.length; otherNode++) {
            if (isConnectedNode(node, otherNode) && canVisit(otherNode)) {
                searchRecursive(otherNode);
            }
        }
    }

    @Override
    public void searchUsingStack(final int node) {
        Stack<Integer> stack = new Stack<>();
        stack.push(node);

        System.out.print(node + " ");
        setVisit(node);

        while (!stack.isEmpty()) {
            final int nextNode = searchNext(stack.peek());

            if (isInfinite(nextNode)) {
                stack.pop();
            } else {
                stack.push(nextNode);

                System.out.print(nextNode + " ");
                setVisit(nextNode);
            }
        }
    }

    private int searchNext(final int node) {
        for (int otherNode = 1; otherNode < this.graph.length; otherNode++) {
            if (isConnectedNode(node, otherNode) && canVisit(otherNode)) {
                return otherNode;
            }
        }
        return INFINITY;
    }


    private boolean isInfinite(final int nextNode) {
        return nextNode == INFINITY;
    }

    private boolean isConnectedNode(final int node, final int otherNode) {
        return this.graph[node][otherNode] == CONNECT && this.graph[otherNode][node] == CONNECT;
    }

    private boolean canVisit(final int node) {
        return this.isVisit[node] == false;
    }

    private void setVisit(final int node) {
        this.isVisit[node] = true;
    }

    @Override
    public void printGraph() {
        System.out.println("인접 행렬 출력");
        for (int node = 1; node < this.graph.length; node++) {
            for (int otherNode = 1; otherNode < this.graph[node].length; otherNode++) {
                System.out.print(this.graph[node][otherNode] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
