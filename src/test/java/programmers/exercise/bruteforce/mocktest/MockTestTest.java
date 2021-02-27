package programmers.exercise.bruteforce.mocktest;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MockTestTest {
    private MockTest solution = new MockTest();

    @Test
    void test1() {
        final int[] answers = {1, 2, 3, 4, 5};
        final int[] expect = {1};

        final int[] actual = solution.solution(answers);

        assertThat(actual).containsExactly(expect);
    }

    @Test
    void test2() {
        final int[] answers = {1, 3, 2, 4, 2};
        final int[] expect = {1, 2, 3};

        final int[] actual = solution.solution(answers);

        assertThat(actual).containsExactly(expect);
    }

}
