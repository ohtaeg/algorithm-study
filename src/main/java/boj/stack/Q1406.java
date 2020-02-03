package boj.stack;

import java.io.*;
import java.util.Stack;

/**
 * editor
 * L   -> ab|cd => a|bcd
 * D   -> ab|cd => abc|d
 * B   -> ab|cd => a|cd
 * p e -> ab|cd => abe|cd
 */
public class Q1406 {
    private static final String L = "L";
    private static final String D = "D";
    private static final String B = "B";
    private static final String P = "P";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<String> leftStack = new Stack();
        Stack<String> rightStack = new Stack();
        String command = null;
        int commandCount = -1;

        // 한문자씩 쪼개서 leftStack에 push
        String source = br.readLine();
        for (char ch : source.toCharArray()) {
            leftStack.push(String.valueOf(ch));
        }

        // 명렁어 갯수만큼 반복
        commandCount = Integer.parseInt(br.readLine());
        while (commandCount-- > 0) {
            command = br.readLine();
            // 왼쪽으로 커서를 옮기되, 왼쪽스택이 비어있지 않을때만 커서 이동
            if (L.equals(command) && !leftStack.isEmpty()) {
                rightStack.push(leftStack.pop());
            // 오른쪽으로 커서를 옮기되, 오른쪽 스택이 비어있지 않을때만 커서 이동
            } else if (D.equals(command) && !rightStack.isEmpty()) {
                leftStack.push(rightStack.pop());
            // 왼쪽 스택에 값이 있을때만 remove
            } else if (B.equals(command) && !leftStack.isEmpty()) {
                leftStack.pop();
            } else if (P.equals(command.split(" ")[0])){
                leftStack.push(command.split(" ")[1]);
            }
        }

        // move leftstack -> rightstack
        while (!leftStack.isEmpty()) {
            rightStack.push(leftStack.pop());
        }

        // result
        StringBuilder result = new StringBuilder();
        while (!rightStack.isEmpty()) {
            result.append(rightStack.pop());
        }

        br.close();
        bw.write(result.toString());
        bw.flush();
        bw.close();
    }
}
