package inflearn.string;

import java.util.Scanner;

/**
 * https://cote.inflearn.com/contest/10/problem/01-06
 */
public class 중복문자제거 {

    /**
     * indexOf
     * 해당 단어의 위치와 indexOf 값이 같으면 자기 단어라는 뜻
     * 다르면 중복값이라는 뜻
     * abca
     *   index indexOf
     * a    0   0
     * b    1   1
     * c    2   2
     * a    3   0
     */
    private static String solution(final String target) {
        String result = "";
        for (int i = 0; i < target.length(); i++) {
            if (target.indexOf(target.charAt(i)) == i) {
                result += target.charAt(i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(solution(scanner.next()));
    }
}
