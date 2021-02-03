package codility.lesson4;

public class MaxCounters {


    /**
     * 첫번째 풀이, 시간초과 발생
     */
    public int[] solution(int n, int[] a) {
        final int maxCount = n + 1;
        final int[] counters = new int[n];
        int max = 0;

        for (int i = 0; i < a.length; i++) {
            int count = a[i];
            if (maxCount == count) {
                // 여기서 시간초과가 발생하는
                for (int j = 0; j < counters.length; j++) {
                    counters[j] = max;
                }

            } else {
                int value = counters[count - 1];
                counters[count - 1] = value + 1;
                max = Integer.max(max, value + 1);
            }
        }
        return counters;
    }

    /**
     * 두번쨰 풀이
     * 지역 변수 하나를 더 만든다음 최신 max값을 담아둔다. (latestMax)
     * 최신 max값을 담아두는 이유는 매 maxCount시 반복문을 순회하면서 증가시키지 않고
     * latestMax 를 통해 값 증가시 마치 증가된 것처럼 latestMax와 비교하며 + 1을해주고
     * 마지막엔 latestMax값 보다 작은 애들이 있다면 latestMax로 치환
     */
    public int[] solution2(int n, int[] a) {
        final int maxCount = n + 1;
        final int[] counters = new int[n];
        int increaseMax = 0;
        int latestMax = 0;

        for (int i = 0; i < a.length; i++) {
            int count = a[i];
            if (maxCount == count) {
                latestMax = increaseMax;
            } else {
                counters[count - 1] = Integer.max(latestMax, counters[count - 1]) + 1;
                increaseMax = Integer.max(increaseMax, counters[count - 1]);
            }
        }

        for (int i = 0; i < n; i++) {
            counters[i] = Integer.max(counters[i], latestMax);
        }

        return counters;
    }
}
