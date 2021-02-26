package programmers.exercise;

/**
 * 완전탐색으로 접근했는데 시간초과가 많이나서 블로그 참고함
 * 예제 1231234, k = 3일때, 정답의 길이는 7 - 3 = 4글자이다.
 * 적어도 뒤에 4자리를 제외한 0 ~ 2에서 앞자리 하나가 도출되어야한다.
 * 3이 도출된 다음 인덱스(3) 부터 다시 큰 수를 찾는다.
 * 그렇게 되면 1234가 남아있게 되는데 이미 3은 도출된 상태에서 정답은 3글자가 남으므로
 * 1234에서 3글자를 도출해야 하고, (1, 2) 중 하나가 최대값이 도출되어야 한다.
 * 1, 2중 최대값을 찾아야 하는 이유는 1, 2를 제외한 최소 갯수가 2개가 되기 때문이다.
 * 여기서 2를 도출하게 되면 정답은 2글자가 남게 되고, 34에서 2글자를 추출한다.
 */
public class BigNumberMaking {
    public String solution(String number, int k) {
        StringBuilder result = new StringBuilder();
        int start = 0;

        for (int i = 0; i < number.length() - k; i++) {
            char max = '0';
            for (int j = start; j <= k + i; j++) {
                char value = number.charAt(j);
                if (max < value) {
                    max = value;
                    start = j + 1;
                }
            }
            result.append(max);
        }

        return result.toString();
    }
}
