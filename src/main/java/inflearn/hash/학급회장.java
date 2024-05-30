package inflearn.hash;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 학급 회장을 뽑는데 후보로 기호 A, B, C, D, E 후보가 등록을 했다.
 * 투표용지에는 반 학생들이 자기가 선택한 후보의 기호(알파벳)가 쓰여져있고
 * 선생님의 발표가 끝난 후 어떤 후보가 학급회장이 되었는지 출력하라
 *
 * 15
 * BACBACCACCBDEDE
 */
public class 학급회장 {
    private static final Character EMPTY = ' ';
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String str = scanner.next();
        System.out.println(solution(str));
    }

    private static String solution(final String str) {
        Map<Character, Integer> counter = new HashMap<>();
        for (char x : str.toCharArray()) {
            counter.put(x, counter.getOrDefault(x, 0) + 1);
        }

        return String.valueOf(counter.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(EMPTY));
    }
}
