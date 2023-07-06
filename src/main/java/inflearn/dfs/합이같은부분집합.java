package inflearn.dfs;

import java.util.Scanner;

/**
 * https://cote.inflearn.com/contest/10/problem/08-01
 *
 * total - subset.sum == sum
 * 전체 합에서 부분집합의 합을 뺐는데 합이 같으면 합이 같은 부분 집합이다.
 */
public class 합이같은부분집합 {
    static int n, total = 0;
    static String answer = "NO";
    static int[] arr;
    boolean isFinish = false; // 부분 합이 일치하면 남은 재귀들을 리턴을 위한 플래그 값

    public String dfs(int level, int sum) {
        if (isFinish) {
            return answer;
        }

        if (sum > total / 2) {
            return answer;
        }

        if (level == n) {
            if (total - sum == sum) {
                answer = "YES";
                isFinish = true;
                return answer;
            }
        } else {
            dfs(level + 1, sum + arr[level]);
            dfs(level + 1, sum);
        }

        return answer;
    }

    public static void main(String[] args) {
        합이같은부분집합 main = new 합이같은부분집합();

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            total += arr[i];
        }

        System.out.println(main.dfs(0, 0));
    }
}
