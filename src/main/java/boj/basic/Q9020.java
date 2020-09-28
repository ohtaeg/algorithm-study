package boj.basic;

import java.io.*;

/**
 * 골드바흐의 추측, N = A+B일때 B-A가 최소인 경우를 구하는 문제
 */
public class Q9020 {
    private static final int MAX_SIZE = 10000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        boolean[] multipleChecks = new boolean[MAX_SIZE + 1];

        for (int i = 2; i < MAX_SIZE; i++) {
            for (int j = i * 2; j <= MAX_SIZE; j += i) {
                multipleChecks[j] = true;
            }
        }

        int t = Integer.parseInt(br.readLine());
        int n;
        while (t-- > 0) {
            n = Integer.parseInt(br.readLine());
            // 짝수 N을 절반으로 나누면 두 소수 차이가 가장 작아진다.
            // 절반인 두 숫자 로부터 소수인지 판별하여 두 숫자가 다 소수일경우 출력 아닐경우 -- ++ 하여 재비교,
            for (int i = n / 2, j = n / 2; i >= 1; i--, j++) {
                if (!multipleChecks[i] && !multipleChecks[j]) {
                    bw.write(i + " " + j);
                    bw.write("\n");
                    bw.flush();
                    break;
                }
            }
        }
        br.close();
        bw.flush();
        bw.close();
    }
}
