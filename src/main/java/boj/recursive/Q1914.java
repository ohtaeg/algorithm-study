package boj.recursive;

import java.io.*;
import java.math.BigInteger;

/**
 * Hanoi top
 * n == 1개일 때 기둥 1에서 기둥 3으로 옮긴다.
 * n == 2개일 때
 * 1. 기둥1에서 n-1개의 원판을 기둥3을 이용하여 기둥2로 옮긴다.
 * -> 가장 작은 원판이 1번에서 2번으로 옮겨진다. hanoi (1, from, to, by)
 * 2. 기둥1에서 남아있는 원판을 기둥 3으로 옮긴다.
 * -> 가장 큰 원판이 1번에서 3번으로 옮겨진다. print(from, to)
 * 3. 1번에서 옮겼던 n-1개의 원판을 기둥2에서 기둥1을 이용하여 기둥3으로 옮긴다.
 * -> 기둥2에 있는 가장 작은 원판이 기둥1을 거쳐 기둥3으로 옮긴다. hanoi(1, by, from, to)
 *
 * 움직이는 횟수는 2^n - 1만큼 움직인다. 만약 원판이 100개라면 움직이는 횟수는 long 범위를 넘어가는부분을 조심한다.
 */
public class Q1914 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        br.close();

        BigInteger moveCount = new BigInteger("2").pow(n).subtract(BigInteger.ONE);
        bw.write(String.valueOf(moveCount));
        bw.newLine();
        if (n <= 20) {
            hanoiRecursive(bw, n, "1", "2", "3");
        }
        bw.flush();
        bw.close();
    }

    private static void hanoiRecursive(final BufferedWriter bw, final int n, final String from, final String by, final String to) throws IOException {
        if (n == 1) {
            bw.write(from + " " + to + "\n");
        } else {
            hanoiRecursive(bw, n-1, from, to, by);
            bw.write(from + " " + to + "\n");
            hanoiRecursive(bw, n-1, by, from, to);
        }
    }
}
