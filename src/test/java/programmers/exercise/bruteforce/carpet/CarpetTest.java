package programmers.exercise.bruteforce.carpet;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarpetTest {
    private Carpet carpet = new Carpet();

    @Test
    void test1() {
        final int brown = 8;
        final int yellow = 1;
        final int[] expect = {3, 3};

        final int[] actual = carpet.solution(brown, yellow);

        assertThat(actual).containsExactly(expect);
    }

    @Test
    void test2() {
        final int brown = 10;
        final int yellow = 2;
        final int[] expect = {4, 3};

        final int[] actual = carpet.solution(brown, yellow);

        assertThat(actual).containsExactly(expect);
    }

    @Test
    void test3() {
        final int brown = 24;
        final int yellow = 24;
        final int[] expect = {8, 6};

        final int[] actual = carpet.solution(brown, yellow);

        assertThat(actual).containsExactly(expect);
    }
}
