package programmers.exercise.greedy.lifeboat;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LifeBoatTest {
    private LifeBoat boat = new LifeBoat();

    @Test
    void test1() {
        final int[] people = {70, 50, 80, 50};
        final int limit = 100;
        final int expect = 3;

        final int actual = boat.solution(people, limit);

        assertThat(actual).isEqualTo(expect);
    }

    @Test
    void test2() {
        final int[] people = {70, 80, 50};
        final int limit = 100;
        final int expect = 3;

        final int actual = boat.solution(people, limit);

        assertThat(actual).isEqualTo(expect);
    }

    @Test
    void test3() {
        final int[] people = {160, 150, 140, 60, 50, 40};
        final int limit = 200;
        final int expect = 3;

        final int actual = boat.solution(people, limit);

        assertThat(actual).isEqualTo(expect);
    }

    @Test
    void test4() {
        final int[] people = {40, 50, 50, 60};
        final int limit = 100;
        final int expect = 2;

        final int actual = boat.solution(people, limit);

        assertThat(actual).isEqualTo(expect);
    }

}
