package yandex.Item2.sprint5.tasks;

public class M {
    public static int siftUp(int[] heap, int idx) {
        if (idx == 1) {
            return idx;
        }
        int parent = idx / 2;
        if (heap[idx] > heap[parent]) {
            int swap = heap[idx];
            heap[idx] = heap[parent];
            heap[parent] = swap;
            return siftUp(heap, parent);
        }
        return idx;
    }

    private static void test() {
        int[] sample = {-1, 12, 6, 8, 3, 15, 7};
        assert siftUp(sample, 5) == 1;
    }

    public static void main(String[] args) {
        int[] sample = {-1, 15, 6, 8, 3, 7, 12};
        System.out.println(siftUp(sample, 6));
    }
}
