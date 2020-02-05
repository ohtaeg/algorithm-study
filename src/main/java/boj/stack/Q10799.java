package boj.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q10799 {
    private static final String OPEN_BRACKET = "(";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();
        String source = br.readLine();
        int index = 1;
        int sum = 0;

        for (char ch : source.toCharArray()) {
            if (String.valueOf(ch).equals(OPEN_BRACKET)) {
                stack.push(index++);
            } else {
                if (!stack.isEmpty() && stack.pop() == index - 1) {
                    sum += stack.size();
                } else {
                    sum += 1;
                }
            }
        }
        System.out.println(sum);
        br.close();
    }
}
