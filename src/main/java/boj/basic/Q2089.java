package boj.basic;

import java.util.Scanner;
import java.util.Stack;

/**
 * -2진수
 * 이 문제의 포인트는 자바는 -3 / 2 할때 몫이 -1이 된다.
 * -3 / 2 => -1.5 => -1 즉, 소수점을 버려버린다.
 * -2로 나눠 떨어지지 않을 경우 몫에 -1을 더해줘서 나머지가 양수가 되도록 한다.
 *      -2진수   몫           나머지
 * -3 = -2  *  (2)  = -4   + 1
 * +2 = -2  *  (-1) =  2   + 0
 * -1 = -2  *  (1)  = -2   + 1
 *  1 = -2  *  (0)  =  0   + 1
 * -3 = 1101
 */
public class Q2089 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(calculateMinusBinary(scanner.nextInt()));
    }

    private static String calculateMinusBinary(int input) {
        StringBuilder result = new StringBuilder();
        Stack<Integer> stack = new Stack();

        if (input == 0) {
            return "0";
        }

        while (input != 0) {
            if (input % -2 == 0) {
                stack.push(0);
                input /= -2;
            } else {
                stack.push(1);
                input = (input - 1) / -2;
            }
        }

        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        return result.toString();
    }
}
