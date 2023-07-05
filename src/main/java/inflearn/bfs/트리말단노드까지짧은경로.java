package inflearn.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 루트노드에서 말단 노드간 가장 짧은 길이를 구하기
 *          1
 *        /   \
 *       2     3
 *     /  \
 *    4   5
 *   가장 짧은 길이는 3번 노드까지 길이인 1이다.
 */
public class 트리말단노드까지짧은경로 {

    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        System.out.println(tree.bfs(tree.root));
    }

    private static class Tree {
        Node root;

        public int bfs(Node root) {
            Queue<Node> queue = new LinkedList<>();
            int level = 0;
            queue.offer(root);

            while (!queue.isEmpty()) {
                int len = queue.size();

                for (int i = 0; i < len; i++) {
                    final Node current = queue.poll();

                    if (current.left == null && current.right == null) {
                        return level;
                    }

                    if (current.left != null) {
                        queue.offer(current.left);
                    }
                    if (current.right != null) {
                        queue.offer(current.right);
                    }
                }
                level++;
            }

            return level;
        }
    }

    private static class Node {
        int data;
        Node left;
        Node right;

        public Node(final int data) {
            this.data = data;
        }
    }
}
