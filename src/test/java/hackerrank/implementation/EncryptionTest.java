package hackerrank.implementation;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class EncryptionTest {


    @Test
    void test1() {
        final String s = "if man was meant to stay on the ground god would have given us roots";
        final String expect = "imtgdvs fearwer mayoogo anouuio ntnnlvt wttddes aohghn sseoau";

        final String actual = Encryption.encryption(s);

        assertThat(actual).isEqualTo(expect);
    }

    @Test
    void test2() {
        final String s = "feedthedog";
        final String expect = "fto ehg ee dd";

        final String actual = Encryption.encryption(s);

        assertThat(actual).isEqualTo(expect);
    }

    @Test
    void test3() {
        final String s = "chillout";
        final String expect = "clu hlt io";

        final String actual = Encryption.encryption(s);

        assertThat(actual).isEqualTo(expect);
    }

}
