package programmers.exercise.hash.phonenumberlist;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Solution {
    public boolean solution(String[] phone_book) {
        return isExistPrefix(phone_book);
    }

    public boolean isExistPrefix(final String[] phone_book) {
        String prefix = null;
        int prefixLength = -1;

        // 1. key - 접두사, value - 접두사 길이를 가지는 hashmap setting
        Map<String, Integer> map = new HashMap<>();
        for (String phoneNumber : phone_book) {
            map.put(phoneNumber, phoneNumber.length());
        }

        final Iterator<Map.Entry<String, Integer>> iterator = map.entrySet()
                                                                 .iterator();
        while (iterator.hasNext()) {
            final Map.Entry<String, Integer> next = iterator.next();
            prefix = next.getKey();
            prefixLength = next.getValue();

            for (String target : phone_book) {
                if (isGreaterThanPrefixLength(prefix, prefixLength, target)) {
                    // index 0 부터 접두사 길이만큼 target 접두사와 일치하는지 체크
                    if (prefix.equals(target.substring(0, prefixLength))) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    // 접두사 길이가 target 길이보다 클때만 비교
    private boolean isGreaterThanPrefixLength(final String prefix, final int prefixLength, final String target) {
        return !prefix.equals(target) && target.length() >= prefixLength;
    }
}
