package boj.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q10820 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int upperCaseCount;
        int lowerCaseCount;
        int numberCount;
        int spaceCount;

        String input;
        while ((input = br.readLine()) != null) {
            upperCaseCount = 0;
            lowerCaseCount = 0;
            numberCount = 0;
            spaceCount = 0;

            for (char ch : input.toCharArray()) {
                if (Character.isUpperCase(ch)) {
                    upperCaseCount++;
                } else if (Character.isLowerCase(ch)) {
                    lowerCaseCount++;
                } else if (isNumber(ch)) {
                    numberCount++;
                } else {
                    spaceCount++;
                }
            }
            System.out.println(lowerCaseCount + " " + upperCaseCount + " " + numberCount + " " + spaceCount);
        }
    }
    private static boolean isNumber(final char ch) {
        return (ch >= '0' && ch <= '9') ? Boolean.TRUE : Boolean.FALSE;
    }
}
