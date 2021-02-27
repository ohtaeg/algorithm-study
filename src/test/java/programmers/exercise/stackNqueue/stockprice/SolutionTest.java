package programmers.exercise.stackNqueue.stockprice;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {
    private Solution solution = new Solution();

    @Test
    void case1() {
        int[] prices = {1, 2, 3, 2, 3};
        int[] expect = {4, 3, 1, 1, 0};
        int[] actual = solution.calculate(prices);

        assertThat(expect).containsExactly(actual);
    }

    @Test
    void case2() {
        int[] prices = {4, 3, 2, 1, 0};
        int[] expect = {1, 1, 1, 1, 0};
        int[] actual = solution.calculate(prices);

        assertThat(expect).containsExactly(actual);
    }
}
