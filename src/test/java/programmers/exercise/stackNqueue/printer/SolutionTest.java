package programmers.exercise.stackNqueue.printer;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class SolutionTest {
    private Solution solution = new Solution();

    @DisplayName("케이스 1")
    @Test
    void case1() {
        // given
        int[] priorities = {2, 1, 3, 2};
        int location = 2;
        int expect = 1;

        // when
        int actual = solution.print(priorities, location);

        // then
        assertThat(actual).isEqualTo(expect);
    }

    @DisplayName("케이스 2")
    @Test
    void case2() {
        // given
        int[] priorities = {1, 1, 9, 1, 1, 1};
        int location = 0;
        int expect = 5;

        // when
        int actual = solution.print(priorities, location);

        // then
        assertThat(actual).isEqualTo(expect);
    }
}
