package boj.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q11655 {
    private static final char ALPHABET_UPPER_A = 'A';
    private static final char ALPHABET_UPPER_Z = 'Z';
    private static final char ALPHABET_LOWER_Z = 'z';
    private static final int ALPHABET_LENGTH = ALPHABET_UPPER_Z - ALPHABET_UPPER_A + 1;
    private static final int ROT13 = 13;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String source = br.readLine();
        br.close();
        StringBuilder builder = new StringBuilder(source.length());

        for (char ch : source.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                ch = calculateROT13(ch, ALPHABET_UPPER_Z);
            } else if (Character.isLowerCase(ch)) {
                ch = calculateROT13(ch, ALPHABET_LOWER_Z);
            }
            builder.append(ch);
        }
        System.out.println(builder.toString());
    }

    private static char calculateROT13(char ch, final char alphabetZ) {
        ch += ROT13;
        if (ch > alphabetZ) {
            ch -= ALPHABET_LENGTH;
        }
        return ch;
    }
}
