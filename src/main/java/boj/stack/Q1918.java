package boj.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * postfix notatation
 * A+B*C+D       => ABC*+D+
 * A+B*C         => ABC*+
 * (A+B)*C       => AB+C*
 * (A*(B+C))-D   => ABC+*D-
 * (A*(B+C)+D)-E => ABC+*D+E-
 */
public class Q1918 {
    private static final BufferedReader BUFFERED_READER = new BufferedReader(new InputStreamReader(System.in));
    private static final String OPEN_BRACKET = "(";
    private static final String CLOSE_BRACKET = ")";
    private static final String PLUS_OPERATOR = "+";
    private static final String MINUS_OPERATOR = "-";
    private static final String MULTIPLE_OPERATOR = "*";
    private static final String DIVIDE_OPERATOR = "/";

    public static void main(String[] args) throws IOException {
        String source = BUFFERED_READER.readLine();
        BUFFERED_READER.close();

        StringBuilder result = new StringBuilder();
        Stack<String> operandStack = new Stack<>();

        for (char ch : source.toCharArray()) {
            String letter = String.valueOf(ch);
            // 1. 여는 괄호 나올시, push
            if (isOpenBracket(letter)) {
                operandStack.push(letter);
                continue;
            }

            // 2. 닫는 괄호 나올시, 스택에 여는괄호 나올때까지 pop()
            if (isCloseBracket(letter)) {
                while (!operandStack.isEmpty() && !isOpenBracket(operandStack.peek())) {
                    result.append(operandStack.pop());
                }
                operandStack.pop(); // "(" pop
                continue;
            }

            // 3. 연산자일 경우, 우선순위 비교하여 우선순위가 높은 연산자가 스택에 있고 우선순위가 낮은 연산자일경우 우선순위 pop()
            if (isOperator(letter)) {
                while (!operandStack.isEmpty() && isPriorityGreaterThan(operandStack.peek(), letter)) {
                    result.append(operandStack.pop());
                }
                operandStack.push(letter);
            } else {
                result.append(letter);
            }
        }

        while (!operandStack.isEmpty()) {
            result.append(operandStack.pop());
        }
        System.out.println(result.toString());
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
        switch (letter) {
            case PLUS_OPERATOR :
            case MINUS_OPERATOR :
                return 1;
            case MULTIPLE_OPERATOR :
            case DIVIDE_OPERATOR :
                return 2;
            default:
                return 0;
        }
    }
}
