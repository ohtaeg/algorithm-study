package boj.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q10799 {
    private static final char OPEN_BRACKET = '(';

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String source = br.readLine();
        int result = cut(source);
        System.out.println(result);
        br.close();
    }

    private static int cut(final String source) {
        final Stack<Integer> stack = new Stack<>();
        int result = 0;
        int bracketSequence = 0;
        for (char bracket : source.toCharArray()) {
            if (isOpenBracket(bracket)) {
                stack.push(bracketSequence++);
            } else {
                if (isLaser(stack, bracketSequence)) {
                    result += stack.size();
                } else {
                    result++;
                }
            }
        }
        return result;
    }

    private static boolean isOpenBracket(final char bracket) {
        return bracket == OPEN_BRACKET;
    }

    private static boolean isLaser(final Stack<Integer> stack, final int bracketSequence) {
        if (stack.isEmpty()) {
            throw new RuntimeException("왼쪽 괄호가 없을 수 없습니다.");
        }
        return stack.pop() == bracketSequence - 1;
    }
}
