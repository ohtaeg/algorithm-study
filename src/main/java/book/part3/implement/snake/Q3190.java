package book.part3.implement.snake;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q3190 {
    private static final int[][] DIRECTION = {
            new int[]{-1, 0} // 북 0
            , new int[]{0, 1} // 동 1
            , new int[]{1, 0} // 남 2
            , new int[]{0, -1} // 서 3
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int n = scanner.nextInt();
        final int[][] map = new int[n][n];
        final int k = scanner.nextInt();
        for (int i = 0; i < k; i++) {
            map[scanner.nextInt() - 1][scanner.nextInt() - 1] = 1;
        }

        Queue<Rotation> rotations = new LinkedList<>();
        final int rotateCount = scanner.nextInt();

        for (int i = 0; i < rotateCount; i++) {
            rotations.offer(new Rotation(scanner.nextInt(), scanner.next()));
        }

        final int result = startGame(map, rotations);
        System.out.println(result);
    }

    private static int startGame(final int[][] map, final Queue<Rotation> rotations) {
        int tailX = 0;
        int tailY = 0;
        final Snake snake = new Snake(new Position(tailX, tailY));
        final int mapSize = map.length;
        int time = 0;
        int directionIndex = 1;

        while (true) {
            // 회전할 시간이라면
            if (!rotations.isEmpty()) {
                final Rotation rotation = rotations.peek();
                if (rotation.isSameTime(time)) {
                    directionIndex = rotation.getDirection(directionIndex);
                    rotations.poll();
                }
            }

            time++;
            tailX = snake.getTailX();
            tailY = snake.getTailY();
            snake.move(DIRECTION[directionIndex][0], DIRECTION[directionIndex][1]);

            // 꼬리와 부딪치거나 몸통과 부딪친다면
            if (snake.isConflictBody(tailX, tailY)) {
                return time;
            }

            // 벽과 부딪친다면
            if (snake.isConflictWall(mapSize)) {
                return time;
            }

            // 이동할 방향에 사과가 있다면
            if (snake.hasEatApple(map)) {
                snake.eatApple(tailX, tailY, map);
            }
        }
    }
}
