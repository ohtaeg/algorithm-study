package codility.lesson6.numberOfDiscIntersections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class NumberOfDisIntersections {
    public static void main(String[] args) {
        NumberOfDisIntersections numberOfDisIntersections = new NumberOfDisIntersections();
        numberOfDisIntersections.solution(new int[]{1, 5, 2, 1, 4, 0});
    }

    /**
     * 첫번째 풀이, 56%, 퍼포먼스에서 걸림, 모든 테케는 통과
     * 원이 교차하는지 판단하는 조건은 다음과 같다.
     * 1. 왼쪽 끝점을 기준으로 정렬한 후
     * 2. 비교하는 원의 왼쪽 끝점은 기준 원의 왼쪽 끝점 과 기준 원의 오른쪽 끝점 사이에 있으면 교차 한 것
     * 3. 비교하는 원의 왼쪽 끝점이 기준 원의 오른쪽 끝점보다 크면 겹치지 않음 (왼쪽 끝점 기준으로 정렬했기에 그 이후 원들도 겹치지않음)
     */
    public int solution(int[] a) {
        List<Circle> circles = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            final long radius = a[i];
            circles.add(new Circle(i - radius, i + radius));
        }
        Collections.sort(circles);

        int intersectCount = 0;
        for (int i = 0; i < circles.size() - 1; i++) {
            Circle circle = circles.get(i);
            for (int j = i + 1; j < circles.size(); j++) {
                Circle target = circles.get(j);
                if (intersectCount > 10_000_000) {
                    return -1;
                }

                if (circle.leftRadius <= target.leftRadius && target.leftRadius <= circle.rightRadius) {
                    intersectCount++;
                }

                if (target.leftRadius > circle.rightRadius) {
                    break;
                }
            }
        }

        return intersectCount;
    }

    /**
     * 두번째 풀이, 마크다운에 정리
     */
    public int solution2(int[] a) {
        int length = a.length;
        long[] lefts = new long[length];
        long[] rights = new long[length];

        for (int i = 0; i < length; i++) {
            long radius = a[i];
            lefts[i] = i - radius;
            rights[i] = i + radius;
        }

        Arrays.sort(lefts);
        Arrays.sort(rights);

        int intersectCount = 0;
        int j = 0;
        for (int i = 0; i < length; i++) {
            while (j < length && rights[i] >= lefts[j]) {
                j++;
            }
            intersectCount += j;
            intersectCount -= i + 1; // 자기 자신과 중복(A, B) (B, A)을 빼준다.

            if (intersectCount > 10_000_000) {
                return -1;
            }
        }
        return intersectCount;
    }

    private static class Circle implements Comparable<Circle> {
        final long leftRadius;
        final long rightRadius;

        public Circle(final long leftRadius, final long rightRadius) {
            this.leftRadius = leftRadius;
            this.rightRadius = rightRadius;
        }

        @Override
        public int compareTo(final Circle o) {
            return Long.compare(this.leftRadius, o.leftRadius);
        }
    }
}


