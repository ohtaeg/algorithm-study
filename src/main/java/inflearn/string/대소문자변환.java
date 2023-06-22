package inflearn.string;

import java.util.Scanner;

public class 대소문자변환 {
    // Character 이용
    public String solution(String text) {
        String answer = "";
        for (char target : text.toCharArray()) {
            if (Character.isUpperCase(target)) {
                answer += Character.toLowerCase(target);
            } else {
                answer += Character.toUpperCase(target);
            }
        }
        return answer;
    }

    /**
     * 아스키 넘버 이용한 풀이
     * 대문자 65 ~ 90
     * 소문자 97 ~ 122
     * a - 32 = A
     * char는 정수와 비교가 가능
     */
    public String solution2(String text) {
        String answer = "";
        for (char target : text.toCharArray()) {
            if (isUpper(target)) {
                answer += (char) (target + 32);
            } else {
                answer += (char) (target - 32);
            }
        }
        return answer;
    }

    private static boolean isUpper(final char target) {
        return target >= 65 && target <= 90;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        대소문자변환 solution = new 대소문자변환();
        System.out.println(solution.solution(in.next()));
    }
}
