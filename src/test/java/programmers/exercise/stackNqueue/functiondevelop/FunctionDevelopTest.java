package programmers.exercise.stackNqueue.functiondevelop;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class FunctionDevelopTest {
    private FunctionDevelop functionDevelop = new FunctionDevelop();

    @DisplayName("케이스 1")
    @Test
    void case1() {
        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};
        int[] expect = {2, 1};

        // when
        int[] answer = functionDevelop.solution(progresses, speeds);

        assertAll(
                () -> assertThat(answer).isNotEmpty()
                , () -> assertThat(answer).hasSize(expect.length)
                , () -> assertThat(answer[0]).isEqualTo(expect[0])
                , () -> assertThat(answer[1]).isEqualTo(expect[1])
        );
    }
}
