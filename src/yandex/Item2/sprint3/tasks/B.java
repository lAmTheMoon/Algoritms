package yandex.Item2.sprint3.tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class B {

    private static StringBuilder sb = new StringBuilder();
    private static Map<Integer, List<Character>> dictionary = new HashMap<>();

    static {
        dictionary.put(2, List.of('a', 'b', 'c'));
        dictionary.put(3, List.of('d', 'e', 'f'));
        dictionary.put(4, List.of('g', 'h', 'i'));
        dictionary.put(5, List.of('j', 'k', 'l'));
        dictionary.put(6, List.of('m', 'n', 'o'));
        dictionary.put(7, List.of('p', 'q', 'r', 's'));
        dictionary.put(8, List.of('t', 'u', 'v'));
        dictionary.put(9, List.of('w', 'x', 'y', 'z'));
    }

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int[] numbers = parseString(reader.readLine());
            getAllCombinations(numbers, "", 0);
            System.out.println(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void getAllCombinations(int[] numbers, String chars, int start) {
        if (numbers.length == start) {
            sb.append(chars);
            sb.append(" ");
            return;
        }

        for (int i = 0; i < dictionary.get(numbers[start]).size(); i++) {
            getAllCombinations(numbers,
                               chars.concat(String.valueOf(dictionary.get(numbers[start]).get(i))),
                               start + 1);
        }
    }

    private static int[] parseString(String string) {
        return Arrays.stream(string.split(""))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
