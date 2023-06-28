package programmers.level2;

import java.util.Arrays;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/12941
 * A 배열의 최소 값과 B 배열의 최대값을 곱하여 누적하면 최소 값이 나온다.
 */
public class 최솟값만들기 {

    public int solution(int[] a, int[] b) {
        int answer = 0;

        Arrays.sort(a);
        Arrays.sort(b);

        for (int i = 0; i < a.length; i++) {
            answer += a[i] * b[b.length - i - 1];
        }

        return answer;
    }
}
