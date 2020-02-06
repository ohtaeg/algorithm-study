package boj.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q10809 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] source = br.readLine().toCharArray();
        int[] counts = new int[26];
        br.close();

        Arrays.fill(counts, -1);
        for (int i=0; i<source.length; i++) {
            char ch = source[i];
            if (counts[ch - 'a'] == -1) {
                counts[ch - 'a'] = i;
            }
        }

        for (int count : counts) {
            System.out.print(count + " ");
        }
    }
}
