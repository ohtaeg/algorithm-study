package programmers.level2;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/70129
 */
public class 이진변환반복하기 {

    public int[] solution(String binary) {
        int[] answer = new int[2];
        int zero = 0;
        int count = 0;

        while (!binary.equals("1")) {
            final String[] split = binary.split("");
            for (int i = split.length - 1; i >= 0; i--) {
                if (split[i].equals("0")) {
                    zero++;
                    split[i] = split[i].replace("0", "");
                }
            }
            int length = String.join("", split).length();
            binary = Integer.toBinaryString(length);
            count++;
        }

        answer[0] = count;
        answer[1] = zero;

        return answer;
    }

    public static void main(String[] args) {
        이진변환반복하기 a = new 이진변환반복하기();

        a.solution("1111111");
    }
}
