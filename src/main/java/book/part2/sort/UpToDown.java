package book.part2.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

/**
 * 위에서 아래로
 */
public class UpToDown {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        Integer[] array = new Integer[n];
        int[] array2 = new int[n];

        for (int i = 0; i < n; i++) {
            int data = Integer.parseInt(bufferedReader.readLine());
            array[i] = data;
            array2[i] = data;
        }

        Arrays.sort(array, Collections.reverseOrder());
        quickSort(array2, 0, n - 1);

        print(array);
        print2(array2);

        bufferedReader.close();
    }

    private static void quickSort(final int[] arr, final int begin, final int end) {
        if (begin >= end) {
            return;
        }

        int pivot = (begin + end) / 2;
        int pivotValue = arr[pivot];
        int left = begin;
        int right = end;

        while (left <= right) {
            // 피벗보다 큰 데이터를 찾을때까지 왼쪽에서 오른쪽으로 이동
            while (arr[left] > pivotValue) {
                left++;
            }

            // 피벗보다 작은 데이터를 찾을때까지 오른쪽에서 왼쪽으로 이동
            while (pivotValue > arr[right]) {
                right--;
            }

            // 엇갈리지 않았다면 작은 데이터와 큰 데이터 교체
            if (left <= right) {
                swap(arr, left, right);
                left++;
                right--;
            }
        }

        quickSort(arr, begin, left - 1);
        quickSort(arr, left, end);
    }

    private static void swap(final int[] arr, final int left, final int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    private static void print(final Integer[] array) {
        final int n = array.length;
        for (int i = 0; i < n; i++) {
            System.out.print(array[i]);
            if (i != n - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }

    private static void print2(final int[] array) {
        final int n = array.length;
        for (int i = 0; i < n; i++) {
            System.out.print((array[i]));
            if (i != n - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }
}
