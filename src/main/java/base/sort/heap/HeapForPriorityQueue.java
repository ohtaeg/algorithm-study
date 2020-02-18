package base.sort.heap;

import java.util.Arrays;

public class HeapForPriorityQueue {
    public static void main(String[] args) {
        int[] arr = { 9, 8, 1, 2, 5, 4, 7, 6, 3 };

        Heap heap = new Heap();
        for (int i : arr) {
            heap.insert(i);
        }
        heap.print();

        for (int i = 0; i < arr.length; i++) {
            System.out.print(heap.extract() + " ");
        }
        System.out.println();
    }

    private static class Heap {
        private static final int DEFAULT_HEAP_SIZE = 8;
        private static final int ROOT_NODE_INDEX = 0;
        private int[] heap;
        private int size;

        Heap() {
            this(DEFAULT_HEAP_SIZE);
        }

        Heap(int capacity) {
            heap = new int[capacity];
            size = 0;
        }

        public void insert(final int data) {
            if (size + 1 > heap.length) {
                grow(size + 1);
            }

            heap[size++] = data;
            int parentNodeIndex;
            int insertedNodeIndex = size - 1;

            while (insertedNodeIndex > ROOT_NODE_INDEX) {
                // root가 0번부터 이므로, 1번 인덱스의 부모는 0번임을 만족하기 위해 -1
                parentNodeIndex = (insertedNodeIndex - 1) / 2;
                if (data <= heap[parentNodeIndex]) { // minHeapify : >=
                    break;
                }
                swap(parentNodeIndex, insertedNodeIndex);
                insertedNodeIndex = parentNodeIndex;
            }
        }

        public int extract() {
            if (size < 1) {
                return 0;
            }
            int rootValue = heap[ROOT_NODE_INDEX];
            heap[ROOT_NODE_INDEX] = heap[--size];
            heap[size] = 0; // remove
            maxHeapify(heap, size, ROOT_NODE_INDEX);
            return rootValue;
        }

        private void maxHeapify(final int[] heap, final int size, final int rootNodeIndex) {
            int leftChildIndex = rootNodeIndex * 2 + 1;
            int rightChildIndex = rootNodeIndex * 2 + 2;
            int parent = rootNodeIndex;
            int maxChildIndex;

            while (leftChildIndex < size && rightChildIndex < size) {
                if (heap[leftChildIndex] > heap[rightChildIndex]) { // minHeapify : <
                    maxChildIndex = leftChildIndex;
                }  else {
                    maxChildIndex = rightChildIndex;
                }

                if (heap[parent] >= heap[maxChildIndex]) { // minHeapify : <=
                    return;
                }

                swap(parent, maxChildIndex);
                parent = maxChildIndex;
                leftChildIndex = parent * 2 + 1;
                rightChildIndex = parent * 2 + 2;
            }
        }

        private void grow(final int i) {
            heap = Arrays.copyOf(heap, i);
        }

        private void swap(final int parentNodeIndex, final int insertedNodeIndex) {
            int temp = heap[parentNodeIndex];
            heap[parentNodeIndex] = heap[insertedNodeIndex];
            heap[insertedNodeIndex] = temp;
        }

        public void print() {
            for (int i : heap) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
