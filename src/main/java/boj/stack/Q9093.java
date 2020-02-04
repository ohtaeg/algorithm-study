package boj.stack;

import java.io.*;
import java.util.Stack;

/**
 * reverse string
 * I am Happy -> I ma yppah
 * we want to -> ew tnaw ot
 */
public class Q9093 {
    private static final String SPACE = " ";
    private static final String ENTER = "\n";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<String> stack = new Stack();
        int count = Integer.parseInt(br.readLine());

        String content;
        String letter;
        while (count-- > 0) {
            content = br.readLine() + ENTER;
            for (char ch : content.toCharArray()) {
                letter = String.valueOf(ch);
                if (letter.equals(SPACE) || letter.equals(ENTER)) {
                    while (!stack.isEmpty()) {
                        bw.write(stack.pop());
                    }
                    bw.write(letter);
                } else {
                    stack.push(letter);
                }
            }
            bw.flush();
        }

        br.close();
        bw.close();
    }
}
