package boj.stack;


import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * Right Big Number2
 */
public class Q17299 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int size = Integer.parseInt(br.readLine());
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        br.close();

        int[] inputs = new int[size];
        int[] counts = new int[1000001];
        int[] results = new int[size];
        int count = 0;
        int index;
        while (stringTokenizer.hasMoreTokens()) {
            index = Integer.parseInt(stringTokenizer.nextToken());
            inputs[count++] = index;
            counts[index] += 1;
        }

        Stack<Integer> indexStack = new Stack<>();
        indexStack.push(0);
        for (int i = 1; i < size; i++) {
            while (!indexStack.isEmpty() && counts[inputs[i]] > counts[inputs[indexStack.peek()]]) {
                results[indexStack.pop()] = inputs[i];
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
