package programmers.level3.bestalbum;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    private Solution solution = new Solution();
    @Test
    void solution() {
        int[] expect = {4, 1, 3, 0};
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};

        int[] actual = solution.solution(genres, plays);

        assertThat(actual).containsExactly(expect);
    }
}