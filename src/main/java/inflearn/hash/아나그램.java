package inflearn.hash;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * https://www.inflearn.com/course/lecture?courseSlug=%EC%9E%90%EB%B0%94-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4-%EC%BD%94%ED%85%8C%EB%8C%80%EB%B9%84&unitId=72740
 */
public class 아나그램 {

    private static final String YES = "YES";
    private static final String NO = "NO";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine();
        String other = scanner.nextLine();
        System.out.println(solution(word, other));
    }

    private static String solution(String word, String other) {
        Map<Character, Integer> analyzer = analyze(word);
        Map<Character, Integer> otherAnalyzer = analyze(other);

        if (analyzer.size() != otherAnalyzer.size()) {
            return NO;
        }

        for (Map.Entry<Character, Integer> entry : analyzer.entrySet()) {
            if (!otherAnalyzer.containsKey(entry.getKey()) || !otherAnalyzer.get(entry.getKey()).equals(entry.getValue())) {
                return NO;
            }
        }

        return YES;
    }

    private static Map<Character, Integer> analyze(String word) {
        Map<Character, Integer> analyzer = new HashMap<>();
        for (Character key : word.toCharArray()) {
            analyzer.put(key, analyzer.getOrDefault(key, 0) + 1);
        }
        return analyzer;
    }
}
