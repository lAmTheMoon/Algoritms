package stepic.binarysearch;

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
            int findNumber = parseStringToInteger(reader.readLine());
            System.out.println(numbersPosition(numbers, findNumber, lenght));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int numbersPosition(List<Integer> numbers, int number, int length) {
        int left = -1;
        int right = length -1;
        int sum = 0;
        while (left + 1 < right) {
            int middle = left + ((right - left) / 2);

            if (numbers.get(middle) < number) {
                left = middle;
            } else {
                right = middle;
            }
        }

        while (right <= length - 1 && Objects.equals(numbers.get(right), number)) {
            sum++;
            right++;
        }
        return sum;
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
