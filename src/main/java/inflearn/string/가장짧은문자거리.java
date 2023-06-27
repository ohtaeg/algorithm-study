package inflearn.string;

import java.util.Scanner;

/**
 * https://cote.inflearn.com/contest/10/problem/01-10
 */
public class 가장짧은문자거리 {

    /**
     * 왼쪽 방향에서 오른쪽으로 타겟과의 거리를 증가 (기본값은 큰 값으로 둔 상태)
     * t  e a c h e
     * 99 0 1 2 3 0
     * 그런 다음 오른쪽 방향에서 왼쪽으로 타겟과의 거리를 다시 계산하고, 거리가 짧은 값으로 변경
     * t e a c h e
     * 1 0 1 2 1 0
     */
    private static String solution(final String str) {
        String s = str.split(" ")[0];
        String target = str.split(" ")[1];

        int[] distance = new int[s.length()];
        int[] left = left(s, target, distance);
        int[] right = right(s, target, left);

        String result = "";
        for (int x : right) {
            result += x + " ";
        }
        return result.trim();
    }

    private static int[] left(final String s, final String target, final int[] distance) {
        int p = 9999;
        for (int i = 0; i < s.length(); i++) {
            if (String.valueOf(s.charAt(i)).equals(target)) {
                p = 0;
                distance[i] = p;
            } else {
                p++;
                distance[i] = p;
            }
        }
        return distance;
    }

    private static int[] right(final String s, final String target, final int[] distance) {
        int p = 9999;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (String.valueOf(s.charAt(i)).equals(target)) {
                p = 0;
            } else {
                p++;
                distance[i] = Math.min(distance[i], p);
            }
        }
        return distance;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String target = scanner.nextLine();
        System.out.println(solution(target));
    }
}
