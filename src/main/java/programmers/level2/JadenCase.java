package programmers.level2;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/12951
 */
public class JadenCase {
    public String solution(String s) {
        String answer = "";
        String[] split = s.toLowerCase().split("");
        boolean isJadenCase = Character.isAlphabetic(s.charAt(0));

        for (String letter : split) {
            if (isJadenCase) {
                letter = letter.toUpperCase();
                isJadenCase = false;
            }

            if (letter.equals(" ")) {
                isJadenCase = true;
            }

            answer += letter;
        }

        return answer;
    }

    public static void main(String[] args) {
        JadenCase jadenCase = new JadenCase();
        System.out.println(jadenCase.solution("3people unFollowed me"));
    }
}
