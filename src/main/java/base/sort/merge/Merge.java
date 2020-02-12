package base.sort.merge;

import java.util.Arrays;

public class Merge {
    public static void main(String[] args) {
        int[] arr = new int[]{29, 14, 10, 37, 13}; // 10 13 14 29 37
        Merge.sort(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    private static void sort(final int[] arr, final int begin, final int end) {
        if (begin < end) {
            int half = (begin + end) / 2;
            sort(arr, begin, half); // 전반부
            sort(arr, half + 1, end); // 후반부
            merge(arr, begin, half, end); // merge
        }
    }

    private static void merge(final int[] arr, final int begin, final int half, final int end) {
        int left = begin;
        int mid = half + 1;
        int index = begin;
        int[] temp = new int[arr.length];

        while (left <= half && mid <= end) {
            if (arr[left] < arr[mid]) {
                temp[index++] = arr[left++];
            } else {
                temp[index++] = arr[mid++];
            }
        }

        while (left <= half) {
            temp[index++] = arr[left++];
        }

        while (mid <= end) {
            temp[index++] = arr[mid++];
        }

        for (int i=begin; i<index; i++) {
            arr[i] = temp[i];
        }
    }
}
