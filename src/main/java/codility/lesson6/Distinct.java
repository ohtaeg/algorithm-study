package codility.lesson6;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Distinct {
    public int solution(int[] a) {
        Set<Integer> numbers = new HashSet<>();
        for (int number : a) {
            numbers.add(number);
        }
        return numbers.size();
    }

    /**
     * Arrays.sort 이용 + xor 연산
     */
    public int solution2(int[] a) {
        int n = a.length;
        if (n == 0) {
            return 0;
        }

        Arrays.sort(a);
        int count = 1;
        for (int i = 1; i < n; i++) {
            final int xor = a[i - 1] ^ a[i];
            if (xor != 0) {
                count++;
            }
        }

        return count;
    }

    /**
     * 퀵 정렬 + xor 연산
     */
    public int solution3(int[] a) {
        if (a == null || a.length == 0) {
            return 0;
        }

        sortQuick(a, 0, a.length - 1);

        int count = 1;
        for (int i = 1; i < a.length; i++) {
            final int xor = a[i - 1] ^ a[i];
            if (xor != 0) {
                count++;
            }
        }

        return count;

    }

    private void sortQuick(final int[] a, final int begin, final int end) {
        if (begin < end) {
            int pivot = partition(a, begin, end);
            sortQuick(a, begin, pivot - 1);
            sortQuick(a, pivot, end);
        }

    }

    private int partition(final int[] a, final int begin, final int end) {
        int pivotValue = a[(begin + end) / 2];
        int left = begin;
        int right = end;

        while (left <= right) {
            while (a[left] < pivotValue) {
                left++;
            }

            while (a[right] > pivotValue) {
                right--;
            }

            if (left <= right) {
                int temp = a[left];
                a[left] = a[right];
                a[right] = temp;
                left++;
                right--;
            }
        }

        return left;
    }
}
