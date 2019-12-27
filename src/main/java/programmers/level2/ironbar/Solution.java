package programmers.level2.ironbar;

import java.util.Stack;

public class Solution {
    private final char OPEN_DELIM = '(';
    private final char CLOSE_DELIM = ')';

    public int solution(String arrangement) {
        return soulution(arrangement);
    }

    private int soulution(final String arrangement) {
        int actual = 0;
        char delim = ' ';
        Stack<Character> stack = new Stack();

        for (int i=0; i<arrangement.length(); i++) {
            delim = arrangement.charAt(i);

            if (delim == CLOSE_DELIM) {
                if (isLaser(stack.peek(), delim, arrangement.charAt(i-1))) {
                    stack.pop();
                    actual += stack.size();
                } else {
                    stack.pop();
                    actual += 1;
                }
            } else {
                stack.push(delim);
            }
        }
        return actual;
    }

    private boolean isLaser(final char peek, final char delim, final char delimBefore) {
        return peek == OPEN_DELIM && delim == CLOSE_DELIM && delimBefore != CLOSE_DELIM;
    }
}
