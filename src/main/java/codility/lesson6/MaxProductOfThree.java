package codility.lesson6;

import java.util.Arrays;

public class MaxProductOfThree {
    public int solution(int[] a) {
        int n = a.length;

        Arrays.sort(a);
        int caseA = a[n - 1] * a[n - 2] * a[n - 3]; // 모두 양수, 음수 케이스
        int caseB = a[0] * a[1] * a[n - 1]; // 양수, 음수 혼합 케이스

        return Integer.max(caseA, caseB);
    }
}
