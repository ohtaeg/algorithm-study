package boj.stack;

import java.io.*;
import java.util.Stack;

public class Q4949 {
    private static final String END_POINT = ".";
    private static final String YES = "yes";
    private static final String NO = "no";
    private static final char LEFT_SMALL_BRACKET = '(';
    private static final char RIGHT_SMALL_BRACKET = ')';
    private static final char LEFT_MIDDLE_BRACKET = '[';
    private static final char RIGHT_MIDDLE_BRACKET = ']';

    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out))) {

            StringBuilder result = new StringBuilder();
            String input;
            while (!isEnd(input = bufferedReader.readLine())) {
                if (isBalance(input)) {
                    result.append(YES);
                } else {
                    result.append(NO);
                }
                result.append(System.lineSeparator());
            }
            bufferedWriter.write(result.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean isBalance(final String input) {
        Stack<Character> bracketStack = new Stack<>();

        if (" .".equals(input)) {
            return true;
        }

        for (char word : input.toCharArray()) {
            if (word == LEFT_SMALL_BRACKET || word == LEFT_MIDDLE_BRACKET) {
                bracketStack.push(word);
            } else if (word == RIGHT_SMALL_BRACKET) {
                if (isBalanceBracket(bracketStack, LEFT_SMALL_BRACKET)) {
                    bracketStack.pop();
                } else {
                    return false;
                }
            } else if (word == RIGHT_MIDDLE_BRACKET) {
                if (isBalanceBracket(bracketStack, LEFT_MIDDLE_BRACKET)) {
                    bracketStack.pop();
                } else {
                    return false;
                }
            }
        }

        return bracketStack.isEmpty() ? true : false;
    }

    private static boolean isEnd(final String input) {
        return input.equals(END_POINT) && input.length() == 1;
    }

    private static boolean isBalanceBracket(final Stack<Character> bracketStack, final char bracket) {
        return !bracketStack.isEmpty() && bracketStack.peek() == bracket;
    }
}
