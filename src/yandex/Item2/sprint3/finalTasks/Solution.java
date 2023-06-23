package yandex.Item2.sprint3.finalTasks;

/**
 * ID посылки 88496623
 * Алгоритм поиска индекса в сломанном массиве представляет собой модификацию бинарного поиска.
 * Мы перемещаем указатели до тех пор, пока среднее значение границ не является индексом искомого значения.
 * При отсутствии искомого значения в массиве возвращаем -1.
 * В худшем случае потребуется log n сравнений, те скорость работы алгоритма O(log n)
 */
public class Solution {

    public static int brokenSearch(int[] arr, int k) {
        int left = 0;
        int right = arr.length - 1;
        int middle = 0;
        while (left <= right) {
            middle = (left + right) / 2;
            if (arr[middle] == k) {
                return middle;
            }
            if (arr[left] <= arr[middle]) {
                if (arr[left] <= k && k < arr[middle]) {
                    right = middle - 1;
                } else {
                    left = middle + 1;
                }
            } else {
                if (arr[middle] < k && k <= arr[right]) {
                    left = middle + 1;
                } else {
                    right = middle - 1;
                }
            }
        }
        return -1;
    }

    private static void test() {
        int[] arr = {19, 21, 100, 101, 1, 4, 5, 7, 12};
        assert 6 == brokenSearch(arr, 5);
    }
}
