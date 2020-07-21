package boj.stack;

import java.io.*;
import java.util.Stack;

public class Q9012 {
    private static final String YES = "YES";
    private static final String NO = "NO";
    private static final char RIGHT_BRACKET = ')';
    private static final int ZERO = 0;

    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int count = Integer.parseInt(bufferedReader.readLine());
            while (count-- > ZERO) {
                String source = bufferedReader.readLine();
                bufferedWriter.write(validParenthesis(source));
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String validParenthesis(final String source) {
        Stack<Character> stack = new Stack<>();

        for (int i = ZERO; i < source.length(); i++) {
            final char bracket = source.charAt(i);
            if (isRightBracket(bracket)) {
                if (stack.isEmpty()) {
                    return NO;
                }
                stack.pop();
            } else {
                stack.push(bracket);
            }
        }

        return isVPS(stack);
    }

    private static boolean isRightBracket(final char bracket) {
        return RIGHT_BRACKET == bracket;
    }

    private static String isVPS(final Stack<Character> stack) {
        if (stack.isEmpty()) {
            return YES;
        } else {
            return NO;
        }
    }
}
