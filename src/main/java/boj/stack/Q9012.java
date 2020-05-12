package boj.stack;

import java.io.*;

public class Q9012 {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final String OPEN_BRACKET = "(";
    private static final String CLOSE_BRACKET = ")";
    private static final String YES = "YES";
    private static final String NO = "NO";
    private static final int ZERO = 0;

    public static void main(String[] args) throws IOException {
        StringBuilder result = new StringBuilder();
        int count = insertCount();
        String source;
        for (int i = ZERO; i < count; i++) {
            source = insertExample();

            // 1. 길이가 짝수가 아니라면
            if (isNotEvenLength(source)) {
                result.append(formatAnswer(NO));
                continue;
            }

            // 2. ) 로 시작하거나 ( 로 끝난다면
            if (isNotCorrectBracketExpression(source)) {
                result.append(formatAnswer(NO));
                continue;
            }

            // 3. stack이 남아있다면
            result.append(formatAnswer(checkVPS(source)));
        }

        bufferedWriter.write(result.toString());

        bufferedReader.close();
        bufferedWriter.flush();
        bufferedWriter.close();
    }

    private static int insertCount() throws IOException {
        final String inputData = bufferedReader.readLine();
        return Integer.valueOf(inputData);
    }

    private static String insertExample() throws IOException {
        return bufferedReader.readLine();
    }

    private static boolean isNotEvenLength(final String source) {
        return source.length() % 2 != ZERO;
    }

    private static String formatAnswer(final String answer) {
        return answer + System.lineSeparator();
    }

    private static boolean isNotCorrectBracketExpression(final String source) {
        return source.startsWith(CLOSE_BRACKET) || source.endsWith(OPEN_BRACKET);
    }

    private static String checkVPS(final String source) {
        int count = ZERO;
        for (int i = ZERO; i < source.length(); i++) {
            String bracket = String.valueOf(source.charAt(i));
            if (OPEN_BRACKET.equals(bracket)) {
                count++;
            }

            if (CLOSE_BRACKET.equals(bracket)) {
                if (count == ZERO) {
                    return NO;
                }
                count--;
            }
        }

        return count == ZERO ? YES : NO;
    }
}
