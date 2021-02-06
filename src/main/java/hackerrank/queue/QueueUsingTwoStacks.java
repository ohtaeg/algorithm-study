package hackerrank.queue;

import java.util.Scanner;
import java.util.Stack;

/**
 * 값을 push 할때마다 다른 스택으로 옮기면 시간초과가 발생한다.
 * pop할때나 출력할때만 정렬된 값들을 보관하는 오른쪽 스택이 비어있을때 다 옮겨주도록 한다.
 */
public class QueueUsingTwoStacks {
    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        Scanner scanner = new Scanner(System.in);
        int q = scanner.nextInt();

        while (q-- > 0) {
            int type = scanner.nextInt();
            if (type == 1) {
                int x = scanner.nextInt();
                queue.offer(x);
            } else if (type == 2) {
                queue.poll();
            } else {
                queue.print();
            }
        }
    }

    private static class MyQueue {
        private final Stack<Integer> left;
        private final Stack<Integer> right;

        public MyQueue() {
            this.left = new Stack<>();
            this.right = new Stack<>();
        }

        public void offer(final int x) {
            left.push(x);
        }

        public void poll() {
            pushAll();
            right.pop();
        }

        public void print() {
            pushAll();
            System.out.println(right.peek());
        }

        private void pushAll() {
            if (right.isEmpty()) {
                while (!left.isEmpty()) {
                    right.push(left.pop());
                }
            }
        }
    }
}
