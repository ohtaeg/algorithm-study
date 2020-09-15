package book.part2.dfsbfs.dfs.example;

public class ExampleMain {

    public static void main(String[] args) {
        // 인접 행렬 재귀
        runArrayDFSUsingRecursive();

        // 인접 행렬 비재귀 스택
        runArrayDFSUsingStack();

        // 인접 리스트 재귀
        runListDFSUsingRecursive();

        // 인접 리스트 비재귀
        runListDFSUsingStack();
    }

    private static void runArrayDFSUsingRecursive() {
        DFS dfs = new ArrayDFS(8);
        initGraph(dfs);
        dfs.printGraph();

        System.out.println("---dfs search---");
        dfs.searchRecursive(1);
        System.out.println();
        System.out.println();
    }

    private static void runArrayDFSUsingStack() {
        DFS dfs = new ArrayDFS(8);
        initGraph(dfs);
        dfs.printGraph();

        System.out.println("---dfs search---");
        dfs.searchUsingStack(1);
        System.out.println();
        System.out.println();
    }

    private static void runListDFSUsingRecursive() {
        DFS dfs = new ListDFS(8);
        initGraph(dfs);
        dfs.printGraph();

        System.out.println("---dfs search---");
        dfs.searchRecursive(1);
        System.out.println();
        System.out.println();
    }

    private static void runListDFSUsingStack() {
        DFS dfs = new ListDFS(8);
        initGraph(dfs);
        dfs.printGraph();

        System.out.println("---dfs search---");
        dfs.searchUsingStack(1);
        System.out.println();
        System.out.println();
    }

    private static void initGraph(final DFS dfs) {
        dfs.connectNode(1, 2);
        dfs.connectNode(1, 3);
        dfs.connectNode(1, 8);

        dfs.connectNode(2, 7);

        dfs.connectNode(3, 4);
        dfs.connectNode(3, 5);

        dfs.connectNode(4, 5);

        dfs.connectNode(6, 7);

        dfs.connectNode(7, 8);
    }
}
