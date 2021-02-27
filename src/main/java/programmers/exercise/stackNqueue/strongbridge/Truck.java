package programmers.exercise.stackNqueue.strongbridge;

public class Truck {
    private int weight;
    private int distance;

    public Truck(final int weight, final int distance) {
        this.weight = weight;
        this.distance = distance;
    }

    public void move() {
        this.distance--;
    }

    public int getWeight() {
        return weight;
    }

    public int getDistance() {
        return distance;
    }
}
