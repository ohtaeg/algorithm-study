package base.sort.insertion;

public class Insertion {
    public static void main(String[] args) {
        int[] arr = new int[]{29, 14, 10, 37, 13}; // 10 13 14 29 37
        Insertion.sort(arr);
        print(arr);

        int[] arr2 = new int[]{7, 5, 9, 0 ,3, 1, 6, 2, 4, 8};
        Insertion.sort2(arr2);
        print(arr2);
    }

    private static void sort(final int[] arr) {
        for (int i = 1; i < arr.length; i++) { // 두번쨰 위치부터 탐색
            int target = arr[i];
            int j = i;
            // n-1번째 부터 앞쪽으로 순차 탐색
            while (j > 0 && arr[j-1] > target) {
                arr[j] = arr[j-1]; // 값이 크다면 shift
                j--;
            }
            arr[j] = target; // 해당 위치에 값 삽입
        }
    }

    private static void sort2(final int[] arr) {
        // 두번째 데이터부터 시작
        for (int i = 1; i < arr.length; i++) {
            // 한칸씩 왼쪽으로 이동
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                } else {
                    break;
                }
            }
        }
    }

    private static void print(final int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
