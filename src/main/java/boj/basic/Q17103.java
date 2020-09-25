package boj.basic;

import java.util.Scanner;

/**
 * 골드바흐의 파티션
 */
public class Q17103 {
    private static final int MAX = 1_000_000;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int testCount = scanner.nextInt();
        final boolean[] isNotPrime = new boolean[MAX + 1];
        sieveOfEratosthenes(isNotPrime);

        for (int i = 0; i < testCount; i++) {
            System.out.println(getPartitionCount(scanner.nextInt(), isNotPrime));
        }
    }

    private static void sieveOfEratosthenes(final boolean[] isNotPrime) {
        isNotPrime[0] = true;
        isNotPrime[1] = true;
        for (int i = 2; i < MAX; i++) {
            // 해당 숫자가 소수가 아니면 배수는 소수가 아님 처리
            if (!isNotPrime[i]) {
                for (int j = i + i; j <= MAX; j += i) {
                    isNotPrime[j] = true;
                }
            }
        }
    }

    private static int getPartitionCount(final int n, final boolean[] isNotPrime) {
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (!isNotPrime[i] && i <= n - i) { // n = a + b 라고 할때 a만 검사하고 b는 검사하지 않도록 하여 중복해서 검사 안하도록
                if (!isNotPrime[n - i]) {
                    count++;
                }
            }
        }
        return count;
    }
}
