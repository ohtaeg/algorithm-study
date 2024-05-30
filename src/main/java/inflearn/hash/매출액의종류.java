package inflearn.hash;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * hash + sliding window
 *
 * 현수의 아빠는 제과점을 운영합니다. 현수아빠는 현수에게 N일 동안의 매출기록을 주고 연속된 K일 동안의 매출액의 종류를
 * 각 구간별로 구하라고 했습니다.
 * 만약 N=7이고 7일 간의 매출기록이 아래와 같고, 이때 K=4이면
 * 20 12 20 10 23 17 10
 * 각 연속 4일간의 구간의 매출종류는
 * 첫 번째 구간은 [20, 12, 20, 10]는 매출액의 종류가 20, 12, 10으로 3이다.
 * 두 번째 구간은 [12, 20, 10, 23]는 매출액의 종류가 4이다.
 * 세 번째 구간은 [20, 10, 23, 17]는 매출액의 종류가 4이다.
 * 네 번째 구간은 [10, 23, 17, 10]는 매출액의 종류가 3이다.
 * N일간의 매출기록과 연속구간의 길이 K가 주어지면 첫 번째 구간부터 각 구간별
 * 매출액의 종류를 출력하는 프로그램을 작성하세요.
 *
 * 7 4
 * 20 12 20 10 23 17 10
 *
 * 3 4 4 3
 */
public class 매출액의종류 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int k = scanner.nextInt();

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        System.out.println(solution(a, k));
    }

    private static String solution(int[] profits, int k) {
        Map<Integer, Integer> record = new HashMap<>();
        StringBuilder result = new StringBuilder();
        int left = 0;
        int right = k - 1;

        for (int i = left; i < right; i++) {
            record.put(profits[i], record.getOrDefault(profits[i], 0) + 1);
        }
        for (; right < profits.length; right++, left++) {
            record.put(profits[right], record.getOrDefault(profits[right], 0) + 1);
            result.append(record.size()).append(" ");

            if (record.containsKey(profits[left])) {
                record.put(profits[left], record.get(profits[left]) - 1);
                if (record.get(profits[left]) == 0) {
                    record.remove(profits[left]);
                }
            }
        }

        return result.toString();
    }
}
