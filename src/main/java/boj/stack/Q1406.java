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

    public static void main(String[] args) throws IOException {
        Stack<String> sourceStack = new Stack<>();
        Stack<String> leftStack = new Stack<>();

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out))) {

            pushSourcesInStack(bufferedReader.readLine(), sourceStack);

            int commandCount = Integer.parseInt(bufferedReader.readLine());
            while (commandCount-- > 0) {
                String command = bufferedReader.readLine();
                executeCommand(command, sourceStack, leftStack);
            }

            reArrange(sourceStack, leftStack);
            bufferedWriter.write(getResult(leftStack));
        }
    }

    private static void pushSourcesInStack(final String source, final Stack<String> sourceStack) {
        for (int i = 0; i< source.length(); i++) {
            sourceStack.push(source.substring(i, i + 1));
        }
    }

    private static void executeCommand(final String command, final Stack<String> sourceStack, final Stack<String> leftStack) {
        switch (command) {
            case L :
                if (!sourceStack.isEmpty()) {
                    leftStack.push(sourceStack.pop());
                }
                break;
            case D :
                if (!leftStack.isEmpty()) {
                    sourceStack.push(leftStack.pop());
                }
                break;
            case B :
                if (!sourceStack.isEmpty()) {
                    sourceStack.pop();
                }
                break;
            default :
                sourceStack.push(command.split(" ")[1]);
        }
    }

    private static void reArrange(final Stack<String> sourceStack, final Stack<String> leftStack) {
        while (!sourceStack.isEmpty()) {
            leftStack.push(sourceStack.pop());
        }
    }

    private static String getResult(final Stack<String> stack) {
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        return result.toString();
    }
}
