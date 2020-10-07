package book.part3.implement.snake;

public class Rotation {
    private final int time;
    private final String direction;

    public Rotation(final int time, final String direction) {
        this.time = time;
        this.direction = direction;
    }

    public boolean isSameTime(final int time) {
        return this.time == time;
    }

    public int getDirection(int currentDirection) {
        if ("D".equals(direction)) {
            if (currentDirection == 3) {
                return 0;
            } else {
                return currentDirection + 1;
            }
        } else {
            if (currentDirection == 0) {
                return 3;
            } else {
                return currentDirection - 1;
            }
        }
    }
}
