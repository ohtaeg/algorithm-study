package inflearn.dfs;

/**
 * 루트노드에서 말단 노드간 가장 짧은 길이를 구하기
 *          1
 *        /   \
 *       2     3
 *     /  \
 *    4   5
 *   가장 짧은 길이는 3번 노드까지 길이인 1이다.
 *   이 문제는 DFS 보다 BFS로 푸는게 더 빠름, DFS로 풀이
 */
public class 트리말단노드까지짧은경로 {

    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        System.out.println(tree.dfs(0, tree.root));
    }

    private static class Tree {
        Node root;

        public int dfs(int level, Node root) {
            if (root.left == null && root.right == null) {
                return level;
            }
            return Math.min(
                    dfs(level + 1, root.left),
                    dfs(level + 1, root.right)
            );
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
