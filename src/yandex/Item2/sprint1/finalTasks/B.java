package yandex.Item2.sprint1.finalTasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * ID посылки 87359230
 */
public class B {

    private static final int COUNT_STRINGS = 4;
    private static final int COUNT_FRIENDS = 2;

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int k = Integer.parseInt(reader.readLine());
            StringBuilder symbols = new StringBuilder();
            for (int i = 0; i < COUNT_STRINGS; i++) {
                symbols.append(reader.readLine());
            }
            System.out.println(getMaximumPoints(k, symbols.toString()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static long getMaximumPoints(int k, String symbols) {
        Map<Integer, Integer> numbers = parseToGroupingMap(symbols);
        return numbers.values().stream()
                .filter(num -> num <= k * COUNT_FRIENDS)
                .count();
    }

    private static Map<Integer, Integer> parseToGroupingMap(String string) {
        return Arrays.stream(string.replaceAll("[^1-9]", "").split(""))
                .filter(s -> !s.isEmpty())
                .map(Integer::parseInt)
                .collect(Collectors.toMap(Function.identity(), num -> 1, Integer::sum));
    }
}
