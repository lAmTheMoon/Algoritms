package yandex.Item2.sprint3.finalTasks;

/**
 * ID посылки 88496419
 *
 * Алгоритм поиска индекса в сломанном массиве основан на поиске прыжками
 * Если первый эл-т массива больше искомого значения, то поиск с конца массива,
 * а если первый эл-т меньше или равен искомому значению, то ищем с начала массива.
 * Поиск интервала заканчивается, когда крайняя
 */

public class A {

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
        assert 6 == brokenSearch(arr, 5);
    }
}
