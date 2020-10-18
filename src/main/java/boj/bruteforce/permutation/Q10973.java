package boj.bruteforce.permutation;

import java.util.*;

/**
 * 이전 순열
 */
public class Q10973 {
    private static final int LAST = 1;
    private static int n;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        final List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            numbers.add(scanner.nextInt());
        }
        System.out.println(findBeforePermutation(numbers));
    }

    private static String findBeforePermutation(final List<Integer> numbers) {
        StringBuilder result = new StringBuilder();
        for (int i = n - 1; i > 0; i--) {
            // 더이상 이전 순열이 존재하지 않다면
            if (isNotExistBeforePermutationAnymore(i, numbers)) {
                result.append("-1");
                return result.toString();
            }

            final int before = i - 1;
            if (hasBeforePermutation(numbers.get(before), numbers.get(i))) {
                getBeforePermutation(numbers, before, i);
                break;
            }
        }
        return getResult(result, numbers);
    }

    private static boolean isNotExistBeforePermutationAnymore(final int index, final List<Integer> numbers) {
        return index == LAST && !hasBeforePermutation(numbers.get(index - LAST), numbers.get(index));
    }

    private static boolean hasBeforePermutation(final int before, final int k) {
        return before > k;
    }

    private static void getBeforePermutation(final List<Integer> numbers, final int before, final int index) {
        Collections.sort(numbers.subList(before, n), Collections.reverseOrder());

        for (int j = index; j < n; j++) {
            if (numbers.get(before) > numbers.get(j)) {
                swap(numbers, before, j);
                break;
            }
        }
    }

    private static void swap(final List<Integer> numbers, int i, int j) {
        int temp = numbers.get(i);
        numbers.set(i, numbers.get(j));
        numbers.set(j, temp);
    }

    private static String getResult(final StringBuilder result, final List<Integer> numbers) {
        for (int i = 0; i < n; i++) {
            result.append(numbers.get(i) + " ");
        }
        return result.toString();
    }
}
