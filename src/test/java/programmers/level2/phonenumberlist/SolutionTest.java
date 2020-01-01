package programmers.level2.phonenumberlist;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    private Solution solution = new Solution();

    @Test
    void case1() {
        final String[] phone_book = {"119", "97674223", "1195524421"};

        final boolean actual = solution.isExistPrefix(phone_book);

       assertThat(actual).isFalse();
    }

    @Test
    void case2() {
        final String[] phone_book = {"123", "456", "789"};

        final boolean actual = solution.isExistPrefix(phone_book);

        assertThat(actual).isTrue();
    }

    @Test
    void case3() {
        final String[] phone_book = {"12", "123", "1235", "567", "88"};

        final boolean actual = solution.isExistPrefix(phone_book);

        assertThat(actual).isFalse();
    }

    @Test
    void case4() {
        final String[] phone_book = {"456", "1234234", "12", "5675634", "3453"};

        final boolean actual = solution.isExistPrefix(phone_book);

        assertThat(actual).isFalse();
    }
}