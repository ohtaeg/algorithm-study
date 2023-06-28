package inflearn.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 넓이우선탐색 (레벨 탐색)
 *                      level (거리)
 *          1           0
 *        /   \
 *       2     3        1
 *     /  \   / \
 *    4   5  6   7      2
 *
 *  레벨 탐색 순회 출럭 : 1   2 3   4 5 6 7
 */
public class 이진트리순회 {

    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        tree.bfs(tree.root);
    }


    private static class Tree {
        Node root;

        public void bfs(Node root) {
            Queue<Node> queue = new LinkedList<>();
            int level = 0;
            queue.offer(root);

            while (!queue.isEmpty()) {
                int len = queue.size();
                System.out.println("level : " + level);

                // level에 해당하는 노드들이 다 출력된다.
                for (int i = 0; i < len; i++) {
                    Node current = queue.poll();
                    System.out.print(current.data + " ");
                    if (current.left != null) {
                        queue.offer(current.left);
                    }
                    if (current.right != null) {
                        queue.offer(current.right);
                    }
                }

                level++;
                System.out.println();
            }
        }
    }

    private static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
}
