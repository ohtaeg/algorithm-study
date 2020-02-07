package boj.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * LCM
 */
public class Q1934 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());

        String source;
        int a = -1;
        int b = -1;
        int gcd = -1;
        while (count-- > 0) {
            source = br.readLine();
            a = Integer.parseInt(source.split(" ")[0]);
            b = Integer.parseInt(source.split(" ")[1]);

            gcd = gcd(a, b);
            System.out.println((a * b) / gcd);
        }
        br.close();
    }

    private static int gcd(final int a, final int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a%b);
        }
    }
}
