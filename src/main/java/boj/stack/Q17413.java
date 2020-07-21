package boj.stack;

import java.io.*;
import java.util.Stack;

/**
 * Reverse word 2
 */
public class Q17413 {
    private static final String LEFT_BRACKET = "<";
    private static final String RIGHT_BRACKET = ">";

    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        StringBuilder result = new StringBuilder();
        boolean isOpeningTag = false;

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out))) {

            String source = bufferedReader.readLine();
            for (int i = 0; i < source.length(); i++) {
                String word = source.substring(i, i + 1);
                switch (word) {
                    case LEFT_BRACKET :
                        reverse(result, stack);
                        isOpeningTag = true;
                        result.append(word);
                        break;
                    case RIGHT_BRACKET :
                        isOpeningTag = false;
                        result.append(word);
                        break;
                    default :
                        if (isOpeningTag) {
                            result.append(word);
                        } else {
                            if (word.equals(" ")) {
                                reverse(result, stack);
                                result.append(word);
                            } else {
                                stack.push(word);
                            }
                        }
                }
            }

            reverse(result, stack);
            bufferedWriter.write(result.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void reverse(final StringBuilder result, final Stack<String> stack) {
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
    }
}
