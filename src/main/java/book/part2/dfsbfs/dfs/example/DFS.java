package book.part2.dfsbfs.dfs.example;

public interface DFS {
    void connectNode(final int node, final int otherNode);
    void searchRecursive(final int node);
    void searchUsingStack(final int node);
    void printGraph();
}
