package inflearn.string;

import java.util.Scanner;

/**
 * https://cote.inflearn.com/contest/10/problem/01-11
 */
public class 문자열압축 {

    /**
     * indexOutOfRange를 방지하기 위해 문자에 빈 문자열을 추가하여 크기를 한개 늘린다.
     */
    private static String solution(String text) {
        String result = "";
        text += " ";
        int count = 1;
        for (int i = 0; i < text.length() - 1; i++) {
            if (text.charAt(i) == text.charAt(i + 1)) {
                count++;
            } else {
                result += text.charAt(i);
                if (count != 1) {
                    result += count;
                }
                count = 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(solution(scanner.next()));
    }
}
