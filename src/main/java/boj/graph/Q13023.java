package boj.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * ABCDE
 * 이 문제는 다풀어놓고 depth가 주어진 관계의 갯수인줄 알고 계속 헛짓함
 */
public class Q13023 {
    private static boolean[] isFriend;
    private static List<Integer>[] graph;
    private static int n;
    private static int m;
    private static int friendRelationCount = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        isFriend = new boolean[n];
        graph = new List[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int friend = scanner.nextInt();
            int otherFriend = scanner.nextInt();
            graph[friend].add(otherFriend);
            graph[otherFriend].add(friend);
        }

        for (int i = 0; i < n; i++) {
            if (friendRelationCount == 0) {
                dfs(1, i);
            } else {
                break;
            }
        }
        System.out.println(friendRelationCount);
    }

    private static void dfs(final int depth, final int friendIndex) {
        if (depth == 5) {
            friendRelationCount = 1;
            return;
        }

        isFriend[friendIndex] = true;
        for (Integer index : graph[friendIndex]) {
            if (!isFriend[index]) {
                dfs(depth + 1, index);
            }
        }
        isFriend[friendIndex] = false;
    }
}
