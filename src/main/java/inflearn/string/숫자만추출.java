package inflearn.string;

import java.util.Scanner;

/**
 * https://cote.inflearn.com/contest/10/problem/01-09
 */
public class 숫자만추출 {
    /**
     * 아스키번호가 48 ~ 57 인 애들은 숫자
     * 48 = '0'
     * 0 1 2 0 5 => 1205
     * result = result * 10 + (x - 48)
     * 0    = 0   * 10 + 0;
     * 1    = 0   * 10 + 1;
     * 12   = 1   * 10 + 2;
     * 120  = 12  * 10 + 0;
     * 1205 = 120 * 10 + 5
     */
    private static int solution(String str) {
        int result = 0;
        for (char x : str.toCharArray()) {
            if (x >= 48 && x <= 57) {
                result = result * 10 + (x - 48);
            }
        }
        return result;
    }

    /**
     * 아스키코드 없이
     */
    private static int solution2(String str) {
        String result = "";
        for (char x : str.toCharArray()) {
            if (Character.isDigit(x)) {
                result += x;
            }
        }
        return Integer.parseInt(result);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(solution(scanner.next()));
    }
}
