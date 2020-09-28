package boj.basic;

import java.util.Scanner;

public class Q2745 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final String source = scanner.next();
        final int notation = scanner.nextInt();

        System.out.println(convertDecimalNotation(source, notation));
    }

    private static int convertDecimalNotation(final String source, final int notation) {
        final int length = source.length();
        int decimal = 0;
        for (int i = 0; i < length; i++) {
            int data = convertDecimalNumber(source.charAt(0));
            decimal += data * Math.pow(notation, length - 1 - i);
        }
        return decimal;
    }

    private static int convertDecimalNumber(final char letter) {
        if (letter >= '0' && letter <= '9') {
            return letter - '0';
        }
        return letter - 'A' + 10;
    }
}
