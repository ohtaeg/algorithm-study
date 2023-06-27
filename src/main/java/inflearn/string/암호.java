package inflearn.string;

import java.util.Scanner;

/**
 * https://cote.inflearn.com/contest/10/problem/01-12
 */
public class 암호 {

    /**
     * 문자의 갯수만큼 자른다
     * substring (0, 7) (7, 14) ...
     * replace 한다
     * 이진수를 10진수로 변환한다.
     * 10진수를 아스키코드로 변환한다.
     */
    private static String solution(final int count, final String letter) {
        String result = "";
        for (int i = 0; i < count; i++) {
            String secret = letter.substring(i * 7, (i + 1) * 7);
            secret = secret.replace("#", "1");
            secret = secret.replace("*", "0");
            int number = Integer.parseInt(secret, 2);
            result += (char) number;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = Integer.parseInt(sc.nextLine());
        String letter = sc.nextLine();
        System.out.println(solution(count, letter));
    }
}
