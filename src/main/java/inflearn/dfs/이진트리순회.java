package inflearn.dfs;

/**
 *          1
 *        /   \
 *       2     3
 *     /  \   / \
 *    4   5  6   7
 * 전위순회 : 부모 -> 왼쪽 자식 -> 오른쪽 자식 순
 *         1 2 4 5 3 6 7
 * 중위순회 : 왼쪽 자식 -> 부모 -> 오른쪽 자식 순
 *         4 2 5 1 6 3 7
 * 후위순회 : 왼쪽 자식 -> 오른쪽 자식 -> 부모 순
 *         4 5 2 6 7 3 1
 *         후위순회는 병합정렬에서 사용한다.
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
        tree.dfs(tree.root);
    }

    private static class Tree {
        Node root;

        public void dfs(Node root) {
            if (root == null) {
                return;
            }
            // System.out.print(root.data + " "); // 전위 순회
            dfs(root.left);
            // System.out.print(root.data + " "); // 중위 순회
            dfs(root.right);
            System.out.print(root.data + " "); // 후위 순회
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


