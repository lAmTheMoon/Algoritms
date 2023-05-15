package stepic.linesearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main2 {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int lenght = parseStringToInteger(reader.readLine());
            List<Integer> numbers = parseStringToIntList(reader.readLine());
            int findNumber = parseStringToInteger(reader.readLine());
            numbersPositions(numbers, findNumber, lenght).forEach(n -> System.out.print(n + " "));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<Integer> numbersPositions(List<Integer> numbers, int number, int lenght) {
        List<Integer> positions = new ArrayList<>();
        for (int i = 0; i < lenght; i++) {
            if (numbers.get(i) == number) {
                positions.add(i + 1);
            }
        }
        return positions;
    }

    private static List<Integer> parseStringToIntList(String string) throws IOException {
        return Arrays.stream(string.split(" "))
                .map(Main2::parseStringToInteger)
                .collect(Collectors.toList());
    }

    private static Integer parseStringToInteger(String string) {
        return Integer.parseInt(string);
    }
}
