package stepic.linesearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main4 {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int lenght = parseStringToInteger(reader.readLine());
            List<Integer> numbers = parseStringToIntList(reader.readLine());
            newNumbers(numbers, lenght).forEach(n -> System.out.print(n + " "));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<Integer> newNumbers(List<Integer> numbers, int lenght) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < lenght; i++) {
            if (max < numbers.get(i)) {
                max = numbers.get(i);
            }

            if (min > numbers.get(i)) {
                min = numbers.get(i);
            }
        }

        for (int i = 0; i < lenght; i++) {
            if (numbers.get(i) == min) {
                numbers.set(i, max);
            }
        }
        return numbers;
    }

    private static List<Integer> parseStringToIntList(String string) throws IOException {
        return Arrays.stream(string.split(" "))
                .map(Main4::parseStringToInteger)
                .collect(Collectors.toList());
    }

    private static Integer parseStringToInteger(String string) {
        return Integer.parseInt(string);
    }
}
