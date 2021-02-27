package programmers.exercise.hash.spy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    private Solution solution = new Solution();
    @Test
    void case1() {
        int actual = 5;
        String[][] clothes = {
                {"yellow_hat", "headgear"}
                , {"blue_sunglasses", "eyewear"}
                , {"green_turban", "headgear"}
        };

        int expect = solution.solution(clothes);

        assertThat(expect).isEqualTo(actual);
    }

    @Test
    void case2() {
        int actual = 3;
        String[][] clothes = {
                {"crow_mask", "face"}
                , {"blue_sunglasses", "face"}
                , {"smoky_makeup", "face"}
        };

        int expect = solution.solution(clothes);

        assertThat(expect).isEqualTo(actual);
    }
}
