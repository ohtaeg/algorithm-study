package boj.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q1212 {
    private static final String[] FIRST_PLACE_VALUE = {"0", "1", "10", "11"};
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] source = bufferedReader.readLine().split("");

        String result = convertOctalToBinary(source);

        System.out.println(result);
        bufferedReader.close();
    }


    private static String convertOctalToBinary(final String[] source) {
        StringBuilder convertResult = new StringBuilder();
        for (int i = 0; i < source.length; i++) {
            int placeValue = Integer.valueOf(source[i]);
            if (i == 0 && placeValue < 4) {
                convertResult.append(FIRST_PLACE_VALUE[placeValue]);
            } else {
                convertResult.append(convertToBinary(placeValue));
            }
        }

        return convertResult.toString();
    }

    private static String convertToBinary(int data) {
        StringBuilder result = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        while (data > 1) {
            stack.push(data % 2);
            data /= 2;
        }
        stack.push(data);

        while (!stack.empty()) {
            result.append(stack.pop());
        }
        return String.format("%03d", Integer.valueOf(result.toString()));
    }
}
