package boj.basic;

import java.util.Scanner;
import java.util.Stack;

public class Q11005 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int data = scanner.nextInt();
        final int notation = scanner.nextInt();

        StringBuilder result = new StringBuilder();
        Stack<String> stack = new Stack<>();

        while (data != 0) {
            stack.push(convert(data % notation));
            data /= notation;
        }

        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        System.out.println(result.toString());
    }

    private static String convert(final int data) {
        if (data > 9) {
            return String.valueOf((char) (data + 'A' - 10));
        }
        return String.valueOf(data);
    }
}
