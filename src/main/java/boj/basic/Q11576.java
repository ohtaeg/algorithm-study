package boj.basic;

import java.util.Scanner;
import java.util.Stack;
import java.util.StringJoiner;

/**
 * Base Conversion
 */
public class Q11576 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int a = scanner.nextInt();
        final int b = scanner.nextInt();
        final int m = scanner.nextInt();

        int sum = 0;
        for (int i = 0; i < m; i++) {
            int data = scanner.nextInt();
            sum += data * Math.pow(a, m - 1 - i);
        }

        System.out.println(convertBNotation(sum, b));

    }

    private static String convertBNotation(int sum, final int b) {
        Stack<Integer> stack = new Stack<>();
        while (sum != 0) {
            stack.push(sum % b);
            sum /= b;
        }

        StringJoiner strJoiner = new StringJoiner(" ");
        while (!stack.isEmpty()) {
            strJoiner.add(Integer.toString(stack.pop()));
        }

        return strJoiner.toString();
    }
}
