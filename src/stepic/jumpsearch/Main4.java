package stepic.jumpsearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main4 {

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int lengths = Integer.parseInt(reader.readLine());
            int[] array = parseString(reader.readLine());
            int number = Integer.parseInt(reader.readLine());
            printNumInList(lengths, array, number);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printNumInList(int lengths, int[] array, int number) {
        int resultF = 0;
        int resultL = 0;

        int step = (int) Math.sqrt(lengths);
        int start = 0;
        int end = step - 1;

        while (end <= lengths - 1 && array[end] <= number && end + 1 <= lengths - 1 && array[end + 1] <= number) {
            start = Math.min(lengths - 1, start + step);
            end = Math.min(lengths - 1, end + step);
        }

        if (number <= array[end]) {
            for (int j = end; j >= start; j--) {
                if (number == array[j]) {
                    resultF = j + 1;
                    break;
                }
            }
        }

        start = 0;
        end = step - 1;

        while (end < lengths - 1 && array[end] < number) {
            start = Math.min(lengths - 1, start + step);
            end = Math.min(lengths - 1, end + step);
        }

        if (number <= array[end]) {
            for (int j = start; j <= end; j++) {
                if (number == array[j]) {
                    resultL = j;
                    break;
                }
            }
        }

        System.out.println(resultF - resultL);
    }

    static int[] parseString(String string) {
        return Arrays.stream(string.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
