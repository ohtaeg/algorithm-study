package boj.queue;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Q2164 {
    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out))) {

            int n = Integer.parseInt(bufferedReader.readLine());
            Queue<Integer> queue = initQueue(n);

            while (!isLastCard(queue.size())) {
                queue.poll();
                if (isLastCard(queue.size())) {
                    break;
                }
                queue.offer(queue.poll());
            }

            bufferedWriter.write(String.valueOf(queue.poll()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean isLastCard(final int size) {
        return size == 1;
    }

    private static Queue<Integer> initQueue(final int size) {
        Queue<Integer> queue = new LinkedList();
        for (int i = 1; i <= size; i++) {
            queue.offer(i);
        }
        return queue;
    }
}
