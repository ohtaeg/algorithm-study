package inflearn.sliding_window;

import java.util.Scanner;

/**
 * 0과 1로 구성된 길이가 N인 수열이 주어진다.
 * 이 수열에서 0을 1로 최대 K번 변경할 수 있다.
 * 변경을 통해 1로만 구성된 최대 길이의 연속부분수열을 찾아라
 * 만약 길이가 14인 수열, k=2로 주어진다면
 * 1 1 0 0 1 1 0 1 1 0 1 1 0 1
 * 1이 연속된 연속부분수열은
 * 1 1 0 0 1 1 1 1 1 1 1 1 0 1이며 길이는 8이다.
 */
public class 최대길이연속부분수열 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println(solution(n, k, arr));

    }

    private static int solution(final int n, final int k, final int[] arr) {
        int left = 0;
        int changeCount = 0;
        int answer = 0;

        for (int right = 0; right < n; right++) {
            if (arr[right] == 0) {
                changeCount++;
            }
            while (changeCount > k) {
                if (arr[left] == 0) {
                    changeCount--;
                }
                left++;
            }

            answer = Integer.max(answer, right - left + 1);
        }

        return answer;
    }

}
