package inflearn.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * https://cote.inflearn.com/contest/10/problem/08-13
 */
public class 섬나라 {

    private static final int[][] DIRECTION = {
            new int[]{-1, 0} // 북 0
            , new int[]{-1, 1} // 북동 대각선 1
            , new int[]{0, 1} // 동 2
            , new int[]{1, 1} // 남동 대각선 3
            , new int[]{1, 0} // 남 4
            , new int[]{1, -1} // 남서 대각선 5
            , new int[]{0, -1} // 서 6
            , new int[]{-1, -1} // 북서 대각선 7
    };
    private static int n, answer;
    private static Queue<Point> queue = new LinkedList<>();

    private int solution(int[][] island) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (island[i][j] == 1) {
                    answer++;
                    island[i][j] = 0;
                    bfs(island, i, j);
                }
            }
        }
        return answer;
    }

    private void bfs(final int[][] island, final int x, final int y) {
        queue.offer(new Point(x, y));

        while (!queue.isEmpty()) {
            Point current = queue.poll();

            for (int i = 0; i < DIRECTION.length; i++) {
                int nx = current.x + DIRECTION[i][0];
                int ny = current.y + DIRECTION[i][1];

                if (nx >= 0 && nx < n && ny >= 0 && ny < n && island[nx][ny] == 1) {
                    island[nx][ny] = 0;
                    queue.offer(new Point(nx, ny));
                }
            }
        }

    }

    public static void main(String[] args) {
        섬나라 main = new 섬나라();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        int[][] island = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                island[i][j] = sc.nextInt();
            }
        }
        System.out.println(main.solution(island));
    }

    private static class Point {
        public int x, y;

        public Point(final int x, final int y) {
            this.x = x;
            this.y = y;
        }
    }
}
