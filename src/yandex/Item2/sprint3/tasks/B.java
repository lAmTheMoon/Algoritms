package yandex.Item2.sprint3.tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class B {

    private static final List<String> STRINGS = List.of("abc", "def", "ghi","jkl", "mno","pqrs", "tuv", "wxyz");
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int[] numbers = parseString(reader.readLine());
            getAllCombinations(numbers, 0);
            System.out.println(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void getAllCombinations(int[] numbers, int start) {
        if (start >= numbers.length) {
            return;
        }
        char[] charsFirst = STRINGS.get(numbers[start]).toCharArray();
        int indexSecond = start + 1;
        for (int i = 0; i < charsFirst.length; i++) {
            if (indexSecond >= charsFirst.length - 1) {
                break;
            }
            char[] charsSecond = STRINGS.get(numbers[indexSecond]).toCharArray();
            for (int j = 0; j < charsSecond.length; j++) {
                sb.append(charsFirst[i]).append(charsSecond[j]).append(" ");
            }
        }
        getAllCombinations(numbers, start + 1);
    }

    private static int[] parseString(String string) {
        return Arrays.stream(string.split(""))
                .mapToInt(str -> Integer.parseInt(str) - 2)
                .toArray();
    }
}
