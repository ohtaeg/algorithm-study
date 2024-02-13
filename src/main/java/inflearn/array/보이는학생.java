package inflearn.array;

import java.util.Scanner;

/**
 * 선생님이 N명의 학생을 일렬로 세우고 일렬로 서있는 학생의 키가 앞에서부터 순서대로 주어질 때
 * 맨 앞에 서있는 선생님이 볼 수 있는 학생의 수를 구하라.
 * 학생이 작거나 같으면 보이지 않는다.
 *
 * input
 * 8
 * 130 135 148 140 145 150 150 153
 *
 * output
 * 5
 */
public class 보이는학생 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] heights = new int[n];
        for (int i = 0; i < n; i++) {
            heights[i] = scanner.nextInt();
        }

        System.out.println(solution(n, heights));
    }

    private static int solution(final int n, final int[] heights) {
        // 첫번째 학생은 보이므로 카운팅 및 할당
        int count = 1;
        int max = heights[0];

        for (int i = 1; i < n; i++) {
            if (heights[i] > max) {
                count ++;
                max = heights[i];
            }
        }

        return count;
    }
}
