package codility.lesson2;

import java.util.ArrayDeque;
import java.util.Deque;

public class CyclicRotation {
    /**
     * 풀이 1 - Deque 이용
     */
    public int[] solution(int[] a, int k) {
        final int length = a.length;
        if (k == length || a == null || a.length == 0) {
            return a;
        }

        Deque<Integer> deque = new ArrayDeque<>();
        for (int number : a) {
            deque.offer(number);
        }

        while (k-- > 0) {
            int right = deque.pollLast();
            deque.offerFirst(right);
        }

        final int[] result = new int[a.length];
        int index = 0;
        while (!deque.isEmpty()) {
            result[index++] = deque.poll();
        }

        return result;
    }

    /**
     * 풀이 2 - 배열 내에서 규칙적으로 k만큼 이동
     */
    public int[] solution2(int[] a, int k) {
        final int length = a.length;
        final int[] result = new int[length];

        for (int i = 0; i < length; i++) {
            int index = (k + i) % length;
            result[index] = a[i];
        }

        return result;
    }
}
