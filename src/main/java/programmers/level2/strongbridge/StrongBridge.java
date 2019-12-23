package programmers.level2.strongbridge;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;

class StrongBridge extends Solution {
    @Override
    public int solution(final int bridge_length, final int weight, final int[] truck_weights) {
        return moveTrucks(bridge_length, weight, truck_weights);
    }

    public int moveTrucks(final int bridgeLength, final int bridgeWeight, final int[] truckWeights) {
        Trucks waitingTrucks = new Trucks(createTrucks(truckWeights, bridgeLength));
        Trucks onBridgeTrucks = new Trucks();
        Truck truck = null;
        int time = 0;

        while( !(waitingTrucks.isEmpty() && onBridgeTrucks.isEmpty()) ) {
            time++;

            if (onBridgeTrucks.isPossibleOutOfBridge()) {
                onBridgeTrucks.getOutBridge();
            }

            if (!waitingTrucks.isEmpty() &&
                    !this.isOverLoad(bridgeWeight, onBridgeTrucks.getWeightSum() + waitingTrucks.getFirst().getWeight())) {
                // 대기열에서 벗어나고 다리위로 이동
                truck = waitingTrucks.shift();
                onBridgeTrucks.getIntoBridge(truck);
            }

            //다리위 트럭들 전체 한칸씩 이동
            onBridgeTrucks.moveForward();
        }
        return time;
    }

    private Queue<Truck> createTrucks(final int[] truckWeights, final int bridgeLength) {
        return Arrays.stream(truckWeights)
                     .mapToObj((weight) -> new Truck(weight, bridgeLength))
                     .collect(Collectors.toCollection(LinkedList::new));
    }

    private boolean isOverLoad(final int bridgeWeight, final int truckWeightSum) {
        return truckWeightSum > bridgeWeight;
    }
}
