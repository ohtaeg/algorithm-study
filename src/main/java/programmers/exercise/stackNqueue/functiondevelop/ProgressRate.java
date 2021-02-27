package programmers.exercise.stackNqueue.functiondevelop;

import java.util.Objects;

class ProgressRate {
    private int rate;
    private int speed;

    public ProgressRate(final int rate, final int speed) {
        this.rate = rate;
        this.speed = speed;
    }

    public int getRate() {
        return rate;
    }

    public void up() {
        rate += speed;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final ProgressRate that = (ProgressRate) o;
        return rate == that.rate &&
                speed == that.speed;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rate, speed);
    }
}
