package yandex.Item2.sprint3.tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class L {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int numCount = Integer.parseInt(reader.readLine());
            int[] numbers = parseString(reader.readLine());
            int bikeCost = Integer.parseInt(reader.readLine());
            printNumDay(numbers, bikeCost);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printNumDay(int[] numbers, int bikeCost) {
        int firstBike = jumpSearch(bikeCost, numbers, 0);
        int secondBike = jumpSearch(bikeCost * 2, numbers, firstBike);
        System.out.println(firstBike + " " + secondBike);
    }

    private static int jumpSearch(int x, int[] arr, int start) {
        int step = (int) Math.sqrt(arr.length - start);
        int end = step - 1;
        while (arr[end] < x) {
            end = Math.min(arr.length - 1, end + step);
            if (end == arr.length - 1 || arr[end] >= x) {
                break;
            }
            start = Math.min(arr.length - 1, start + step);
            if (arr[start] >= x) {
                start = Math.min(arr.length - 1, start - step);
            }
        }

        return rangeLineSearch(x, arr, start, end);
    }

    private static int rangeLineSearch(int x, int[] arr, int start, int end) {
        if (x > arr[end]) {
            return -1;
        }

        for (int i = start; i <= end; i++) {
            if (arr[i] >= x) {
                return i + 1;
            }
        }

        return -1;
    }

    private static int[] parseString(String string) {
        return Arrays.stream(string.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
