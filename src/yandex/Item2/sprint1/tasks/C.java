package yandex.Item2.sprint1.tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int countArrays = Integer.parseInt(reader.readLine());
            int lengthArray = Integer.parseInt(reader.readLine());
            int[][] array = new int[countArrays][lengthArray];
            for (int i = 0; i < countArrays; i++) {
                array[i] = parseString(reader.readLine());
            }
            int verticalPoint = Integer.parseInt(reader.readLine());
            int horizontalPoint = Integer.parseInt(reader.readLine());

            getNumbers(array, verticalPoint, horizontalPoint, countArrays, lengthArray).stream()
                    .sorted().forEach(n -> System.out.print(n + " "));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<Integer> getNumbers(int[][] array, int verticalPoint, int horizontalPoint,
                                            int countArrays, int lengthArray) {
        List<Integer> numbers = new ArrayList<>();
        if (verticalPoint - 1 >= 0) {
            numbers.add(array[verticalPoint - 1][horizontalPoint]);
        }
        if (verticalPoint + 1 <= countArrays - 1) {
            numbers.add(array[verticalPoint + 1][horizontalPoint]);
        }
        if (horizontalPoint - 1 >= 0) {
            numbers.add(array[verticalPoint][horizontalPoint - 1]);
        }
        if (horizontalPoint + 1 <= lengthArray - 1) {
            numbers.add(array[verticalPoint][horizontalPoint + 1]);
        }
        return numbers;
    }

    private static int[] parseString(String string) {
        return Arrays.stream(string.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
