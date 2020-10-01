package boj.bruteforce.tetromino;

import java.util.Scanner;

/**
 * 테트로미노
 * 다섯개의 테트로미노를 정의한다.
 * ex) 직사각형일때 ----
 * i, j 부터 시작한다고 하면 i,j 기준으로 (i, j), (i, j + 1), (i, j + 2), (i, j + 3)
 *                                 (i, j), (i + 1, j), (i + 2, j), (i + 3, j)
 * 좌표 배열을 미리 만들어 i, j 기준으로 시작할때 특정 도형이 위치할 수 있는지 체크해주는 방식으로 구현함.
 * dfs 로 풀 수 있다는데, dfs 공부하고 도전해볼것
 */
public class Q14500 {
    private static final Point[][] SHAPES = new Point[][] {
            // long
            { new Point(0, 1), new Point(0, 2), new Point(0, 3) }
          , { new Point(1, 0), new Point(2, 0), new Point(3, 0) }

            // square
          , { new Point(0, 1), new Point(1, 0), new Point(1, 1) }

            // ㄴ
          , { new Point(1, 0), new Point(2, 0), new Point(2, 1) }
          , { new Point(0, 1), new Point(1, 1), new Point(2, 1) }
          , { new Point(0, 1), new Point(-1, 1), new Point(-2, 1) }
          , { new Point(0, 1), new Point(1, 0), new Point(2, 0) }

          , { new Point(0, 1), new Point(0, 2), new Point(1, 2) }
          , { new Point(0, 1), new Point(0, 2), new Point(1, 0) }
          , { new Point(1, 0), new Point(1, 1), new Point(1, 2) }
          , { new Point(0, 1), new Point(0, 2), new Point(-1, 2) }

            // 번개
          , { new Point(0, 1), new Point(1, 0), new Point(-1, 1) }
          , { new Point(0, 1), new Point(1, 1), new Point(1, 2) }
          , { new Point(1, 0), new Point(1, 1), new Point(2, 1) }
          , { new Point(0, 1), new Point(-1, 1), new Point(-1, 2) }

             // T
          , { new Point(0, 1), new Point(0, 2), new Point(1, 1) }
          , { new Point(0, 1), new Point(1, 1), new Point(-1, 1) }
          , { new Point(0, 1), new Point(0, 2), new Point(-1, 1) }
          , { new Point(1, 0), new Point(1, 1), new Point(2, 0) }
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int height = scanner.nextInt();
        final int width = scanner.nextInt();
        final int[][] numbers = new int[height][width];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                numbers[i][j] = scanner.nextInt();
            }
        }

        int sum = sumPoint(numbers, height, width);
        System.out.println(sum);
    }

    private static int sumPoint(final int[][] numbers, final int height, final int width) {
        int max = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {

                for (int k = 0; k < SHAPES.length; k++) {
                    int sum = numbers[i][j];
                    for (int l = 0; l < SHAPES[k].length; l++) {
                        int x = i + SHAPES[k][l].getX();
                        int y = j + SHAPES[k][l].getY();
                        if (isOver(x, y, height, width)) {
                            sum = 0;
                            break;
                        } else {
                            sum += numbers[x][y];
                        }
                    }
                    max = Integer.max(max, sum);
                }

            }
        }
        return max;
    }

    private static boolean isOver(final int x, final int y, final int height, final int width) {
        return isOverHeight(x, height) || isOverWidth(y, width);
    }

    private static boolean isOverHeight(final int x, final int height) {
        return x < 0 || x >= height;
    }

    private static boolean isOverWidth(final int y, final int width) {
        return y < 0 || y >= width;
    }
}

