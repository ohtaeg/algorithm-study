package inflearn.string;

import java.util.Scanner;

/**
 * https://cote.inflearn.com/contest/10/problem/01-03
 */
public class 문장속단어 {

    // split
    private String solution(String text) {
        String answer = "";
        final String[] split = text.split(" ");
        for (String target : split) {
            if (answer.length() < target.length()) {
                answer = target;
            }
        }
        return answer;
    }

    // indexOf + substring
    private String solution2(String text) {
        String answer = "";
        int min = Integer.MIN_VALUE;
        int position = 0;

        while ((position = text.indexOf(' ')) != -1) {
            String tmp = text.substring(0, position);
            int len = tmp.length();
            if (len > min) {
                min = len;
                answer = tmp;
            }
            text = text.substring(position + 1);
        }

        // 마지막 단어는 while문을 안타기 때문에 따로 비교해줘야함
        if (text.length() > min) {
            answer = text;
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        문장속단어 solution = new 문장속단어();
        System.out.println(solution.solution(scanner.nextLine()));
    }
}
