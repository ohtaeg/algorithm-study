package book.part2.binarysearch;

import java.io.IOException;

public class BinarySearch {
    public static void main(String[] args) throws IOException {
        int[] arr = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};

        int result = searchBinaryRecursive(arr, 3, 0, arr.length - 1);
        System.out.println(result);

        result = searchBinaryNonRecursive(arr, 3, 0, arr.length - 1);
        System.out.println(result);
    }

    private static int searchBinaryRecursive(final int[] arr, final int target, final int start, final int end) {
        if (start > end) {
            return -1;
        }

        int mid = (start + end) / 2;
        if (arr[mid] == target) {
            return arr[mid];
        }

        if (arr[mid] > target) {
            return searchBinaryRecursive(arr, target, start, mid - 1);
        }

        return searchBinaryRecursive(arr, target, mid + 1, end);
    }

    private static int searchBinaryNonRecursive(final int[] arr, final int target, final int start, final int end) {
        int left = start;
        int right = end;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == target) {
                return target;
            }

            if (arr[mid] > target) {
                right = mid - 1;
            }

            if (arr[mid] < target) {
                left = mid + 1;
            }
        }

        return - 1;
    }
}
