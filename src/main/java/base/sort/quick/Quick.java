package base.sort.quick;

public class Quick {
    public static void main(String[] args) {
        int[] arr = new int[]{29, 14, 10, 37, 13, 10, 1};
        Quick.sort(arr, 0, arr.length - 1);
        print(arr);
    }

    private static void sort(final int[] arr, final int begin, final int end) {
        if (begin < end) {
            int pivot = partition(arr, begin, end);
            sort(arr, begin, pivot - 1);
            sort(arr, pivot + 1, end);
        }
    }

    private static int partition(final int[] arr, final int begin, final int end) {
        int pivotValue = arr[end];
        int left = begin - 1;

        for (int i = begin; i < end; i++) {
            if (arr[i] < pivotValue) { // pivot 값보다 값이 작으면
                left++;
                swap(arr, left, i);
            }
        }
        left++;
        swap(arr, left, end);
        return left;
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
