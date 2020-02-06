package boj.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q10808 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] source = br.readLine().toCharArray();
        int[] counts = new int[26];
        br.close();

        for (char ch : source) {
            counts[ch - 'a'] += 1;
        }

        for (int count : counts) {
            System.out.print(count + " ");
        }
    }
}
