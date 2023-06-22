package inflearn.string;

import java.util.Scanner;

public class 문자찾기 {
    public int solution(String text, char t) {
        int answer = 0;
        String uppers = text.toUpperCase();
        char upper = Character.toUpperCase(t);

        for (char letter : uppers.toCharArray()) {
            if (letter == upper) {
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        문자찾기 t = new 문자찾기();
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        char target = scanner.next().charAt(0);

        System.out.println(t.solution(str, target));
    }
}
