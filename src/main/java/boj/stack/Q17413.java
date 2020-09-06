package boj.stack;

import java.io.*;
import java.util.Stack;

/**
 * Reverse word 2
 * 하나의 단어씩 stack에 쌓는다.
 * 공백이 나올 경우 바로 stack을 비워 출력한다.
 * 태그가 나올 경우 stack에 쌓지 않는다.
 */
public class Q17413 {
    private static final char LEFT_BRACKET = '<';
    private static final char RIGHT_BRACKET = '>';
    private static final char SPACE = ' ';

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        reverse(bufferedReader.readLine(), result);

        bufferedWriter.write(result.toString());
        bufferedReader.close();
        bufferedWriter.flush();
        bufferedWriter.close();
    }

    public static String reverse(final String source, final StringBuilder result) {
        Stack<Character> characters = new Stack<>();
        boolean isOpen = false;

        for (char word : source.toCharArray()) {
            // 문자열의 시작과 끝은 공백이 아니기 때문에 먼저 조건문으로 비교해도 상관없다.
            if (isEmpty(word)) {
                result.append(popAll(characters));
                result.append(word);
            } else if (isLeftBracket(word)) {
                isOpen = true;
                result.append(popAll(characters));
                result.append(word);
            } else if (isRightBracket(word)) {
                isOpen = false;
                result.append(word);
            } else {
                // 순수 문자열들일때 괄호가 열려있으면 그대로 출력, 괄호가 닫혀있는 상태라면 뒤집기 위해 stack에 쌓는다.
                if (isOpen) {
                    result.append(word);
                } else {
                    characters.push(word);
                }
            }
        }

        if (!characters.isEmpty()) {
            result.append(popAll(characters));
        }

        return result.toString();
    }

    private static boolean isEmpty(final char word) {
        return word == SPACE;
    }

    private static boolean isLeftBracket(final char word) {
        return word == LEFT_BRACKET;
    }

    private static boolean isRightBracket(final char word) {
        return word == RIGHT_BRACKET;
    }

    private static String popAll(final Stack<Character> characters) {
        StringBuilder stringBuilder = new StringBuilder();
        while (!characters.isEmpty()) {
            stringBuilder.append(characters.pop());
        }
        return stringBuilder.toString();
    }
}
