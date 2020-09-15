package book.part2.dfsbfs.bfs.example;

public interface BFS {
    void connectNode(final int node, final int otherNode);
    void search(final int node);
    void printGraph();
}
