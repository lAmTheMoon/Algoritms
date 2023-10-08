package yandex.Item2.sprint7.tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class A {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int length = Integer.parseInt(reader.readLine());
            int[] numbers = parseToIntArray(reader.readLine());
            System.out.println(getMax(length, numbers));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int getMax(int length, int[] numbers) {
        int result = 0;
        for (int i = 0; i < length; i++) {
            if ((i + 1 <= length - 1) && (numbers[i] < numbers[i + 1])) {
                result += numbers[i + 1] - numbers[i];
            }
        }
        return result;
    }

    private static int[] parseToIntArray(String string) {
        return Arrays.stream(string.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
