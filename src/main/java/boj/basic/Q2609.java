package boj.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

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
