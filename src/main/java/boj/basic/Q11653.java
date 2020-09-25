package boj.basic;

import java.util.Scanner;

public class Q11653 {
    private static final int MAX = 10_000_000;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final boolean[] isNotPrime = new boolean[MAX + 1];
        final int data = scanner.nextInt();

        sieveOfEratosthenes(isNotPrime);
        calculatePrimeFactorization(isNotPrime, data);
    }

    private static void calculatePrimeFactorization(final boolean[] isNotPrime, int data) {
        int index = 2;
        while (data > 1) {
            if (!isNotPrime[index] && data % index == 0) {
                data /= index;
                System.out.println(index);
            } else {
                index++;
            }
        }
    }

    private static void sieveOfEratosthenes(final boolean[] isNotPrime) {
        isNotPrime[0] = true;
        isNotPrime[1] = true;
        for (int i = 2; i <= MAX; i++) {
            if (!isNotPrime[i]) {
                for (int j = i + i; j <= MAX; j += i) {
                    isNotPrime[j] = true;
                }
            }
        }
    }
}
