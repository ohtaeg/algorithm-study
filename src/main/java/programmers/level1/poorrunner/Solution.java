package programmers.level1.poorrunner;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public String solution(String[] participant, String[] completion) {
        // 더 느림, 아마도 grouping에서 오래 걸리는듯 하다.
//        Map<String, Long> map = Arrays.stream(participant)
//                                      .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Map<String, Integer> map = new HashMap<>();
        for (int i=0; i<participant.length; i++) {
            map.put(participant[i], map.getOrDefault(participant[i], 0) + 1);
        }

        for (String name : completion) {
            map.put(name, map.get(name) - 1);
            if (map.get(name) <= 0) {
                map.remove(name);
            }
        }

        return (map.keySet().stream().findFirst()).get();
    }
}
