package yandex.Item2.sprint3.tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class A {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int numCount = Integer.parseInt(reader.readLine());
            int[] numbers = parseString(reader.readLine());
            int bikeCost = Integer.parseInt(reader.readLine());
            printNumDay(numCount, numbers, bikeCost);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printNumDay(int numCount, int[] numbers, int bikeCost) {
        int firstBike = binarySearch(0, numCount - 1, bikeCost, numbers);
        int secondBike = binarySearch(0, numCount - 1, bikeCost * 2, numbers);
        System.out.println(firstBike + " " + secondBike);
    }

    private static int binarySearch(int left, int right, int x, int[] numbers) {
        if (left > right) {
            return -1;
        }
        int mid = (right - left) / 2 + left;
        if (numbers[mid] >= x) {
            return mid + 1;
        } else if (numbers[mid] < x) {
            return binarySearch(mid + 1, right, x, numbers);
        } else {
            return binarySearch(left, mid - 1, x, numbers);
        }
    }

    static int[] parseString(String string) {
        return Arrays.stream(string.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
