package hackerrank.strings;

import java.util.HashMap;
import java.util.Map;

/**
 * 각 문자열의 빈도수가 동일하면 유효한 문자열로 판단하는 문제
 * 1. 각 문자의 갯수를 맵에 저장 (counts)
 * 2. 문자의 갯수를 key로 문자의 갯수 빈도수를 저장하는 새로운 맵에 저장 (frequencies)
 * 3. 만약 빈도 수를 저장한 맵의 사이즈가 1이면 모든 문자열이 동일한 크기라는 뜻이므로 yes 반환
 * 4. 만약 빈도 수를 저장한 맵의 사이즈가 2 초과면 아무리 1개를 빼도 빈도수가 동일해질 수 없기에 No 반환
 * 5. 만약 빈도 수를 저장한 맵의 사이즈가 2라면 가장 많이 반복하는 빈도수에 1을 뺐을때 0일 경우 문자의 갯수가 - 1이  가장 작은 문자의 갯수와 동일하면 YES
 * s = aaaab 가 있을 때, {1 : 1, 4 : 1}로 저장된다. 가장 많이 반복하는 문자인 a의 빈도수를 -1하면 0이된다는 것은 a = 4 -> a = 3으로 변한다는 뜻
 * s = aaab 가 된다. 이때 a의 갯수가 b의 갯수와 같은지 체크해줘서 같아지면 YES
 * 6. 만약 빈도 수를 저장한 맵의 사이즈가 2라면 가장 적게 반복하는 빈도수에 1을 뺐을때 0이라면 YES
 * s == aabbc가 있을 때, {1 : 1, 2: 2}로 저장된다. 가장 적게 반복하는 문자인 c의 빈도수를 -1하여 0이 되면
 * s == aabb로 각 문자가 동일한 빈도를 가지게 된다.
 */
public class SherlockAndTheValidString {
    private static final String YES = "YES";
    private static final String NO = "NO";

    static String isValid(String s) {
        Map<Character, Integer> counts = new HashMap<>();
        for (char ch : s.toCharArray()) {
            int count = counts.get(ch) == null ? 0 : counts.get(ch);
            counts.put(ch, count + 1);
        }

        Map<Integer, Integer> frequencies = new HashMap<>();
        for (int count : counts.values()) {
            int frequency = frequencies.get(count) == null ? 0 : frequencies.get(count);
            frequencies.put(count, frequency + 1);
        }

        String result = valid(frequencies);

        return result;
    }

    private static String valid(final Map<Integer, Integer> frequencies) {
        if (frequencies.size() == 1) {
            return YES;
        } else if (frequencies.size() > 2) {
            return NO;
        } else {
            int minCountKey = min(frequencies);
            int maxCountKey = max(frequencies);

            if (frequencies.get(maxCountKey) - 1 == 0) {
                if (maxCountKey - 1 == minCountKey) {
                    return YES;
                }
            }

            if (frequencies.get(minCountKey) - 1 == 0) {
                return YES;
            }

            return NO;
        }
    }

    private static int min(final Map<Integer, Integer> frequencies) {
        int min = Integer.MAX_VALUE;
        for (int count : frequencies.keySet()) {
            min = Integer.min(min, count);
        }
        return min;
    }

    private static int max(final Map<Integer, Integer> frequencies) {
        int max = 0;
        for (int count : frequencies.keySet()) {
            max = Integer.max(max, count);
        }
        return max;
    }
}
