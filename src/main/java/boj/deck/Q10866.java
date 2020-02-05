package boj.deck;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Deck
 */
public class Q10866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deck deck = new Deck();

        int count = Integer.parseInt(br.readLine());
        while (count-- > 0) {
            operate(deck, br.readLine());
        }

        br.close();
    }

    private static void operate(final Deck deck, String command) {
        int data = -1;
        if (command.contains(" ")) {
            data = Integer.parseInt(command.split(" ")[1]);
            command = command.split(" ")[0];
        }

        switch (command) {
            case "push_front" :
                deck.offerFirst(data);
                break;
            case "push_back" :
                deck.offerLast(data);
                break;
            case "pop_front" :
                System.out.println(deck.pollFirst());
                break;
            case "pop_back" :
                System.out.println(deck.pollLast());
                break;
            case "front" :
                System.out.println(deck.front());
                break;
            case "back" :
                System.out.println(deck.rear());
                break;
            case "size" :
                System.out.println(deck.size());
                break;
            case "empty" :
                System.out.println(deck.empty());
                break;
            default: throw new IllegalArgumentException(command);
        }
    }
}

class Deck {
    private Node front;
    private Node rear;
    private int size;

    public Deck() {
        this.front = null;
        this.rear = null;
        size = 0;
    }

    public void offerFirst(int data) {
        final Node currentFront = front;
        final Node newNode = new Node(null, data, currentFront);
        front = newNode;
        if (currentFront == null) {
            rear = newNode;
        } else {
            currentFront.prev = newNode;
        }
        size++;
    }

    public void offerLast(int data) {
        final Node currentRear = rear;
        final Node newNode = new Node(currentRear, data, null);
        rear = newNode;
        if (currentRear == null) {
            front = newNode;
        } else {
            currentRear.next = newNode;
        }
        size++;
    }

    public int pollFirst() {
        if (front == null) {
            return -1;
        }
        int data = front.data;
        Node nextNode = front.next;
        if (nextNode == null) {
            rear = null;
        } else {
            nextNode.prev = null;
        }

        front.next= null;
        front = nextNode;
        size--;
        return data;
    }

    public int pollLast() {
        if (rear == null) {
            return -1;
        }
        int data = rear.data;
        Node prevNode = rear.prev;
        if (prevNode == null) {
            front = null;
        } else {
            prevNode.next = null;
        }

        rear.prev = null;
        rear = prevNode;
        size--;
        return data;
    }

    public int size() {
        return size;
    }

    public int empty() {
        return size > 0 ? 0 : 1;
    }

    public int front() {
        if (front == null) {
            return -1;
        }
        return front.data;
    }

    public int rear() {
        if (rear == null) {
            return -1;
        }
        return rear.data;
    }

    private static class Node {
        Node prev;
        Node next;
        int data;

        public Node(final Node prev, final int data, final Node next) {
            this.prev = prev;
            this.data = data;
            this.next = next;
        }
    }
}
