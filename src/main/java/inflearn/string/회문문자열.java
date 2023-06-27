package inflearn.string;

import java.util.Scanner;

/**
 * https://cote.inflearn.com/contest/10/problem/01-07
 */
public class 회문문자열 {
    private static final String YES = "YES";
    private static final String NO = "NO";

    /**
     * 회문문자열의 특징은 길이 / 2까지 범위로
     * 앞과 뒤과 같은지 비교, 홀수인 경우도 같다.
     */
    private static String solution(String str) {
        str = str.toUpperCase();
        int length = str.length();
        for (int i = 0; i < length / 2; i++) {
            if (str.charAt(i) != str.charAt(length - 1 - i)) {
                return NO;
            }
        }
        return YES;
    }

    /**
     * char이 아닌 String으로 해결하는 방법
     */
    private static String solution2(String str) {
        String reverse = new StringBuilder(str).reverse().toString();
        if (str.equalsIgnoreCase(reverse)) {
            return YES;
        }
        return NO;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        System.out.println(solution(str));
    }
}
