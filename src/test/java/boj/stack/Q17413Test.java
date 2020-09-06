package boj.stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class Q17413Test {
    StringBuilder result;

    @BeforeEach
    void setUp() {
        result = new StringBuilder();
    }

    @ParameterizedTest
    @MethodSource("provideCase")
    void test(String source, String expect) {
        final String actual = Q17413.reverse(source, result);

        assertThat(actual).isEqualTo(expect);
    }

    private static Stream<Arguments> provideCase() {
        return Stream.of(
                Arguments.of("baekjoon online judge", "noojkeab enilno egduj"),
                Arguments.of("<open>tag<close>", "<open>gat<close>"),
                Arguments.of("<ab cd>ef gh<ij kl>", "<ab cd>fe hg<ij kl>"),
                Arguments.of("one1 two2 three3 4fourr 5five 6six", "1eno 2owt 3eerht rruof4 evif5 xis6"),
                Arguments.of("<int><max>2147483647<long long><max>9223372036854775807", "<int><max>7463847412<long long><max>7085774586302733229"),
                Arguments.of("<problem>17413<is hardest>problem ever<end>", "<problem>31471<is hardest>melborp reve<end>"),
                Arguments.of("<   space   >space space space<    spa   c e>", "<   space   >ecaps ecaps ecaps<    spa   c e>")
        );
    }
}
