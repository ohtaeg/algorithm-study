package programmers.level2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/12939
 */
public class 최댓값과최솟값 {
    public String solution(String s) {
        final String[] split = s.split(" ");
        final List<Integer> numbers = Arrays.stream(split)
                .map(Integer::parseInt)
                .sorted().collect(Collectors.toList());

        return numbers.get(0) + " " + numbers.get(numbers.size() - 1);
    }
}
