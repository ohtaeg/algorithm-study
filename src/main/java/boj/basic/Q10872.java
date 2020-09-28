package boj.basic;

import java.io.*;

public class Q10872 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        br.close();

        long sum = 1;
        for (int i = 1; i <= n; i++) {
            sum *= i;
        }

        bw.write(sum + "\n");
        bw.flush();
        bw.close();
    }
}
