package programmers.level2.strongbridge;

import java.util.LinkedList;
import java.util.Queue;

public class Trucks {
    private Queue<Truck> trucks;

    public Trucks() {
        this.trucks = new LinkedList<>();
    }
    public Trucks(final Queue<Truck> trucks) {
        this.trucks = trucks;
    }

    public boolean isEmpty() {
        return trucks.isEmpty();
    }

    public boolean isPossibleOutOfBridge() {
        return !trucks.isEmpty() && trucks.peek().getDistance() <= 0;
    }

    public int getWeightSum() {
        return trucks.stream()
                     .mapToInt(Truck::getWeight)
                     .sum();
    }

    public Truck getFirst() {
        return trucks.peek();
    }

    public void moveForward() {
        trucks.stream().forEach(Truck::move);
    }

    public void getOutBridge() {
        trucks.poll();
    }

    public void getIntoBridge(final Truck truck) {
        trucks.offer(truck);
    }

    public Truck shift() {
        return trucks.poll();
    }
}
