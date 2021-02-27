package programmers.exercise.hash.bestalbum;

class GenreSpec implements Comparable<GenreSpec> {
    private int index;
    private int playCount;

    public GenreSpec(final int index, final int playCount) {
        this.index = index;
        this.playCount = playCount;
    }

    public int getIndex() {
        return index;
    }

    public int getPlayCount() {
        return playCount;
    }

    @Override
    public int compareTo(final GenreSpec o) {
        if (o.getPlayCount() == this.getPlayCount()) {
            return this.getIndex() - o.getIndex();
        }
        return o.getPlayCount() - this.getPlayCount();
    }
}
