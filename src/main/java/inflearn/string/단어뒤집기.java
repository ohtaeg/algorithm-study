package inflearn.string;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * https://cote.inflearn.com/contest/10/problem/01-04
 */
public class 단어뒤집기 {

    // StringBuilder.reverse()
    private static List<String> solution(final String[] words) {
        List<String> result = new ArrayList<>();
        for (String target : words) {
            result.add(new StringBuilder(target).reverse().toString());
        }
        return result;
    }

    /**
     * 뒤집을 문자들을 각 쌍으로 묶어서 뒤집는 swap 방식
     * good => (g <-> d) (o <-> o)
     */
    private static List<String> solution2(final String[] words) {
        List<String> result = new ArrayList<>();
        for (String target : words) {
            char[] targets = target.toCharArray();
            int left = 0;
            int right = target.length() - 1;

            while (left < right) {
                char tmp = targets[left];
                targets[left] = targets[right];
                targets[right] = tmp;
                left++;
                right--;
            }
            result.add(String.valueOf(targets));
        }
        return result;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();
        String[] words = new String[count];
        for (int i = 0; i < count; i++) {
            words[i] = in.next();
        }


        for (String reverse : solution(words)) {
            System.out.println(reverse);
        }
    }
}
