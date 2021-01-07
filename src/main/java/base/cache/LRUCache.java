package base.cache;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    private static final int NOT_EXIST = -1;
    private final int capacity;
    private final Map<Integer, Node> nodes;
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        this.head = null;
        this.tail = null;
        this.capacity = capacity;
        this.nodes = new HashMap<>();
    }

    public void put(final int key, final int value) {
        if (get(key) != NOT_EXIST) {
            nodes.get(key).value = value;
            print();
            return;
        }

        Node newNode = new Node(key, value);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        nodes.put(key, newNode);

        if (nodes.size() > capacity) {
            nodes.remove(tail.key);
            tail.prev.next = null;
            tail = tail.prev;
        }
        print();
    }

    public int get(final int key) {
        if (!nodes.containsKey(key)) {
            return NOT_EXIST;
        }

        final Node node = nodes.get(key);
        updateHead(node);
        print();
        return node.value;
    }

    private void updateHead(final Node node) {
        if (node != head) {
            if (node == tail) {
                tail = node.prev;
            }

            if (node.prev != null) {
                node.prev.next = node.next;
            }

            if (node.next != null) {
                node.next.prev = node.prev;
            }

            node.next = head;
            head.prev = node;
            node.prev = null;
            head = node;
        }
    }

    private void print() {
        Node node = head;
        while (node != null) {
            System.out.print(node + " - ");
            node = node.next;
        }
        System.out.println();
    }

    private static class Node {

        private int key;
        private int value;
        private Node prev;
        private Node next;

        public Node(final int key, final int value) {
            this.key = key;
            this.value = value;
            this.prev = null;
            this.next = null;
        }

        @Override
        public String toString() {
            return "(" + key + ", " + value + ")";
        }
    }
}
