package boj.queue;

import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.Queue;

public class Q11866 {
    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out))) {

            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int n = Integer.parseInt(stringTokenizer.nextToken());
            int k = Integer.parseInt(stringTokenizer.nextToken());

            StringBuilder result = new StringBuilder("<");

            Queue<Integer> queue = initQueue(n);
            int count = 0;
            while (queue.size() != 1) {
                count ++;
                if (count % k == 0) {
                    result.append(queue.poll());
                    result.append(", ");
                } else {
                    queue.offer(queue.poll());
                }
            }

            result.append(queue.poll());
            bufferedWriter.write(result.toString() + ">");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Queue initQueue(final int n) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            queue.offer(i);
        }
        return queue;
    }
}
