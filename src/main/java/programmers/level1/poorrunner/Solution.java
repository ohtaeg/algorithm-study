package programmers.level1.poorrunner;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Long> map = Arrays.stream(participant)
                                      .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        for (String name : completion) {
            map.put(name, map.get(name) - 1);
            if (map.get(name) <= 0) {
                map.remove(name);
            }
        }

        return (map.keySet().stream().findFirst()).get();
    }
}
