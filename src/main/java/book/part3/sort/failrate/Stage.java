package book.part3.sort.failrate;

class Stage implements Comparable<Stage> {
    private final int stageIndex;
    private final double failPercent;

    public Stage(final int stageIndex, final double failPercent) {
        this.stageIndex = stageIndex;
        this.failPercent = failPercent;
    }

    public int getStageIndex() {
        return stageIndex;
    }

    @Override
    public int compareTo(final Stage o) {
        if (this.failPercent != o.failPercent) {
            return Double.compare(o.failPercent, this.failPercent);
        }
        return Integer.compare(stageIndex, o.stageIndex);
    }
}
