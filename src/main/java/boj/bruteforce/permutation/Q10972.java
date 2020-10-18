package boj.bruteforce.permutation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 다음 순열
 * 주어진 숫자의 다음 순열을 출력하는 문제
 * - 1 2 3 4 -> 1 2 4 3
 * 주어진 숫자가 마지막 순열일 경우 -1을 출력
 *
 * 1. 마지막 순열인지 파악
 *  - 마지막 순열인지 어떻게 알까?
 *  - 5 4 3 2 1 => 숫자가 계속 내림차순 일 경우
 */
public class Q10972 {
    private static final String LAST_PERMUTATION = "-1";
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int n = scanner.nextInt();
        final List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            numbers.add(scanner.nextInt());
        }

        final String result = getNextPermutation(numbers);
        System.out.println(result);

    }

    private static String getNextPermutation(final List<Integer> numbers) {
        StringBuilder result = new StringBuilder();

        if (numbers.size() == 1) {
            result.append(LAST_PERMUTATION);
            return result.toString();
        }

        for (int i = numbers.size() - 1; i > 0; i--) { // 3 2 1
            if (isLastPermutation(numbers, i)) {
                result.append(LAST_PERMUTATION);
                break;
            }

            if (canNext(numbers.get(i - 1), numbers.get(i))) {
                Collections.sort(numbers.subList(i, numbers.size()));

                for (int j = i; j < numbers.size(); j++) {
                    if (numbers.get(i - 1) < numbers.get(j)) {
                        swap(numbers, i - 1, j);
                        break;
                    }
                }

                printResult(numbers, result);
                break;
            }
        }
        return result.toString();
    }

    private static boolean isLastPermutation(final List<Integer> numbers, final int index) {
        return index == 1 && !canNext(numbers.get(index - 1), numbers.get(index));
    }

    private static boolean canNext(final int beforeK, final int k) {
        return beforeK < k;
    }

    private static void swap(final List<Integer> numbers, final int i, final int j) {
        int temp = numbers.get(i);
        numbers.set(i, numbers.get(j));
        numbers.set(j, temp);
    }

    private static void printResult(final List<Integer> numbers, final StringBuilder result) {
        for (int number : numbers) {
            result.append(number + " ");
        }
    }
}
