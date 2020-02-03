package boj.stack;

import java.io.*;
import java.util.Stack;

/**
 * Stack Sequence
 * SUCCESS
 * 8 -> size
 * 4     3  6   8   7  5 2 1 -> 입력된 정수 수열
 * ++++- -  ++- ++- -  - - -
 * RESULT = ++++--++-++-----
 *
 * FAIL
 * 5 -> size
 * 1  2  5    3  4
 * +- +- +++- -- NO
 * RESULT = NO
 */
public class Q1874 {
    private static final String PLUS = "+\n";
    private static final String MINUS = "-\n";
    private static final String NO = "NO";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Integer> stack = new Stack<>();
        StringBuilder result = new StringBuilder();
        int cursor = 0;
        int size = Integer.valueOf(br.readLine());
        int num = -1;

        while (size-- > 0) {
            num = Integer.valueOf(br.readLine());
            if (num > cursor) {
                while (num > cursor) {
                    stack.push(++cursor);
                    result.append(PLUS);
                }
                stack.pop();
                result.append(MINUS);
            } else {
                boolean isFound = false;
                if (!stack.isEmpty()) {
                    int top = stack.peek();
                    stack.pop();
                    result.append(MINUS);

                    if (top == num) {
                        isFound = true;
                    }
                }

                if (!isFound) {
                    result = new StringBuilder();
                    result.append(NO);
                    break;
                }
            }
        }

        br.close();
        bw.write(result.toString());
        bw.flush();
        bw.close();
    }
}
