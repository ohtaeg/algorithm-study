package inflearn.string;

import java.util.Scanner;

/**
 * https://cote.inflearn.com/contest/10/problem/01-08
 */
public class 팰린드롬 {
    private static final String YES = "YES";
    private static final String NO = "NO";

    /**
     * 1. 문자열만 걸러낸다.
     * 2. reverse 후 비교한다.
     */
    private static String solution(String target) {
        target = target.toUpperCase().replaceAll("[^A-Z]", "");
        String reverse = new StringBuilder(target).reverse().toString();
        if (target.equals(reverse)) {
            return YES;
        }
        return NO;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(solution(scanner.nextLine()));
    }
}
