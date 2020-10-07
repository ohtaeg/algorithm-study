package book.part3.implement;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 문자열 재정렬
 * K1KA5CB7
 * AJKDLSI412K4JSJ9D
 */
public class StringReOrdering {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] source = scanner.nextLine().split("");
        String result = reOrderString(source);
        System.out.println(result);
    }

    private static String reOrderString(final String[] source) {
        StringBuilder result = new StringBuilder();
        int sum = 0;

        Arrays.sort(source);

        for (int i = 0; i < source.length; i++) {
            String value = source[i];
            if (isNumber(value)) {
                sum += Integer.parseInt(value);
            } else {
                result.append(value);
            }
        }

        return result.append(sum).toString();
    }

    private static boolean isNumber(final String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
