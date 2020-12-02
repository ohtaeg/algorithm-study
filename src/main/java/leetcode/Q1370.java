package leetcode;

import java.util.Iterator;
import java.util.TreeMap;

/**
 * Increasing Decreasing String
 */
public class Q1370 {
    public static void main(String[] args) {
        Q1370 solution = new Q1370();
        System.out.println(solution.sortString("aaaabbbbcccc"));
        System.out.println(solution.sortString("rat"));

    }

    public String sortString(String inputValue) {
        TreeMap<String, Integer> map = init(inputValue);
        boolean isReverse = false;
        StringBuilder result = new StringBuilder();
        int remainCount = map.values()
                             .stream()
                             .reduce(0, Integer::sum);

        while (remainCount != 0) {
            Iterator<String> keyIterator;
            if (isReverse) {
                keyIterator = map.descendingKeySet().iterator();
            } else {
                keyIterator = map.keySet().iterator();
            }
            while (keyIterator.hasNext()) {
                String key = keyIterator.next();
                int count = map.get(key);

                if (count != 0) {
                    map.put(key, map.get(key) - 1);
                    remainCount--;
                    result.append(key);
                }
            }
            isReverse = !isReverse;
        }
        return result.toString();
    }

    private TreeMap<String, Integer> init(final String inputValue) {
        TreeMap<String, Integer> map = new TreeMap<>();
        String[] lowerAlphabets = inputValue.split("");
        for (String letter : lowerAlphabets) {
            map.put(letter, map.getOrDefault(letter, 0) + 1);
        }
        return map;
    }
}
