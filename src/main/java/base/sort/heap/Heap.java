package base.sort.heap;

public class Heap {
    public static void main(String[] args) {
        int[] arr = { 1, 23, 10, 1, 60, 55, 4, 22, 2 };
        Heap.sort(arr);
        print(arr);

        System.out.println("== non recursive ===");

        int[] arr2 = { 1, 23, 10, 1, 60, 55, 4, 22, 2 };
        Heap.nonRecursiveSort(arr2);
        print(arr2);
    }

    private static void sort(final int[] arr) {
        int heapSize = arr.length;
        // 마지막 노드의 부모 노드 (n/2)에서부터 시작, root(0)까지 반복해서 max heap 을 만든다.
        for (int i = heapSize / 2 - 1; i >= 0; i--) {
            heapify(arr, heapSize, i);
        }

        for (int i = heapSize - 1; i > 0; i--) {
            // 마지막 node부터 root값을 바꿔나간다.
            swap(arr, 0, i);
            heapify(arr, i, 0);
        }
    }

    private static void heapify(final int[] arr, final int heapSize, final int parentNodeIndex) {
        int leftChildIndex = parentNodeIndex * 2 + 1; // root를 0번부터 시작하기 때문에 + 1
        int rightChildIndex = parentNodeIndex * 2 + 2; // root를 0번부터 시작하기 때문에 + 2
        int maxChildIndex;

        // 자식노드가 존재하지 않으면
        if (leftChildIndex >= heapSize || rightChildIndex >= heapSize) {
            return;
        }

        // 왼쪽, 오른쪽 자식 중 값이 큰 값을 담는다.
        if (arr[leftChildIndex] > arr[rightChildIndex]) {
            maxChildIndex = leftChildIndex;
        }  else {
            maxChildIndex = rightChildIndex;
        }

        // 부모 노드값이 자식보다 크면 연산 중지
        if (arr[parentNodeIndex] >= arr[maxChildIndex]) {
            return;
        }

        swap(arr, parentNodeIndex, maxChildIndex);
        heapify(arr, heapSize, maxChildIndex);
    }

    /**
     * non recursive
     */
    private static void nonRecursiveSort(final int[] arr) {
        int heapSize = arr.length;
        // 마지막 노드의 부모 노드 (n/2)에서부터 시작, root(0)까지 반복해서 max heap 을 만든다.
        for (int i = heapSize / 2; i >= 0; i--) {
            nonRecursiveHeapify(arr, heapSize, i);
        }

        for (int i = heapSize - 1; i > 0; i--) {
            // 마지막 node부터 root값을 바꿔나간다.
            swap(arr, 0, i);
            nonRecursiveHeapify(arr, i, 0);
        }
    }

    private static void nonRecursiveHeapify(final int[] arr, final int heapSize, final int parentNodeIndex) {
        int leftChildIndex = parentNodeIndex * 2 + 1; // root를 0번부터 시작하기 때문에 + 1
        int rightChildIndex = parentNodeIndex * 2 + 2; // root를 0번부터 시작하기 때문에 + 2
        int parent = parentNodeIndex;
        int maxChildIndex;

        while (leftChildIndex < heapSize && rightChildIndex < heapSize) {
            if (arr[leftChildIndex] > arr[rightChildIndex]) {
                maxChildIndex = leftChildIndex;
            }  else {
                maxChildIndex = rightChildIndex;
            }

            // 부모 노드값이 자식보다 크면 연산 중지
            if (arr[parent] >= arr[maxChildIndex]) {
                return;
            }

            swap(arr, parent, maxChildIndex);
            parent = maxChildIndex;
            leftChildIndex = parent * 2 + 1;
            rightChildIndex = parent * 2 + 2;
        }
    }

    private static void swap(final int[] arr, final int i, final int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void print(final int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
