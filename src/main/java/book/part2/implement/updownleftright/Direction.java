package book.part2.implement.updownleftright;

import java.util.Arrays;

/**
 * if문 리팩토링
 */
enum Direction {
    LEFT("L", 0, -1), RIGHT("R", 0, 1), UP("U", -1, 0), DOWN("D", 1, 0);

    private final String symbol;
    private final int x;
    private final int y;

    Direction(final String symbol, final int x, final int y) {
        this.symbol = symbol;
        this.x = x;
        this.y = y;
    }

    public static Direction of(String command) {
        return Arrays.stream(values())
                     .filter(direction -> direction.symbol.equals(command))
                     .findFirst()
                     .orElseThrow(IllegalArgumentException::new);
    }

    public Point move(final Point point, final int n) {
        int moveX = point.getX() + this.x;
        int moveY = point.getY() + this.y;

        if (isOver(moveX, n)) {
            moveX = point.getX();
        }

        if (isOver(moveY, n)) {
            moveY = point.getY();
        }

        return new Point(moveX, moveY);
    }

    private boolean isOver(final int point, final int n) {
        return point < 1 || point > n;
    }
}
