package stepic.linesearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main3 {

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

    private static int numbersPosition(List<Integer> numbers, int number, int lenght) {
        int closeNum = number;
        int difference = Integer.MAX_VALUE;
        for (int i = 0; i < lenght; i++) {
            int abc = Math.abs(number - numbers.get(i));

            if (abc == difference && numbers.get(i) > closeNum) {
                closeNum = numbers.get(i);
            }

            if (abc < difference) {
                difference = abc;
                closeNum = numbers.get(i);
            }
        }
        return closeNum;
    }

    private static List<Integer> parseStringToIntList(String string) throws IOException {
        return Arrays.stream(string.split(" "))
                .map(Main3::parseStringToInteger)
                .collect(Collectors.toList());
    }

    private static Integer parseStringToInteger(String string) {
        return Integer.parseInt(string);
    }
}
