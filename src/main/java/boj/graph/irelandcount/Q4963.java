package boj.graph.irelandcount;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * 섬의 갯수
 *
 * 1. 8가지 방향을 미리 정의
 * 2. 각 노드마다 이동할 수 있는 인접노드들을 구한다.
 * 3. (0, 0) 부터 섬이면서 방문하지 않은 좌표라면 dfs를 통해 방문 처리후 카운트 증가
 */
public class Q4963 {
    private static final int[][] DIRECTIONS = {
            {-1, 0}    // 0, 북
            , {-1, 1}  // 1, 북동
            , {0, 1}   // 2, 동
            , {1, 1}   // 3, 남동
            , {1, 0}   // 4, 남
            , {1, -1}  // 5. 남서
            , {0, -1}  // 6. 서
            , {-1, -1} // 7. 북서
    };

    private static final int IRELAND = 1;
    private static final int END = 0;

    private static List<Position>[][] graph;
    private static boolean[][] isVisit;
    private static int[][] map;
    private static int w;
    private static int h;

    public static void main(String[] args) {
        StringBuilder result = new StringBuilder();
        Scanner scanner = new Scanner(System.in);

        while ((w = scanner.nextInt()) != END && (h = scanner.nextInt()) != END) {
            map = new int[h][w];
            isVisit = new boolean[h][w];

            for (int height = 0; height < h; height++) {
                for (int width = 0; width < w; width++) {
                    map[height][width] = scanner.nextInt();
                }
            }
            result.append(getCount(w, h) + System.lineSeparator());
        }
        System.out.println(result.toString());

    }

    private static int getCount(final int w, final int h) {
        initGraph(w, h);

        int count = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (isIreLand(i, j)) {
                    dfs(i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private static void initGraph(final int w, final int h) {
        graph = new List[h][w];

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                graph[i][j] = new LinkedList<>();
                getNestedIreland(i, j);
            }
        }
    }

    private static void getNestedIreland(final int y, final int x) {
        for (int index = 0; index < DIRECTIONS.length; index++) {
            if (!isOver(index, y, x)) {
                graph[y][x].add(new Position(DIRECTIONS[index][0] + y, DIRECTIONS[index][1] + x));
            }
        }
    }

    private static boolean isOver(final int index, int y, int x) {
        y = DIRECTIONS[index][0] + y;
        x = DIRECTIONS[index][1] + x;
        return y < 0 || y >= h || x < 0 || x >= w;
    }

    private static boolean isIreLand(final int y, final int x) {
        return map[y][x] == IRELAND && !isVisit[y][x];
    }

    private static void dfs(final int y, final int x) {
        isVisit[y][x] = true;

        for (Position nestedIreland : graph[y][x]) {
            int nestedY = nestedIreland.getY();
            int nestedX = nestedIreland.getX();
            if (isIreLand(nestedY, nestedX)) {
                dfs(nestedY, nestedX);
            }
        }
    }
}
