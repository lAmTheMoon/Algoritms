package yandex.Item2.sprint3.finalTasks;

public class Solution {

    public static void main(String[] args) {
        test();
    }

    public static int brokenSearch(int[] arr, int k) {
        return arr[0] <= k ? searchFromHead(arr, k) : searchFromTail(arr, k);
    }

    public static int searchFromHead(int[] arr, int k) {
        int step = (int) Math.sqrt(arr.length);
        int start = 0;
        int end = step - 1;
        while (arr[end] < k) {
            if (end == arr.length -1 || arr[start] > arr[end]) {
                break;
            }
            start = Math.min(arr.length - 1, start + step);
            end = Math.min(arr.length - 1, end + step);
        }

        return rangeLineSearch(k, arr, end, start);
    }

    public static int searchFromTail(int[] arr, int k) {
        int step = (int) Math.sqrt(arr.length);

        int start = arr.length - 1;
        int end = start - step;
        while (arr[end] > k) {
            if (end == 0 || arr[end] > arr[start]) {
                break;
            }
            start = Math.max(0, start - step);
            end = Math.max(0, end - step);
        }

        return rangeLineSearch(k, arr, start, end);
    }

    private static int rangeLineSearch(int k, int[] arr, int first, int second) {
        if (k > arr[first]) {
            return -1;
        }

        for (int i = first; i >= second; i--) {
            if (arr[i] == k) {
                return i;
            }
        }

        return -1;
    }

    private static void test() {
        int[] arr = {19, 21, 100, 101, 1, 4, 5, 7, 12};
        int[] arr2 = {2472, 2473, 2486, 2534, 2628, 2977, 3016, 3155, 3215, 3383, 3522, 3533, 3572, 3599, 3754, 3856, 3888, 3890, 4082, 4130, 4155, 4207, 4555, 4556, 4594, 4597, 4854, 4861, 4948, 5085, 5107, 5251, 5257, 5378, 5408, 5452, 5484, 5584, 5626, 5701, 5760, 5781, 5851, 5855, 6025, 6047, 6133, 6243, 6296, 6314, 6409, 6516, 6521, 6659, 6735, 6813, 6917, 7059, 7120, 7296, 7310, 7345, 7360, 7379, 7425, 7498, 7693, 7925, 7993, 8035, 8165, 8277, 8310, 8363, 8544, 8562, 8774, 8827, 8860, 8952, 9163, 9177, 9255, 9793, 9894, 199, 213, 227, 429, 465, 498, 728, 939, 1502, 1744, 1768, 1821, 2317, 2428, 2471};
        int[] arr3 = {3, 6, 7};
        int[] arr4 = {1, 2, 3, 5, 6, 7, 9, 0};
        System.out.println(brokenSearch(arr, 5));
        System.out.println(brokenSearch(arr2, 227));
        System.out.println(brokenSearch(arr3, 8));
        System.out.println(brokenSearch(arr4, 3));
        assert 6 == brokenSearch(arr, 5);
    }
}
