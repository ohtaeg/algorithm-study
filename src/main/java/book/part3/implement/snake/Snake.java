package book.part3.implement.snake;

import java.util.ArrayDeque;
import java.util.Deque;

public class Snake {
    private static final boolean CONFLICT = Boolean.TRUE;

    private Position head;
    private Deque<Position> bodies;

    public Snake(final Position head) {
        this.head = head;
        this.bodies = new ArrayDeque<>();
    }

    public void move(final int x, final int y) {
        int beforeX = head.getX();
        int beforeY = head.getY();
        head.move(x + head.getX(), y + head.getY());
        for (Position body : bodies) {
            int bodyX = body.getX();
            int bodyY = body.getY();

            body.move(beforeX, beforeY);

            beforeX = bodyX;
            beforeY = bodyY;
        }
    }

    public boolean isConflictWall(final int size) {
        int x = head.getX();
        int y = head.getY();
        return x >= size || x < 0 || y >= size || y < 0;
    }

    public boolean isConflictBody(final int tailX, final int tailY) {
        if (tailX == head.getX() && tailY == head.getY()) {
            return CONFLICT;
        }

        for (Position body : bodies) {
            if (body.equals(head)) {
                return CONFLICT;
            }
        }
        return !CONFLICT;
    }

    public boolean hasEatApple(final int[][] map) {
        return map[head.getX()][head.getY()] == 1;
    }

    public void eatApple(final int x, final int y, final int[][] map) {
        map[head.getX()][head.getY()] = 0;
        bodies.offer(new Position(x, y));
    }

    public int getTailX() {
        if (bodies.isEmpty()) {
            return head.getX();
        }
        return bodies.getLast()
                     .getX();

    }

    public int getTailY() {
        if (bodies.isEmpty()) {
            return head.getY();
        }
        return bodies.getLast()
                     .getY();
    }
}
