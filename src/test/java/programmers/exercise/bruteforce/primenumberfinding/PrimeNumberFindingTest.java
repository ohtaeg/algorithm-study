package programmers.exercise.bruteforce.primenumberfinding;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PrimeNumberFindingTest {
    private PrimeNumberFinding solution = new PrimeNumberFinding();

    @Test
    void test1() {
        final String numbers = "17";
        final int expect = 3;

        final int actual = solution.solution(numbers);

        assertThat(actual).isEqualTo(expect);
    }

    @Test
    void test2() {
        final String numbers = "011";
        final int expect = 2;

        final int actual = solution.solution(numbers);

        assertThat(actual).isEqualTo(expect);
    }
}
