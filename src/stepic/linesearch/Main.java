package stepic.linesearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int lenght = parseStringToInteger(reader.readLine());
            List<Integer> numbers = parseStringToIntList(reader.readLine());
            int findNumber = parseStringToInteger(reader.readLine());
            System.out.println(numberCount(numbers, findNumber, lenght));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int numberCount(List<Integer> numbers, int number, int lenght) {
        int count = 0;
        for (int i = 0; i < lenght; i++) {
            if (numbers.get(i) == number) {
                count += 1;
            }
        }
        return count;
    }

    private static List<Integer> parseStringToIntList(String string) throws IOException {
        return Arrays.stream(string.split(" "))
                .map(Main::parseStringToInteger)
                .collect(Collectors.toList());
    }

    private static Integer parseStringToInteger(String string) {
        return Integer.parseInt(string);
    }
}
