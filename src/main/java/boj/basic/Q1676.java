package boj.basic;

import java.io.*;

public class Q1676 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        br.close();

        int fiveCount = 0;
        for (int i = 1; i <= n; i++) {
            if (i % 5 == 0) {
                fiveCount++;
            }
            // 25 50 75 100... (5*5*1, 5*5*2, 5*5*3, 5*5*4)
            if (i % 25 == 0) {
                fiveCount++;
            }

            // 125... (5*5*5*1...)
            if (i % 125 == 0) {
                fiveCount++;
            }
        }

        bw.write(fiveCount + "\n");
        bw.flush();
        bw.close();
    }
}
