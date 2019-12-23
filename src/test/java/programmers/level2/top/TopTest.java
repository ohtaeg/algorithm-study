package programmers.level2.top;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class TopTest {

    private Top top = new Top();

    @DisplayName("케이스 1")
    @Test
    void case1() {
        // given
        int[] heights = {6, 9, 5, 7, 4};
        int heightsSize = heights.length;
        int[] actual = {0, 0, 2, 2, 4};


        // when then
        assertAll(
               () -> assertThat(top.recept(heights, heightsSize - 5)).isEqualTo(actual[0])
               ,() -> assertThat(top.recept(heights,heightsSize - 4)).isEqualTo(actual[1])
               ,() -> assertThat(top.recept(heights,heightsSize - 3)).isEqualTo(actual[2])
               ,() -> assertThat(top.recept(heights,heightsSize - 2)).isEqualTo(actual[3])
               ,() -> assertThat(top.recept(heights,heightsSize - 1)).isEqualTo(actual[4])
               ,() ->  assertThat(top.solution(heights)).containsExactly(actual)
        );
    }

    @DisplayName("케이스 2")
    @Test
    void case2() {
        // given
        int[] heights = {3, 9, 9, 3, 5, 7, 2};
        int heightsSize = heights.length;
        int[] actual = {0, 0, 0, 3, 3, 3, 6};


        // when then
        assertAll(
                () -> assertThat(top.recept(heights,  heightsSize - 7)).isEqualTo(actual[0])
                ,() -> assertThat(top.recept(heights, heightsSize - 6)).isEqualTo(actual[1])
                ,() -> assertThat(top.recept(heights, heightsSize - 5)).isEqualTo(actual[2])
                ,() -> assertThat(top.recept(heights, heightsSize - 4)).isEqualTo(actual[3])
                ,() -> assertThat(top.recept(heights, heightsSize - 3)).isEqualTo(actual[4])
                ,() -> assertThat(top.recept(heights, heightsSize - 2)).isEqualTo(actual[5])
                ,() -> assertThat(top.recept(heights, heightsSize - 1)).isEqualTo(actual[6])
                ,() ->  assertThat(top.solution(heights)).containsExactly(actual)
        );
    }

    @DisplayName("케이스 3")
    @Test
    void case3() {
        // given
        int[] heights = {1, 5, 3, 6, 7, 6, 5};
        int heightsSize = heights.length;
        int[] actual = {0, 0, 2, 0, 0, 5, 6};

        // when then
        assertAll(
                () -> assertThat(top.recept(heights,  heightsSize - 7)).isEqualTo(actual[0])
                ,() -> assertThat(top.recept(heights, heightsSize - 6)).isEqualTo(actual[1])
                ,() -> assertThat(top.recept(heights, heightsSize - 5)).isEqualTo(actual[2])
                ,() -> assertThat(top.recept(heights, heightsSize - 4)).isEqualTo(actual[3])
                ,() -> assertThat(top.recept(heights, heightsSize - 3)).isEqualTo(actual[4])
                ,() -> assertThat(top.recept(heights, heightsSize - 2)).isEqualTo(actual[5])
                ,() -> assertThat(top.recept(heights, heightsSize - 1)).isEqualTo(actual[6])
                ,() ->  assertThat(top.solution(heights)).containsExactly(actual)
        );
    }

}