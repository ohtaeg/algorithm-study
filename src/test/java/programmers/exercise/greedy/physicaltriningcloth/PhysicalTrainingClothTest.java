package programmers.exercise.greedy.physicaltriningcloth;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PhysicalTrainingClothTest {

    private PhysicalTrainingCloth solution = new PhysicalTrainingCloth();

    @Test
    void solution1() {
        // given
        int n = 5;
        int[] lost = {2, 4};
        int[] reverse = {1, 3, 5};
        int expect = 5;

        // when
        final int actual = this.solution.solution(n, lost, reverse);

        // then
        assertThat(actual).isEqualTo(expect);
    }

    @Test
    void solution2() {
        // given
        int n = 5;
        int[] lost = {2, 4};
        int[] reverse = {3};
        int expect = 4;

        // when
        final int actual = this.solution.solution(n, lost, reverse);

        // then
        assertThat(actual).isEqualTo(expect);
    }

    @Test
    void solution3() {
        // given
        int n = 3;
        int[] lost = {3};
        int[] reverse = {1};
        int expect = 2;

        // when
        final int actual = this.solution.solution(n, lost, reverse);

        // then
        assertThat(actual).isEqualTo(expect);
    }

    @Test
    void solution4() {
        // given
        int n = 3;
        int[] lost = {1, 2};
        int[] reverse = {2, 3};
        int expect = 2;

        // when
        final int actual = this.solution.solution(n, lost, reverse);

        // then
        assertThat(actual).isEqualTo(expect);
    }

}
