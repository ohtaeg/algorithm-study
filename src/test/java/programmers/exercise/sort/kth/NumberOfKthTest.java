package programmers.exercise.sort.kth;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NumberOfKthTest {
    private NumberOfKth kth = new NumberOfKth();

    @Test
    void test1() {
        final int[] array = {1, 5, 2, 6, 3, 7, 4};
        final int[][] commands = {
                {2, 5, 3}
                , {4, 4, 1}
                , {1, 7, 3}
        };
        final int[] expect = {5, 6, 3};

        final int[] actual = kth.solution(array, commands);

        assertThat(actual).containsExactly(expect);
    }

}
