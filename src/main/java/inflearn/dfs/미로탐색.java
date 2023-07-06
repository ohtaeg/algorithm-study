package inflearn.dfs;

import java.util.Scanner;

/**
 * https://cote.inflearn.com/contest/10/problem/08-10
 *
 * 지나왔던 길은 다 벽으로 만들어버린다.
 * 재귀가 끝나면 다시 통로로 만들어준다.
 */
public class 미로탐색 {
    private static final int[][] DIRECTION = {
            new int[]{-1, 0} // 북 0
            , new int[]{0, 1} // 동 1
            , new int[]{1, 0} // 남 2
            , new int[]{0, -1} // 서 3
    };
    static int answer;
    static int[][] board;

    private void dfs(final int x, final int y) {
        // 종착점에 도착하면
        if (x == 7 && y == 7) {
            answer++;
        } else {
            // 방향젼환
            for (int i = 0; i < 4; i++) {
                int nx = x + DIRECTION[i][0];
                int ny = y + DIRECTION[i][1];
                // 경계선 안쪽인지 그리고 통로인지
                if (nx >= 1 && nx <= 7 && ny >= 1 && ny <= 7 && board[nx][ny] == 0) {
                    // 이동 후 다시 원복
                    board[nx][ny] = 1;
                    dfs(nx, ny);
                    board[nx][ny] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        미로탐색 main = new 미로탐색();
        Scanner sc = new Scanner(System.in);

        board = new int[8][8];
        for (int i = 1; i <= 7; i++) {
            for (int j = 1; j <= 7; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        board[1][1] = 1;
        main.dfs(1, 1);
        System.out.println(answer);
    }

}

