package inflearn.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * https://cote.inflearn.com/contest/10/problem/08-12
 */
public class 토마토 {

    private static final int[][] DIRECTION = {
            new int[]{-1, 0} // 북 0
            , new int[]{0, 1} // 동 1
            , new int[]{1, 0} // 남 2
            , new int[]{0, -1} // 서 3
    };
    static int n, m;
    static int[][] board, distance;

    static Queue<Point> queue = new LinkedList();

    private void bfs() {
        while(!queue.isEmpty()) {
            Point current = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = current.x + DIRECTION[i][0];
                int ny = current.y + DIRECTION[i][1];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m && board[nx][ny] == 0) {
                    board[nx][ny] = 1;
                    queue.offer(new Point(nx, ny));
                    distance[nx][ny] = distance[current.x][current.y] + 1;
                }
            }
        }
    }

    private void find() {
        boolean isUnderCooked = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 0) {
                    isUnderCooked = true;
                    break;
                }
            }
        }

        if (isUnderCooked) {
            System.out.println(-1);
            return;
        }

        int day = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                day = Math.max(day, distance[i][j]);
            }
        }
        System.out.println(day);
    }

    public static void main(String[] args) {
        토마토 main = new 토마토();
        Scanner sc = new Scanner(System.in);

        m = sc.nextInt();
        n = sc.nextInt();

        board = new int[n][m];
        distance = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] = sc.nextInt();
                if (board[i][j] == 1) {
                    queue.offer(new Point(i, j));
                }
            }
        }

        main.bfs();
        main.find();
    }

    private static class Point {
        public int x, y;

        public Point(final int x, final int y) {
            this.x = x;
            this.y = y;
        }
    }
}
