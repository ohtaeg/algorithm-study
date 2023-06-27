package inflearn.dfs;

/**
 * 자연수 N이 주어지면 1부터 N까지의 원소를 갖는 부분 집합을 모두 출력하는 프로그램 작성하시오
 * 첫번째 줄에 자연수 N(1 <= N <= 10) 이 주어진다.
 * 공집합은 출력하지 않으며, 첫번쨰 줄부터 각 줄에 하나씩 부분 집합을 아래와 같이 출력하시오
 * 1 2 3
 * 1 2
 * 1 3
 * 1
 * 2 3
 * 2
 * 3
 *
 * 부분 집합이란 3인 경우 1, 2, 3 원소에서 2^3 -1 = 7개가 나온다. (공집합 제외를 위해 -1)
 * {    1,     2,     3  }
 *    o | x  o | x  o | x
 *     { 2  *  2  *   2 } - 1
 *
 * 1을 root로 1도 사용하고 2도 사용하면 왼쪽, 2를 부분집합에 속하지 않으면 오른쪽으로
 *           1
 *       o /     \ x
 *        2       2
 *     o/  \x   o/  \x
 *     3    3   3    3
 *   o/  \x / \   ....
 *  4    4 4   4             -> 종료 조건
 *  root 값 ==  n + 1 (3+1 = 4) 이면 종료 조건
 *    이때 체크가 활성화 된 숫자들을 출력해준다.
 */
public class 부분집합구하기 {
    static int n;
    static boolean[] isUse; // 부분집합에 사용하는지 안하는지 체크 용도

    public static void dfs(int root) {
        // 종착점에 왔을 때
        if (root == n + 1) {
            String tmp = "";
            for (int i = 1; i <= n; i++) {
                if (isUse[i]) {
                    tmp += i + " ";
                }
            }
            if (tmp.length() > 0) {
                System.out.println(tmp);
            }
            return;
        }
        isUse[root] =  true;
        dfs(root + 1);
        isUse[root] =  false;
        dfs(root + 1);
    }

    public static void main(String[] args) {
        n = 3;
        isUse = new boolean[n + 1];
        dfs(1);
    }
}
