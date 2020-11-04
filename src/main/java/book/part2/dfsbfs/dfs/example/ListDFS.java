package book.part2.dfsbfs.dfs.example;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 인접 리스트를 이용한 DFS 구현
 * 인접 리스트의 공간 복잡도는 O(N + M)
 */
public class ListDFS implements DFS {
    private static final int INFINITY = 999999999;

    private final List<Integer>[] graph;
    private final boolean[] isVisit;

    public ListDFS(final int nodeCount) {
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
    public void searchRecursive(final int node) {
        System.out.print(node + " ");
        setVisit(node);

        for (int otherNode : graph[node]) {
            if (canVisit(otherNode)) {
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
        for (int next : this.graph[node]) {
            if (canVisit(next)) {
                return next;
            }
        }
        return INFINITY;
    }

    private boolean canVisit(final int node) {
        return !this.isVisit[node];
    }

    private boolean isInfinite(final int nextNode) {
        return nextNode == INFINITY;
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
