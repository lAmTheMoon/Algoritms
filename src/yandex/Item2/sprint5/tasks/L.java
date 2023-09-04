package yandex.Item2.sprint5.tasks;

public class L {
    public static int siftDown(int[] heap, int idx) {
        int left = 2 * idx;
        int right = 2 * idx + 1;
        int size = heap.length - 1;
        if (left > size) {
            return idx;
        }
        int largest = idx;
        if (right <= size && heap[left] < heap[right]) {
            largest = right;
        } else {
            largest = left;
        }
        if (heap[idx] < heap[largest]) {
            int swap = heap[idx];
            heap[idx] = heap[largest];
            heap[largest] = swap;
            return siftDown(heap, largest);
        }

        return idx;
    }

    private static void test() {
        int[] sample = {-1, 12, 1, 8, 3, 4, 7};
        assert siftDown(sample, 2) == 5;
        System.out.println(siftDown(sample, 2));
    }

    public static void main(String[] args) {
        test();
    }
}
