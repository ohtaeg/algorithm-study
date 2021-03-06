package boj.basic;

import java.util.Scanner;
import java.util.Stack;

/**
 * -2진수
 * 이 문제의 포인트는 나머지의 범위이다.
 * 나머지의 범위는 0 <= R < 나눈 수 이다.
 * 만약 -1 을 3으로 나눈 나머지를 구한다고 할때
 * -1 = 3 * Q + R이 성립이 되는데,
 * Q가 2라면 -1 = 3 * 2 + (-7), 나머지가 -가 되기 때문에 성립이 안된다.
 * Q가 1이라면 -1 = 3 * 1 + (-2), 역시 ㄴㄴ
 * Q가 0이라면 -1 = 3 * 0 + (-1), 역시 ㄴㄴ
 * Q가 -1이라면 -1 = 3 * (-1) + 2, 나머지 범위에 성립한다.
 * 결국 나누기는 빼기와 같다. 계속 빼는것.
 *
 * -2진수도 -2로 나눠 떨어지지 않을 경우 몫에 -1을 더해줘서 나머지가 양수가 되도록 한다.
 * X = -2 * Q(몫) + R (나머지)
 * X가 홀수라면 R은 무조건 1 ===> X = -2 * Q + R => Q = (X - 1) / -2
 * X가 짝수라면 R은 무조건 0 ===> X = -2 * Q + R => Q = (X) / -2
 *
 *     -2진수   몫           나머지
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
