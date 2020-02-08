package boj.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * N이하 모든 소수 구하기 - 에라토스테네스의 체
 * 기존 소수구하던 O(sqrt(N)) 방법을 이용하면 N번 만큼 O(sqrt(N))를 반복하기때문에 시간복잡도는 O(N * sqrt(N))이 걸려 느리다.
 * 느리다의 기준은 N이 백만일경우 루트 N은 1000, N이 1억일경우 루트 N은 1만이다. 느리다고 볼 수 있다.
 * 더 빠른 방법은 에라토스테네스의 체를 이용하는 것이다.
 * 모든 배수를 다지우는 방법이다.
 * 지워지지 않은 수 중에서 가장 작은수는 2이다.
 * 2는 소수이고 2의 배수를 모두 지우고 그 다음 남은 수의 배수들을 지운다.
 * 2,3 같은 약수들은 다음 큰수들이 지울수 없기때문에 소수가 된다.
 */
public class Q1929 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(stringTokenizer.nextToken());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        br.close();

        int[] primes = getPrime(m, n);
        print(primes, m, n);
    }

    private static int[] getPrime(final int m, final int n) {
        int[] primes = new int[1000000];
        int primeCount = 0;
        boolean[] check = new boolean[primes.length + 1];

        for (int i = 2; i <= n; i++) {
            if (!check[i]) { // 지워지지 않았다면
                primes[primeCount++] = i;
                for (int j= i+i; j<=n; j+=i) {
                    check[j] = true;
                }
            }
        }
        return primes;
    }

    private static void print(final int[] primes, final int m, final int n) {
        for (int i=0; i<n; i++) {
            if (primes[i] >= m) {
                System.out.println(primes[i]);
            }
        }
    }
}
