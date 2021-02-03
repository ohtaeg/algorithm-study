package codility.lesson3;

public class TapeEquilibrium {
    /**
     * 구간합을 구하는 문제
     * 미리 구간합을 구해놓고 구간에 맞는 연산을 수행한 후 최소 값을 찾으면 된다.
     */
    public int solution(int[] a) {
        final int length = a.length;
        final int[] prefixSum = new int[length];

        prefixSum[0] = a[0];
        for (int i = 1; i < length; i++) {
            prefixSum[i] = prefixSum[i - 1] + a[i];
        }

        int min = Integer.MAX_VALUE;
        for (int p = 1; p < length; p++) {
            int preSum = prefixSum[p - 1];
            int postSum = prefixSum[length - 1] - preSum;
            min = Integer.min(min, Math.abs(preSum - postSum));
        }

        return min;
    }
}
