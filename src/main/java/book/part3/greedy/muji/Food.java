package book.part3.greedy.muji;

public class Food implements Comparable<Food> {
    private final int index;
    private int time;

    public Food(int index, int time) {
        this.index = index;
        this.time = time;
    }

    public long getGap(final int previousTime) {
        return this.time - previousTime;
    }

    public int getIndex() {
        return index;
    }

    public int getTime() {
        return time;
    }

    @Override
    public int compareTo(final Food o) {
        return Integer.compare(time, o.time);
    }
}
