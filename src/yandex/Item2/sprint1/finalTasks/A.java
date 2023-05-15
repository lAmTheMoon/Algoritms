package yandex.Item2.sprint1.finalTasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * ID посылки 87343769
 */
public class A {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int length = Integer.parseInt(reader.readLine());
            int[] numbers = parseToIntArray(reader.readLine());
            System.out.println(getNearestZeroForNumbers(length, numbers));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static StringBuilder getNearestZeroForNumbers(int length, int[] numbers) {
        StringBuilder sb = new StringBuilder();
        int[] zeroIndexes = getZeroIndexes(length, numbers);

        IntStream.range(0, length).forEach(indexOfNumber -> {
            if (numbers[indexOfNumber] == 0) {
                sb.append(0).append(" ");
                return;
            }
            sb.append(getNearestZeroIndex(zeroIndexes, indexOfNumber)).append(" ");
        });
        return sb;
    }

    private static int getNearestZeroIndex(int[] zeroIndexes, int indexOfNumber) {
        for (int i = 0; i < zeroIndexes.length; i++) {
            if (i == 0 && zeroIndexes[i] > indexOfNumber) {
                return zeroIndexes[i] - indexOfNumber;
            }

            if (i + 1 != zeroIndexes.length && zeroIndexes[i] < indexOfNumber && indexOfNumber < zeroIndexes[i + 1]) {
                int left = indexOfNumber - zeroIndexes[i];
                int right = zeroIndexes[i + 1] - indexOfNumber;
                return Math.min(left, right);
            }

            if (i == zeroIndexes.length - 1 && zeroIndexes[i] < indexOfNumber) {
                return indexOfNumber - zeroIndexes[i];
            }
        }

        return -1;
    }

    private static int[] getZeroIndexes(int length, int[] numbers) {
        return IntStream.range(0, length)
                .filter(i -> numbers[i] == 0)
                .toArray();
    }

    private static int[] parseToIntArray(String string) {
        return Arrays.stream(string.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
