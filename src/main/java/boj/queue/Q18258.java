package boj.queue;


import java.io.*;

public class Q18258 {
    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out))) {

            Queue queue = new Queue();
            int n = Integer.parseInt(bufferedReader.readLine());
            while (n-- > 0) {
                String[] split = bufferedReader.readLine().split(" ");
                switch (split[0]) {
                    case "empty" :
                        bufferedWriter.write(String.valueOf(queue.empty()));
                        bufferedWriter.newLine();
                        break;
                    case "size" :
                        bufferedWriter.write(String.valueOf(queue.size()));
                        bufferedWriter.newLine();
                        break;
                    case "front" :
                        bufferedWriter.write(String.valueOf(queue.getFirst()));
                        bufferedWriter.newLine();
                        break;
                    case "back" :
                        bufferedWriter.write(String.valueOf(queue.getLast()));
                        bufferedWriter.newLine();
                        break;
                    case "pop" :
                        bufferedWriter.write(String.valueOf(queue.remove()));
                        bufferedWriter.newLine();
                        break;
                    default :
                        queue.add(Integer.parseInt(split[1]));
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

class Queue {
    private Node first;
    private Node last;
    private int size;

    public Queue() {
    }

    public int empty() {
        if (isEmpty()) {
            return 1;
        }
        return 0;
    }

    public int size() {
        return size;
    }

    private boolean isEmpty() {
        return first == null && last == null;
    }

    public void add(int value) {
        Node already = last;
        Node newNode = new Node(already,null, value);
        last = newNode;

        if (first == null) {
            first = newNode;
        } else {
            already.next = newNode;
        }

        size++;
    }

    public int remove() {
        if (first == null) {
            return -1;
        }

        Node target = first;
        Node next = target.next;
        int element = target.value;

        target.value = null;
        target.next = null;
        first = next;

        if (next == null) {
            last = null;
        } else {
            next.prev = null;
        }
        size--;

        return element;
    }

    public int getFirst() {
        if (first == null) {
            return -1;
        }
        return first.value;
    }

    public int getLast() {
        if (last == null) {
            return -1;
        }
        return last.value;
    }

    private static class Node {
        Node prev;
        Node next;
        private Integer value;

        public Node(final Node prev, final Node next, final int value) {
            this.prev = prev;
            this.next = next;
            this.value = value;
        }
    }
}
