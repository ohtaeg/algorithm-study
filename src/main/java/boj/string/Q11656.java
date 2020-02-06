package boj.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q11656 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String source = br.readLine();
        br.close();

        StringBuilder builder = new StringBuilder();
        String[] suffixes = new String[source.length()];

        for (int i=0; i<source.length(); i++) {
            suffixes[i] = source.substring(i);
        }

        // TODO : Refactoring - .sort()를 이용하지 말고 직접 문자열 정렬을 해보자.
        Arrays.sort(suffixes);

        for (int i=0; i<source.length(); i++) {
            builder.append(suffixes[i]).append("\n");
        }
        System.out.println(builder.toString());
    }
}
