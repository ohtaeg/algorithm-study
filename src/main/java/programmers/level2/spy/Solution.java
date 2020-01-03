package programmers.level2.spy;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> map = new HashMap<>();
        for (String[] arr : clothes) {
            map.put(arr[1], map.getOrDefault(arr[1], 0) + 1);
        }

        for (int count : map.values()) {
            answer *= (count + 1);
        }
        return answer - 1;
    }
}
