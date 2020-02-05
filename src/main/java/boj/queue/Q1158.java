package boj.queue;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 조세푸스 순열
 * input : 7 3
 * output : <3 6 2 7 5 4 1>
 */
public class Q1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Queue<Integer> queue = new LinkedList<>();
        String input = br.readLine();
        int n = Integer.parseInt(input.split(" ")[0]);
        int k = Integer.parseInt(input.split(" ")[1]);

        for (int i=1; i<=n; i++) {
            queue.offer(i);
        }

        StringBuilder result = new StringBuilder();
        result.append("<");
        while (!queue.isEmpty()) {
            int temp;
            for (int j = 0; j < k; j++) {
                temp = queue.poll();
                if (j != k - 1) {
                    queue.offer(temp);
                } else {
                    result.append(temp);
                }
            }
            if (!queue.isEmpty()) {
                result.append(", ");
            }
        }
        result.append(">");
        br.close();
        bw.write(result.toString());
        bw.flush();
        bw.close();
    }
}
