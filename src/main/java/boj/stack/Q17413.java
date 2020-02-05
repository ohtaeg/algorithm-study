package boj.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * Reverse word 2
 */
public class Q17413 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<String> wordStack = new Stack<>();
        String source = br.readLine();
        boolean isTag = false;
        br.close();

        String word;
        for (char ch : source.toCharArray()) {
            word = String.valueOf(ch);
            if (word.equals("<")) {
                print(wordStack);
                System.out.print(word);
                isTag = true;

            } else if (word.equals(">")) {
                isTag = false;
                System.out.print(word);
            // 단어, 공백인데 태그가 열려있다면
            } else if (isTag) {
                System.out.print(word);
            // 단어, 공백인데 태그가 닫혀 있다면
            } else {
                if (word.equals(" ")) {
                    print(wordStack);
                    System.out.print(word);
                } else {
                    wordStack.push(word);
                }
            }
        }
        print(wordStack);
    }

    private static void print(final Stack<String> stack) {
        while(!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
    }
}
