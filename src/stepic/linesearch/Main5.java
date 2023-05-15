package stepic.linesearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main5 {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int length = parseStringToInteger(reader.readLine());
            List<Integer> numbers = parseStringToIntList(reader.readLine());
            int findNumber = parseStringToInteger(reader.readLine());
            printNumberPosition(numbers, findNumber, length);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printNumberPosition(List<Integer> numbers, int number, int length) {
        for (int i = length - 1; i >= 0; i--) {
            if (numbers.get(i) == number) {
                System.out.println(i + 1);
                break;
            }
        }
    }

    private static List<Integer> parseStringToIntList(String string) throws IOException {
        return Arrays.stream(string.split(" "))
                .map(Main5::parseStringToInteger)
                .collect(Collectors.toList());
    }

    private static Integer parseStringToInteger(String string) {
        return Integer.parseInt(string);
    }
}
