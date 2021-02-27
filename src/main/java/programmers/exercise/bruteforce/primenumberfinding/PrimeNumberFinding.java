package programmers.exercise.bruteforce.primenumberfinding;

import java.util.HashSet;
import java.util.Set;

/**
 * 1. 주어진 배열 값으로 순열 찾기
 * 2. 소수 판별
 */
public class PrimeNumberFinding {
    private static final Set<Integer> SET = new HashSet<>();
    private static final boolean[] IS_VISITED = new boolean[9];
    private static final boolean VISIT = true;

    public int solution(String source) {
        final int[] numbers = new int[source.length()];
        final int[] permutations = new int[source.length()];
        for (int i = 0; i < source.length(); i++) {
            numbers[i] = source.charAt(i) - '0';
        }

        for (int m = 0; m < source.length(); m++) {
            permute(numbers, permutations, m + 1, 0);
        }

        return getPrimeNumberCount();
    }

    private void permute(final int[] numbers, final int[] permutations, final int m, final int depth) {
        if (depth == m) {
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < depth; i++) {
                result.append(permutations[i]);
            }
            SET.add(Integer.parseInt(result.toString()));
            return;
        }

        for (int i = 0; i < numbers.length; i++) {
            if (!IS_VISITED[i]) {
                IS_VISITED[i] = VISIT;
                permutations[depth] = numbers[i];
                permute(numbers, permutations, m, depth + 1);
                IS_VISITED[i] = !VISIT;
            }
        }
    }

    private int getPrimeNumberCount() {
        int count = 0;
        for (int number : SET) {
            if (isPrime(number)) {
                count++;
            }
        }
        return count;
    }

    private boolean isPrime(final int number) {
        if (number < 2) {
            return false;
        } else {
            for (int i = 2; i <= number / 2; i++) {
                if (number % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }
}
