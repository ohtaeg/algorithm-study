package book.part3.implement.chickendelivery;

public class Position {
    private final int x;
    private final int y;

    public Position(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getDiff(final Position chicken) {
        return Math.abs(this.x - chicken.x) + Math.abs(this.y - chicken.y);
    }
}
