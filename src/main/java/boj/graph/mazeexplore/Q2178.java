package boj.graph.mazeexplore;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Q2178 {
    private static final int[][] DIRECTION = {
            new int[]{-1, 0} // 북 0
            , new int[]{0, 1} // 동 1
            , new int[]{1, 0} // 남 2
            , new int[]{0, -1} // 서 3
    };
    private static final int WALL = 1;
    private static final int PATH = 0;

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

        int result = bfs(0, 0, graph);
        System.out.println(result);
        bufferedReader.close();
    }

    private static int bfs(final int startX, final int startY, final int[][] graph) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(startX, startY));

        while (!queue.isEmpty()) {
            Point point = queue.poll();
            int x = point.getX();
            int y = point.getY();

            for (int i = 0; i < 4; i++) {
                int nextX = x + DIRECTION[i][0];
                int nextY = y + DIRECTION[i][1];

                if (isOver(nextX, nextY, graph)) {
                    continue;
                }

                if (isWall(graph[nextX][nextY])) {
                    continue;
                }

                if (canMove(graph[nextX][nextY])) {
                    graph[nextX][nextY] = graph[x][y] + 1;
                    queue.offer(new Point(nextX, nextY));
                }
            }
        }
        return graph[graph.length -1][graph[0].length - 1];
    }

    private static boolean canMove(final int point) {
        return point == WALL;
    }

    private static boolean isWall(final int point) {
        return point == PATH;
    }

    private static boolean isOver(final int x, final int y, final int[][] graph) {
        return x < 0 || x >= graph.length || y < 0 || y >= graph[x].length;
    }
}
