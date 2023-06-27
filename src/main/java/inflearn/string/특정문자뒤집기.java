package inflearn.string;

import java.util.Scanner;

/**
 * https://cote.inflearn.com/contest/10/problem/01-05
 */
public class 특정문자뒤집기 {

    private static String solution(final String target) {
        char[] chars = target.toCharArray();
        int left = 0;
        int right = target.length() - 1;

        while (left < right) {
            if (isNotAlphabet(chars[left])) {
                left++;
            } else if (isNotAlphabet(chars[right])) {
                right--;
            } else {
                char tmp = chars[left];
                chars[left] = chars[right];
                chars[right] = tmp;
                left++;
                right--;
            }
        }
        return String.valueOf(chars);
    }

    private static boolean isNotAlphabet(final char word) {
        return !(65 <= word && word <= 122);
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println(solution(in.next()));
    }
}
