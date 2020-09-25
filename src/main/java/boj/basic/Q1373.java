package boj.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 2진수 8진수
 */
public class Q1373 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String source = bufferedReader.readLine();
        Stack<Integer> stack = new Stack();
        StringBuilder result = new StringBuilder();
        int octCount = 0;
        int sum = 0;

        for (int i = source.length() - 1; i >= 0; i--) {
            if (octCount == 3) {
                octCount = 0;
                stack.push(sum);
                sum = 0;
            }

            sum += (int) ((source.charAt(i) - '0') * Math.pow(2, octCount++));
        }

        result.append(sum);
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        System.out.println(result.toString());
        bufferedReader.close();
    }
}
