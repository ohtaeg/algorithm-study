package book.part2.implement.gamedevelopment;

class Character {
    private static final int[][] DIRECTION = {
            new int[]{-1, 0} // 북
            , new int[]{0, 1} // 동
            , new int[]{1, 0} // 남
            , new int[]{0, -1} // 서
    };
    private static final int DEFAULT_MOVE_COUNT = 1;

    private int x;
    private int y;
    private int direction;
    private int turnCount;
    private int moveCount;

    public Character(final int x, final int y, final int direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.moveCount = DEFAULT_MOVE_COUNT;
        this.turnCount = 0;
    }

    public void turnLeft() {
        this.turnCount += 1;

        int turnResult = direction - 1;
        if (turnResult < 0) {
            this.direction = 3;
            return;
        }
        this.direction = turnResult;
    }

    public boolean canMoveForward(final int[][] map) {
        int moveX = this.x + DIRECTION[this.direction][0];
        int moveY = this.y + DIRECTION[this.direction][1];

        if (map[moveX][moveY] == 1) {
            return false;
        }

        return true;
    }

    public void moveForward() {
        this.x += DIRECTION[this.direction][0];
        this.y += DIRECTION[this.direction][1];
        incrementMoveCount();
        initTurnCount();
    }

    public boolean canMoveBack(final int[][] map) {
        int moveX = this.x - DIRECTION[this.direction][0];
        int moveY = this.y - DIRECTION[this.direction][1];

        if (map[moveX][moveY] == 1) {
            return false;
        }

        return true;
    }

    public void moveBack() {
        this.x -= DIRECTION[this.direction][0];
        this.y -= DIRECTION[this.direction][1];
        incrementMoveCount();
        initTurnCount();
    }

    public boolean isTurnFullCircle() {
        return turnCount > 4;
    }

    private void incrementMoveCount() {
        this.moveCount += DEFAULT_MOVE_COUNT;
    }

    private void initTurnCount() {
        this.turnCount = 0;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getMoveCount() {
        return moveCount;
    }
}
