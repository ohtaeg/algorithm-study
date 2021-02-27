package programmers.exercise.greedy.joystick;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    private Solution solution = new Solution();

    @Test
    void solve1() {
        // given
        final String name = "JAN";
        final int expect = 23;

        // when
        final int actual = solution.solution(name);

        // then
        assertThat(actual).isEqualTo(expect);
    }

    @Test
    void solve2() {
        // given
        final String name = "JEROEN";
        final int expect = 56;

        // when
        final int actual = solution.solution(name);

        // then
        assertThat(actual).isEqualTo(expect);
    }

    @Test
    void solve3() {
        // given
        final String name = "JAZ";
        final int expect = 11;

        // when
        final int actual = solution.solution(name);

        // then
        assertThat(actual).isEqualTo(expect);
    }
}
