package boj.basic;

import java.util.Scanner;

public class Q2745 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String data = scanner.next();
        final int notation = scanner.nextInt();

        int sum = 0;
        for (int i = 0; i < data.length(); i++) {
            int number = convert(data.charAt(i));
            sum += number * Math.pow(notation, data.length() -1 - i);
        }
        System.out.println(sum);
    }

    private static int convert(final char letter) {
        if (letter >= '0' && letter <= '9') {
            return letter - '0';
        }
        return letter - 'A' + 10;
    }
}
