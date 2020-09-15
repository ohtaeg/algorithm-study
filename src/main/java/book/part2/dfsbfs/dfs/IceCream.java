package book.part2.dfsbfs.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 음료수 얼려 먹기 (재귀, 비재귀)
 * 3 3
 * 010
 * 001
 * 111
 *
 * 2
 *
 * 4 5
 * 00110
 * 00011
 * 11111
 * 00000
 *
 * 3
 *
 * 5 14
 * 00000111100000
 * 11111101111110
 * 11011101101110
 * 11011101100000
 * 11011111111111
 *
 * 4
 */
public class IceCream {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = bufferedReader.readLine().split(" ");
        int height = Integer.parseInt(nm[0]);
        int width = Integer.parseInt(nm[1]);

        int[][] graph = new int[height][width];
        for (int i = 0; i < height; i++) {
            String[] row = bufferedReader.readLine().split("");
            for (int j = 0; j < row.length; j++) {
                graph[i][j] = Integer.parseInt(row[j]);
            }
        }

        int result = freezeDrink(height, width, graph);
        System.out.println(result);
        bufferedReader.close();
    }

    private static int freezeDrink(final int height, final int width, final int[][] graph) {
        int count = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (isIce(graph[i][j])) {
                    dfs(i, j, graph);
                    //dfsStack(i, j, graph);
                    count++;
                }
            }
        }
        return count;
    }

    private static boolean isIce(final int graph) {
        return graph == 0;
    }

    private static boolean dfs(final int x, final int y, final int[][] graph) {
        if (isOver(x, y, graph)) {
            return false;
        }

        if (graph[x][y] == 1) {
            return false;
        }

        graph[x][y] = 1;
        dfs(x - 1, y, graph); // 상
        dfs(x + 1, y, graph); // 하
        dfs(x, y - 1, graph); // 좌
        dfs(x, y + 1, graph); // 우

        return true;
    }

    private static boolean isOver(final int x, final int y, final int[][] graph) {
        return x < 0 || x >= graph.length || y < 0 || y >= graph[x].length;
    }

    /**
     * 여기서부턴 Stack
     */
    private static void dfsStack(final int x, final int y, final int[][] graph) {
        Stack<Point> stack = new Stack<>();
        stack.push(new Point(x, y));
        graph[x][y] = 1;

        while (!stack.isEmpty()) {
            final Point next = searchNext(stack.peek(), graph);

            if (isInfinite(next)) {
                stack.pop();
            } else {
                stack.push(next);
                graph[next.getX()][next.getY()] = 1;
            }
        }
    }

    private static Point searchNext(final Point point, final int[][] graph) {
        int x = point.getX();
        int y = point.getY();

        // 위로 올라갈 수 있는지
        if (x - 1 >= 0 && isIce(graph[x - 1][y])) {
            return new Point(x - 1, y);
        }

        // 아래로 갈 수 있는지
        if (x + 1 < graph.length && isIce(graph[x + 1][y])) {
            return new Point(x + 1, y);
        }

        // 왼쪽으로 갈 수 있는지
        if (y - 1 >= 0 && isIce(graph[x][y - 1])) {
            return new Point(x, y - 1);
        }

        // 오른쪽으로 갈 수 있는지
        if (y + 1 < graph[x].length && isIce(graph[x][y + 1])) {
            return new Point(x, y + 1);
        }

        return Point.INFINITY;
    }

    private static boolean isInfinite(final Point next) {
        return next.equals(Point.INFINITY);
    }
}

