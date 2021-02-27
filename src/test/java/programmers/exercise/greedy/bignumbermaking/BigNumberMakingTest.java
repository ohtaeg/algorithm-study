package programmers.exercise.greedy.bignumbermaking;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BigNumberMakingTest {
    private BigNumberMaking making = new BigNumberMaking();

    @Test
    void test1() {
        final String number = "1924";
        final int k = 2;
        final String expect = "94";

        final String actual = making.solution(number, k);

        assertThat(actual).isEqualTo(expect);
    }

    @Test
    void test2() {
        final String number = "1231234";
        final int k = 3;
        final String expect = "3234";

        final String actual = making.solution(number, k);

        assertThat(actual).isEqualTo(expect);
    }

    @Test
    void test3() {
        final String number = "1924";
        final int k = 2;
        final String expect = "94";

        final String actual = making.solution(number, k);

        assertThat(actual).isEqualTo(expect);
    }

    @Test
    void test4() {
        final String number = "91";
        final int k = 1;
        final String expect = "9";

        final String actual = making.solution(number, k);

        assertThat(actual).isEqualTo(expect);
    }
}
