package boj.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q10824 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        br.close();
        long preNumber = Long.parseLong(stringTokenizer.nextToken() + stringTokenizer.nextToken());
        long postNumber= Long.parseLong(stringTokenizer.nextToken() + stringTokenizer.nextToken());

        System.out.println(preNumber + postNumber);
    }
}
