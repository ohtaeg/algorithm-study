package book.part3.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MultiplicationOrAddition {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        char[] source = bufferedReader.readLine().toCharArray();

        int result = calculate(source);

        System.out.println(result);
        bufferedReader.close();
    }

    private static int calculate(final char[] source) {
        int result = 0;
        int left = source[0] - '0';
        if (source.length == 1) {
            return left;
        }

        for (int i = 1; i < source.length; i++) {
            int right = source[i] - '0';
            int sum = Integer.sum(left, right);

            if (left * right < sum) {
                left = sum;
            } else {
                left *= right;
            }

            result = left;
        }

        return result;
    }
}
