package book.part3.sort;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 카드 정렬
 * 이 문제는 단순하게 더하면 원하는 값이 안나옴
 * 10,20,40이 있을떄
 * 20 = 10 + 20
 * 40 = 10 + 20 + 40
 * 이중 포문으로 이전 값을 더하면 나올 것 같지만 반례가 있음
 * 10, 10, 10, 10이 있다면
 * (10 + 10) + (20 + 10) + (30 + 10) = 90 이 아닌
 * (10 + 10) + (10 + 10) + (20 + 20) = 80이 나와야함
 */
public class CardSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int n = scanner.nextInt();
        PriorityQueue<Integer> queue = new PriorityQueue<>(n);
        for (int i = 0; i < n; i++) {
            queue.offer(scanner.nextInt());
        }

        System.out.println(addNumberOfTimes(queue, n));
    }

    private static int addNumberOfTimes(final PriorityQueue<Integer> queue, final int n) {
        int result = 0;

        if (n == 1) {
            return 0;
        }

        while (queue.size() > 1) {
            int firstValue = queue.poll();
            int secondValue = queue.poll();
            int sum = firstValue + secondValue;
            result += sum;
            queue.offer(sum);
        }

        return result;
    }
}
