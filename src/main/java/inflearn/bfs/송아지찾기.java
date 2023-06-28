package inflearn.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://cote.inflearn.com/contest/10/problem/07-08
 *              5
 *            /  |  \
 *          4   6   10
 *          ...
 * 상태트리 만들면서 중복되는 값은 만들지 않고 하면 풀림
 */
public class 송아지찾기 {
    int[] distances = {-1, 1, 5};
    boolean[] isVisit = new boolean[10001];
    Queue<Integer> queue = new LinkedList<>();

    public int bfs(int s, int e) {
        int level = 0;
        isVisit[s] = true;
        queue.offer(s);

        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                int x = queue.poll();

                if (x == e) {
                    return level;
                }

                for (int distance : distances) {
                    int nx = x + distance;
                    if (nx == e) {
                        return level + 1;
                    }
                    if (nx >= 1 && nx <= 10000 && !isVisit[nx]) {
                        queue.offer(nx);
                        isVisit[nx] = true;
                    }
                }
            }
            level++;
        }
        return 0;
    }

    public static void main(String[] args) {
        송아지찾기 solution = new 송아지찾기();
        System.out.println(solution.bfs(5, 14));
    }

}
