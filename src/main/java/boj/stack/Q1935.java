package boj.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * Postfix Notation 2
 */
public class Q1935 {
    private static final char ASCII_A = 'A';
    private static final char PLUS_OPERATOR = '+';
    private static final char MINUS_OPERATOR = '-';
    private static final char MULTIPLE_OPERATOR = '*';
    private static final char DIVIDE_OPERATOR = '/';

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Double> operandStack = new Stack<>();
        int size = Integer.parseInt(br.readLine());
        double[] inputs = new double[size];
        char[] source = br.readLine().toCharArray();

        for (int i=0; i<size; i++) {
            inputs[i] = Integer.parseInt(br.readLine());
        }

        for (char ch : source) {
            if (isOperator(ch)) {
                operandStack.push(calculate(operandStack.pop(), ch, operandStack.pop()));
            } else {
                operandStack.push(inputs[ch - ASCII_A]);
            }
        }

        System.out.format("%.2f", operandStack.peek());
    }

    private static boolean isOperator(final char letter) {
        switch (letter) {
            case PLUS_OPERATOR :
            case MINUS_OPERATOR :
            case MULTIPLE_OPERATOR :
            case DIVIDE_OPERATOR :
                return true;
            default:
                return false;
        }
    }

    private static double calculate(final Double postOperand, final char operator, final Double preOperand) {
        double result;
        switch (operator) {
            case PLUS_OPERATOR :
                result = preOperand + postOperand;
                break;
            case MINUS_OPERATOR :
                result = preOperand - postOperand;
                break;
            case MULTIPLE_OPERATOR :
                result = preOperand * postOperand;
                break;
            case DIVIDE_OPERATOR :
                result = preOperand / postOperand;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + operator);
        }
        return result;
    }
}
