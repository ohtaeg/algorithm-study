package base.sort.quick;

import java.util.Stack;

public class Quick {
    public static void main(String[] args) {
        System.out.println("=== recursive middle pivot ===");
        int[] arr = {5, 7, 9, 0, 3, 1, 6, 2, 4, 8};
        Quick.sortMiddlePivot(arr, 0, arr.length - 1);
        print(arr);

        System.out.println("=== recursive hoare pivot ===");
        int[] arr3 = {5, 7, 9, 0, 3, 1, 6, 2, 4, 8};
        Quick.sortHoarePivot(arr3, 0, arr.length - 1);
        print(arr3);

        System.out.println("=== non recursive using stack ===");
        int[] arr2 = {5, 7, 9, 0, 3, 1, 6, 2, 4, 8};
        Quick.sortUsingStack(arr2, 0, arr2.length - 1);
        print(arr2);
    }

    // 호어 분할 방식 = 첫번째를 피벗으로 한다.
    private static void sortHoarePivot(final int[] arr, final int begin, final int end) {
        if (begin >= end) {
            return;
        }

        int pivot = begin;
        int left = begin + 1;
        int right = end;

        while (left <= right) {
            // 피벗보다 큰 데이터를 찾을때까지 왼쪽에서 오른쪽으로 이동
            while (left <= end && arr[left] <= arr[pivot]) {
                left++;
            }

            // 피벗보다 작은 데이터를 찾을때까지 오른쪽에서 왼쪽으로 이동
            while (begin < right && arr[right] >= arr[pivot]) {
                right--;
            }

            // 엇갈리지 않았다면 작은 데이터와 큰 데이터 교체
            if (left <= right) {
                swap(arr, left, right);
            } else { // 엇갈렸다면 작은 데이터와 피벗 교체, 즉 right가 피벗이 된다.
                swap(arr, right, pivot);
            }
        }

        sortHoarePivot(arr, begin, right - 1);
        sortHoarePivot(arr, right + 1, end);
    }

    private static void sortMiddlePivot(final int[] arr, final int begin, final int end) {
        if (begin < end) {
            int pivot = partition(arr, begin, end);
            sortMiddlePivot(arr, begin, pivot - 1);
            sortMiddlePivot(arr, pivot, end);
        }
    }

    // non - recursive
    private static void sortUsingStack(final int[] arr, final int begin, final int end) {
        Stack<Integer> stack = new Stack<>();
        int low = begin;
        int high = end;
        int pivot;

        stack.push(low);
        stack.push(high);

        while (!stack.isEmpty()) {
            high = stack.pop();
            low = stack.pop();

            if (low < high) {
                pivot = partition(arr, low, high);
                // 전반부
                // if (pivot > low) {
                stack.push(low);
                stack.push(pivot - 1);

                // 후반부
                // if (pivot <= high) {
                stack.push(pivot);
                stack.push(high);
            }
        }
    }

    private static int partition(final int[] arr, final int begin, final int end) {
        int pivotValue = arr[(begin + end) / 2]; // median
        int left = begin;
        int right = end;

        // 두 인덱스가 지나칠때까지 반복
        while (left <= right) {

            // 전반부쪽에서 피벗보다 작으면 무시하고 인덱스를 오른쪽으로 ->
            while (arr[left] < pivotValue) {
                left++;
            }

            // 후반부쪽에서 피벗보다 크면 무시하고 인덱스를 왼쪽으로 <-
            while (pivotValue < arr[right]) {
                right--;
            }

            // 두 인덱스가 지나치지 않았으면 값을 바꾼 후 인덱스 이동
            if (left <= right) {
                swap(arr, left, right);
                left++;
                right--;
            }
        }
        return left; // 후반부 첫번째 index return
    }

    private static void swap(final int[] arr, final int left, final int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    private static void print(final int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
