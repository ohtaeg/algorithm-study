package programmers.level2.ironbar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

class SolutionTest {

    Solution solution = new Solution();

    @DisplayName("케이스 1")
    @Test
    void case1() {
        final String arrangement = "()(((()())(())()))(())";
        int expect = 17;
        int actual = 0;

        actual = solution.solution(arrangement);

        assertThat(actual).isEqualTo(expect);
    }

    @DisplayName("케이스 2")
    @Test
    void case2() {
        final String arrangement = "(()()())";
        int expect = 4;
        int actual = 0;

        actual = solution.solution(arrangement);

        assertThat(actual).isEqualTo(expect);
    }
}