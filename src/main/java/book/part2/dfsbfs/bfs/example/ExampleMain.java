package book.part2.dfsbfs.bfs.example;

public class ExampleMain {

    public static void main(String[] args) {
        runArrayBFS();

        runListBFS();
    }

    private static void runArrayBFS() {
        BFS bfs = new ArrayBFS(8);
        initGraph(bfs);
        bfs.printGraph();

        System.out.println("---bfs search---");
        bfs.search(1);
        System.out.println();
        System.out.println();
    }

    private static void runListBFS() {
        BFS bfs = new ListBFS(8);
        initGraph(bfs);
        bfs.printGraph();

        System.out.println("---bfs search---");
        bfs.search(1);
        System.out.println();
        System.out.println();
    }


    private static void initGraph(final BFS bfs) {
        bfs.connectNode(1, 2);
        bfs.connectNode(1, 3);
        bfs.connectNode(1, 8);

        bfs.connectNode(2, 7);

        bfs.connectNode(3, 4);
        bfs.connectNode(3, 5);

        bfs.connectNode(4, 5);

        bfs.connectNode(6, 7);

        bfs.connectNode(7, 8);
    }
}
