package hackerrank.implementation;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TheTimeInWordsTest {

    @Test
    void test1() {
        final int h = 5;
        final int m = 47;
        final String expect = "thirteen minutes to six";

        final String actual = TheTimeInWords.timeInWords(h, m);

        assertThat(actual).isEqualTo(expect);
    }

    @Test
    void test2() {
        final int h = 10;
        final int m = 57;
        final String expect = "three minutes to eleven";

        final String actual = TheTimeInWords.timeInWords(h, m);

        assertThat(actual).isEqualTo(expect);
    }

}
