package boj.bruteforce.nm;

import java.util.Scanner;

/**
 * N과 M (1)
 *
 * 비어있는 리스트에서 수를 하나씩 추가하면서 길이가 M인 수열이 완성되면 출력하는 방식
 * 이 과정을 백트래킹을 이용하였다.
 *
 * 1. 모든 경우의 수를 탐색할때 중복되는 수를 제외하기 위해
 * 이미 방문한 노드(값)이라면 다음 노드를 탐색하도록 하기 위해(유망한 노드인지 검사하기 위해) M 크기의 boolean 배열을 생성
 *
 * 2. 탐색 과정에서 값을 담을 int 배열을 생성
 *
 * 3. depth를 통해 재귀가 깊어질 때마다 depth를 1씩 증가시켜 M과 같아지면 더이상 재귀를 호출하지 않고
 * 탐색과정 중 값을 담았던 arr 배열을 출력해주고 return 하는 역할을 위해서다.
 * depth가 의미하는것은 값이 담겨 있는 배열의 크기와 같다.
 *
 * 4. 재귀를 돌며 배열이 M만큼의 수열 값으로 채워지면 출력하고 되돌아간다.
 */
public class Q15649 {
    private static final boolean[] IS_VISITED = new boolean[9];
    private static final int[] NUMBERS = new int[9];
    private static final boolean VISIT = true;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int n = scanner.nextInt();
        final int m = scanner.nextInt();

        permute(n, m, 0);
    }

    private static void permute(final int n, final int m, final int depth) {
        if (depth == m) {
            print(m);
            return;
        }

        for (int i = 1; i <= n; i++) {
            // 해당 노드(값)을 방문하지 않았다면
            if (!IS_VISITED[i]) {
                IS_VISITED[i] = VISIT; // 해당 노드를 방문 상태로 변경
                NUMBERS[depth] = i;
                permute(n, m, depth + 1);
                IS_VISITED[i] = !VISIT;
            }
        }
    }

    private static void print(final int m) {
        for (int i = 0; i < m; i++) {
            System.out.print(NUMBERS[i] + " ");
        }
        System.out.println();
    }

    static long pow(int a, int b, int m) {
        long number = 1;
        while (b-- > 0) {
            number *= a;
        }
        return number % m;
    }

    static long pow2(int a, int b, int m) {
        if (b == 0) {
            return a % m;
        }

        long number = pow2(a, b / 2, m);
        number = number * number % m;

        if (number % 2 == 0) {
            return number;
        }
        return number * a % m;
    }
}
