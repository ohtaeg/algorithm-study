package boj.stack;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * Right Big Number
 */
public class Q17298 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int size = Integer.parseInt(br.readLine());
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        br.close();

        int[] inputs = new int[size];
        int[] results = new int[size];
        int count = 0;
        while (stringTokenizer.hasMoreTokens()) {
            inputs[count++] = Integer.parseInt(stringTokenizer.nextToken());
        }

        Stack<Integer> indexStack = new Stack<>();
        indexStack.push(0);
        for (int i = 1; i < size; i++) {
            while (!indexStack.isEmpty() && inputs[i] > inputs[indexStack.peek()]) {
                results[indexStack.peek()] = inputs[i];
                indexStack.pop();
            }
            indexStack.push(i);
        }

        while (!indexStack.isEmpty()) {
            results[indexStack.pop()] = -1;
        }

        for(int result : results) {
            bw.write(result + " ");
        }
        bw.flush();
        bw.close();
    }
}
