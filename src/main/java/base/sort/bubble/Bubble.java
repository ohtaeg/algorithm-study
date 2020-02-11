package base.sort.bubble;

public class Bubble {
    public static void main(String[] args) {
        int[] arr = new int[]{29, 14, 10, 37, 13}; // 10 13 14 29 37
        Bubble.sort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
    private static void sort(final int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length-i-1; j++) {
                if (arr[j] > arr[j+1]) {
                    swap(arr, j, j+1);
                }
            }
        }
    }

    private static void swap(final int[] arr, final int i, final int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
