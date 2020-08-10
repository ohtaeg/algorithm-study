package boj.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 최대공약수 : 나눈 값들을 곱하면 된다.
 * 최소공배수 : 두 자연수를 곱하고 최대 공약수를 나눠주면 된다.
 *
 * 2개의 자연수를 받아 최대공약수를 받기 위해 2부터 두 자연수 중 작은 자연수까지 모두 나누어보면서 가장 큰 공약수를 구할 수 있다.
 * 위와 같은 방법으로 문제를 풀면 시간복잡도는 O(N)이 된다. 나쁜 방법은 아니지만 효율을 높이기 위해 유클리드 호제법이란 알고리즘을 사용하면 시간복잡도를 O(logN)으로 줄일 수 있다.
 *
 * 유클리드 호제법
 * 2개의 자연수 A, B에 대해서 A를 B로 나눈 나머지를 R이라 하면
 * A와 B의 최대공약수는 B와 R의 최대공약수와 같다.
 * 이 성질에 따라, B를 R로 나눈 나머지 R-0를 구하고, 다시 R을 R-0로 나눈 나머지를 구하는 과정을 반복하여
 * 나머지가 0이 되었을 때 A가 A와 B의 최대공약수이다
 */
public class Q2609 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(stringTokenizer.nextToken());
        int b = Integer.parseInt(stringTokenizer.nextToken());
        br.close();

        int gcd = recursiveGcd(a, b);
        System.out.println(gcd);

        int lcm = (a * b) / gcd;
        System.out.println(lcm);
    }

    private static int recursiveGcd(final int a, final int b) {
        if (b == 0) {
            return a;
        } else {
            return recursiveGcd(b, a%b);
        }
    }

    // O(nlogn)
    private static int gcd(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}
