package boj.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * postfix notatation
 * A+B*C+D       => ABC*+D+
 */
public class Q1918 {
    private static final String OPEN_BRACKET = "(";
    private static final String CLOSE_BRACKET = ")";
    private static final String PLUS_OPERATOR = "+";
    private static final String MINUS_OPERATOR = "-";
    private static final String MULTIPLE_OPERATOR = "*";
    private static final String DIVIDE_OPERATOR = "/";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String source = br.readLine();
        br.close();

        StringBuilder stringBuilder = new StringBuilder();
        Stack<String> stack = new Stack<>();
        String letter;

        for (char ch : source.toCharArray()) {
            letter = String.valueOf(ch);
            if (isOpenBracket(letter)) {
                stack.push(letter);
            } else if (isCloseBracket(letter)) {
                while (!stack.isEmpty() && !isOpenBracket(stack.peek())) {
                    stringBuilder.append(stack.pop());
                }
                stack.pop(); // "(" pop
            } else if (isOperator(letter)) {
                while (!stack.isEmpty() && isPriorityGreaterThan(stack.peek(), letter)) {
                    stringBuilder.append(stack.pop());
                }
                stack.push(letter);
            } else {
                stringBuilder.append(letter);
            }
        }

        while (!stack.isEmpty()) {
            stringBuilder.append(stack.pop());
        }
        System.out.println(stringBuilder.toString());
    }

    private static boolean isOpenBracket(final String letter) {
        return OPEN_BRACKET.equals(letter);
    }

    private static boolean isCloseBracket(final String letter) {
        return CLOSE_BRACKET.equals(letter);
    }

    private static boolean isOperator(final String letter) {
        switch (letter) {
            case PLUS_OPERATOR :
            case MINUS_OPERATOR :
            case MULTIPLE_OPERATOR :
            case DIVIDE_OPERATOR :
                return true;
            default:
                return false;
        }
    }

    private static boolean isPriorityGreaterThan(final String top, final String letter) {
        return getPriority(top) >= getPriority(letter);
    }

    private static int getPriority(final String letter) {
        int priority = -1;
        switch (letter) {
            case PLUS_OPERATOR :
            case MINUS_OPERATOR :
                priority = 1;
                break;
            case MULTIPLE_OPERATOR :
            case DIVIDE_OPERATOR :
                priority = 2;
                break;
            default:
                priority = 0;
        }
        return priority;
    }
}
