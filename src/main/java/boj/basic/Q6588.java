package boj.basic;

import java.io.*;

/**
 * 골드바흐의 추측
 */
public class Q6588 {
    private static final String WRONG = "Goldbach's conjecture is wrong.";
    private static final int EXIT_0 = 0;
    private static final int N_MAX_SIZE = 1000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // get primes, get multipleChecks
        int[] primes = new int[N_MAX_SIZE];
        boolean[] multipleChecks = new boolean[N_MAX_SIZE + 1];
        int primeCount = 0;
        for (int i = 2; i <= N_MAX_SIZE; i++) {
            if (!multipleChecks[i]) {
                primes[primeCount++] = i;
            }
            for (int j = i + i; j <= N_MAX_SIZE; j += i) {
                multipleChecks[j] = true;
            }
        }

        int n;
        boolean isWrong;
        while (true) {
            isWrong = true;
            n = Integer.parseInt(br.readLine());
            if (n == EXIT_0) {
                break;
            }
            for (int i = 1; i < n; i++) {
                // n = a + b 일때, b - a가 최대값이려면 n - a = b를 구하면 된다.
                // n - a = b를 구할때 b가 소수인지 확인을 해주어야 한다.
                // ex) 12 = 3 + 9 둘다 홀수이지만 9는 소수가 아니기 때문 5 + 7이 b-a의 최대값이 된다.
                if (!multipleChecks[n - primes[i]]) {
                    isWrong = false;
                    bw.write(n + " = " + primes[i] + " + " + (n - primes[i]));
                    bw.write("\n");
                    bw.flush();
                    break;
                }
            }

            if (isWrong) {
                bw.write(WRONG);
                bw.write("\n");
                bw.flush();
            }
        }
        br.close();
        bw.flush();
        bw.close();
    }
}
