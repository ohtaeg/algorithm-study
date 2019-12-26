package programmers.level2.printer;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public int solution(int[] priorities, int location) {
        return print(priorities, location);
    }

    public int print(int[] priorities, int location) {
        Queue<Integer> printer = createPriorityQueue(priorities);
        int order = 1;

        // 1. 우선순위 값을 찾는다.
        // 2. 우선순위 값에 있는 인덱스가 location인지 확인한다.
        // 3. 아닐 경우 poll후 return값 증가
        while (!printer.isEmpty()) {
            for (int i = 0; i<priorities.length; i++) {
                if (priorities[i] == printer.peek()) {
                    if (i == location) {
                        return order;
                    }
                    printer.poll();
                    order++;
                }
            }
        }
        return order;
    }

    private Queue<Integer> createPriorityQueue(final int[] priorities) {
        Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        for (int i=0 ;i<priorities.length; i++) {
            queue.offer(priorities[i]);
        }

        return queue;
    }
}
