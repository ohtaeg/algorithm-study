package inflearn.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * https://cote.inflearn.com/contest/10/problem/08-11
 */
public class 미로최단거리 {
    static int[][] distances, board;
    private static final int[][] DIRECTION = {
            new int[]{-1, 0} // 북 0
            , new int[]{0, 1} // 동 1
            , new int[]{1, 0} // 남 2
            , new int[]{0, -1} // 서 3
    };

    private void bfs(final int x, final int y) {
        Queue<Point> queue = new LinkedList<>();
        // 탐색 출발점을 넣는다.
        queue.offer(new Point(x, y));

        board[x][y] = 1;

        while (!queue.isEmpty()) {
            final Point current = queue.poll();

            for (int i = 0; i < 4; i++) {
               int nx = current.x + DIRECTION[i][0];
               int ny = current.y + DIRECTION[i][1];

               if (nx >= 1 && nx <= 7 && ny >= 1 && ny <= 7 && board[nx][ny] == 0) {
                   board[nx][ny] = 1;
                   queue.offer(new Point(nx, ny));
                   distances[nx][ny] = distances[current.x][current.y] + 1;
               }
            }
        }
    }

    public static void main(String[] args) {
        미로최단거리 main = new 미로최단거리();

        Scanner sc = new Scanner(System.in);

        board = new int[8][8];
        distances = new int[8][8];

        for (int i = 1; i <= 7; i++) {
            for (int j = 1; j <= 7; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        main.bfs(1, 1);

        if (distances[7][7] == 0) {
            System.out.println(-1);
        } else {
            System.out.println(distances[7][7]);
        }
    }

    private static class Point {
        public int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
