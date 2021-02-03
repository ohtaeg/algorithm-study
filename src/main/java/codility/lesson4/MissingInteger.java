package codility.lesson4;

public class MissingInteger {
    public int solution(int[] a) {
        int n = a.length;
        int sum = n * (n + 1) / 2;
        boolean[] isUse = new boolean[n + 1];

        for (int i = 0; i < n; i++) {
            int value = a[i];
            if (isPositive(value) && isInRange(value, n)) {
                sum -= value;
                isUse[value] = true;
            }
        }

        // 배열 내 요소들이 모두 양수일 경우 1부터 사용되지 않은 정수 반환
        for (int i = 1; i < isUse.length; i++) {
            if (!isUse[i]) {
                return i;
            }
        }

        // N 개가 다 사용되었을때 그다음 숫자 리턴
        if (sum == 0) {
            return n + 1;
        } else { // else 까지 온다는 것은 음수라는 것
            return 1;
        }
    }

    private boolean isPositive(final int value) {
        return value > 0;
    }

    private boolean isInRange(final int value, final int n) {
        return value <= n;
    }
}
