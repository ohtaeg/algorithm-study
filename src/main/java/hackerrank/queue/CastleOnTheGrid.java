package hackerrank.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 카테고리가 큐라서 그런지 BFS로 접근해야하는 문제
 * 연습 문제라고 하기엔 어려운 문제
 * 첫 시도는 케이스는 통과하지만 시간 초과 발생
 * 인터넷 참고하여 재풀이
 */
public class CastleOnTheGrid {
    private static final int[][] DIRECTIONS = {
            new int[]{-1, 0} // [0] 북
            , new int[]{0, 1} // [1] 동
            , new int[]{1, 0} // [2] 남
            , new int[]{0, -1} // [3] 서
    };
    private static final int VISITED = 0;
    private static final int UNVISITED = -1;
    private static final int BLOCK = -2;

    public static void main(String[] args) {
        String[] grid = {
                "...X"
                , ".X.X"
                , ".X.X"
                , "...."
        };
        final int i = CastleOnTheGrid.minimumMoves(grid, 0, 0, 3, 3);
        System.out.println(i);
    }

    static int minimumMoves(String[] grid, int startX, int startY, int goalX, int goalY) {
        int[][] graph = init(grid);
        graph[startX][startY] = VISITED;

        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(startX, startY));

        while (!queue.isEmpty()) {
            Point point = queue.poll();
            int x = point.x;
            int y = point.y;

            if (x == goalX && y == goalY) {
                return graph[x][y];
            }

            for (int i = 0; i < DIRECTIONS.length; i++) {
                int nextX = x;
                int nextY = y;

                while (canMove(nextX + DIRECTIONS[i][0], nextY + DIRECTIONS[i][1], graph)) {
                    nextX += DIRECTIONS[i][0];
                    nextY += DIRECTIONS[i][1];
                    if (nextX == goalX && nextY == goalY) {
                        return graph[x][y] + 1;
                    }

                    int next = graph[nextX][nextY];
                    if (next == UNVISITED) {
                        queue.offer(new Point(nextX, nextY));
                        graph[nextX][nextY] = graph[x][y] + 1;
                    }
                }
            }
        }

        return graph[startX][startY];
    }

    private static int[][] init(final String[] grid) {
        int n = grid.length;
        int[][] map = new int[n][n];

        for (int i = 0; i < n; i++) {
            String row = grid[i];
            for (int j = 0; j < n; j++) {
                char cell = row.charAt(j);
                if (cell == 'X') {
                    map[i][j] = BLOCK;
                } else {
                    map[i][j] = UNVISITED;
                }
            }
        }

        return map;
    }

    private static boolean canMove(final int x, final int y, final int[][] graph) {
        return !isOver(x, y, graph.length) && !isBlock(x, y, graph);
    }

    private static boolean isOver(final int x, final int y, final int length) {
        return x < 0 || x >= length || y < 0 || y >= length;
    }

    private static boolean isBlock(final int x, final int y, final int[][] graph) {
        return graph[x][y] == BLOCK;
    }

    private static class Point {
        private final int x;
        private final int y;

        public Point(final int x, final int y) {
            this.x = x;
            this.y = y;
        }
    }
}
