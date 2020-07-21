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
    private static final int ZERO = 0;

    public static void main(String[] args) {
        StringBuilder result = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int count = Integer.parseInt(bufferedReader.readLine());
            int[] sources = new int[count];
            int last = ZERO;

            for (int i = ZERO; i < count; i++) {
                sources[i] = Integer.parseInt(bufferedReader.readLine());
            }

            for (int i = ZERO; i < count; i++) {
                int input = sources[i];
                if (input > last) {
                    while (input > last) {
                        stack.push(++last);
                        result.append(PLUS);
                    }
                    stack.pop();
                    result.append(MINUS);
                } else {
                    if (!stack.isEmpty()) {
                        final int top = stack.pop();
                        if (top == input) {
                            result.append(MINUS);
                        } else {
                            result = new StringBuilder(NO);
                            break;
                        }
                    }
                }
            }

            bufferedWriter.write(result.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
