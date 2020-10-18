package boj.bruteforce.nm;

import java.util.Arrays;
import java.util.Scanner;

/**
 * N과 M (9)
 * 입력값에 중복되는 숫자가 들어온다.
 * 중복되는 수열 출력 x
 * 4 2
 * 9 7 9 1
 *
 * 1 7
 * 1 9
 * 7 1
 * 7 9
 * 9 1
 * 9 7
 * 9 9
 *
 * 중복되는 수열을 어떻게 제거할까 하다가
 * 우선 기본 순열 알고리즘을 이용한다음
 * 지역변수로 이미 사용한 숫자는 사용 못하도록 표시하는 배열을 생성해서 중복해서 못나오게 구현
 */
public class Q15663 {
    private static boolean[] isVisit;
    private static int[] numbers;
    private static int[] result;
    private static int n;
    private static int m;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        isVisit = new boolean[n];
        numbers = new int[n];
        result = new int[m];

        for (int i = 0 ; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }

        Arrays.sort(numbers);
        permute(0);
    }

    private static void permute(final int depth) {
        if (depth == m) {
            print();
            return;
        }

        boolean[] isUsed = new boolean[10001];

        for (int i = 0; i < n; i++) {
            if (!isVisit[i] && !isUsed[numbers[i]]) {
                result[depth] = numbers[i];
                isUsed[numbers[i]] = true;
                isVisit[i] = true;
                permute(depth + 1);
                isVisit[i] = false;
            }
        }
    }

    private static void print() {
        for (int i = 0; i < m; i++) {
            System.out.print(result[i] + " ");
        }
        System.out.println();
    }
}
