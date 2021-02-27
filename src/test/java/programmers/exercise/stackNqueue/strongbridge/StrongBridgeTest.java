package programmers.exercise.stackNqueue.strongbridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StrongBridgeTest {

    StrongBridge strongBridge = new StrongBridge();

    @DisplayName("케이스 1")
    @Test
    void case1() {
        // given
        final int bridgeLength = 2;
        final int bridgeWeight = 10;
        final int[] truckWeights = {7, 4, 5, 6};
        final int expect = 8;

        // when
        int actual = strongBridge.moveTrucks(bridgeLength, bridgeWeight, truckWeights);


        assertThat(actual).isEqualTo(expect);
    }

    @DisplayName("케이스 2")
    @Test
    void case2() {
        // given
        final int bridgeLength = 100;
        final int bridgeWeight = 100;
        final int[] truckWeights = {10};
        final int expect = 101;

        // when
        int actual = strongBridge.moveTrucks(bridgeLength, bridgeWeight, truckWeights);

        // then
        assertThat(actual).isEqualTo(expect);
    }

    @DisplayName("케이스 3")
    @Test
    void case3() {
        // given
        final int bridgeLength = 100;
        final int bridgeWeight = 100;
        final int[] truckWeights = {10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
        final int expect = 110;

        // when
        int actual = strongBridge.moveTrucks(bridgeLength, bridgeWeight, truckWeights);

        // then
        assertThat(actual).isEqualTo(expect);
    }
}
