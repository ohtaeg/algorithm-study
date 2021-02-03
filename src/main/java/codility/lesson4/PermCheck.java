package codility.lesson4;

public class PermCheck {
    public int solution(int[] a) {
        int n = a.length;
        boolean[] isUse = new boolean[n + 1];

        for (int i = 0; i < n; i++) {
            int number = a[i];
            if (number <= n) {
                isUse[number] = true;
            }
        }

        for (int i = 1; i < isUse.length; i++) {
            if (!isUse[i]) {
                return 0;
            }
        }

        return 1;
    }
}
