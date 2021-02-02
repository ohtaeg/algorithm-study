package codility.lesson2;

import java.util.HashSet;
import java.util.Set;

public class OddOccurrencesInArray {
    /**
     * 풀이 1 - 해시셋 이용
     */
    public int solution(int[] a) {
        if (a.length == 1) {
            return a[0];
        }

        Set<Integer> pairs = new HashSet<>();

        for (int number : a) {
            if (pairs.contains(number)) {
                pairs.remove(number);
            } else {
                pairs.add(number);
            }
        }

        return pairs.iterator()
                    .next();
    }

    /**
     * 풀이 2 - xor 연산 이용 (인터넷 참고)
     */
    public int solution2(int[] a) {
        int result = 0;
        for (int number : a) {
            result ^= number;
        }
        return result;
    }
}
