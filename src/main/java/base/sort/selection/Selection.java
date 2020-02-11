package base.sort.selection;

public class Selection {
    public static void main(String[] args) {
        int[] arr = new int[]{29, 10, 14, 37, 13}; // 10 13 14 29 37
        Selection.sort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    private static void sort(final int[] arr) {
        int minIndex;
        int temp;
        for (int i = 0; i < arr.length-1; i++) {
            minIndex = i; // 1. index 를 선택
            for (int j = i+1; j < arr.length; j++) {
                if (arr[minIndex] > arr[j]) { // 2. i + 1번째의 index와 선택한 index와 값 비교
                    minIndex = j; // 3. 값이 작다면 선택한 위치를 초기화
                }
            }
            // 4. 선택한 위치와, 정렬되지 않은 데이터중 맨 앞 index와 값 교환
            temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }
}
