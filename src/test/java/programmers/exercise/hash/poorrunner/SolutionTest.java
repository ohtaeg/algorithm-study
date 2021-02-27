package programmers.exercise.hash.poorrunner;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {
    private Solution solution = new Solution();

    @Test
    void case1() {
        String[] participant = {"mislav", "stanko", "mislav", "ana"};
        String[] completion = {"mislav", "stanko", "ana"};
        String expect = "mislav";

        String actual = solution.solution(participant, completion);

        assertThat(expect).isEqualTo(actual);
    }

    @Test
    void case2() {
        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"kiki", "eden"};
        String expect = "leo";

        String actual = solution.solution(participant, completion);

        assertThat(expect).isEqualTo(actual);
    }

    @Test
    void case3() {
        String[] participant = {"marina", "josipa", "nikola", "vinko", "filipa"};
        String[] completion = {"marina", "josipa", "nikola", "filipa"};
        String expect = "vinko";

        String actual = solution.solution(participant, completion);

        assertThat(expect).isEqualTo(actual);
    }
}
