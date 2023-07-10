package inflearn.two_pointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * https://cote.inflearn.com/contest/10/problem/03-02
 * 정렬 후 비교, 숫자가 작은 쪽의 포인터를 증가시켜서 공통원소 추출
 * 투 포인터가 가르키는 숫자가 같으면 둘다 증가
 */
public class 공통원소구하기 {

    public static List<Integer> solution(int[] a, int[] b) {
        List<Integer> answer = new ArrayList<>();
        int n = a.length;
        int m = b.length;
        int p1 = 0;
        int p2 = 0;

        Arrays.sort(a);
        Arrays.sort(b);

        while (p1 < n && p2 < m) {
            if (a[p1] == b[p2]) {
                answer.add(a[p1]);
                p1++;
                p2++;
            } else if (a[p1] < b[p2]) {
                p1++;
            } else {
                p2++;
            }
        }

        return answer;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        int m = scanner.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = scanner.nextInt();
        }

        for (int x : solution(a, b)) {
            System.out.print(x + " ");
        }
    }
}
