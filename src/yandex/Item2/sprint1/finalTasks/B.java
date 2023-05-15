package yandex.Item2.sprint1.finalTasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * ID посылки 87343737
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
        Map<Integer, Long> numbers = parseToGroupingMap(symbols);
        int points = 0;
        for (long num : numbers.values()) {
            if ((int) num <= k * COUNT_FRIENDS) {
                points++;
            }
        }
        return points;
    }

    private static Map<Integer, Long> parseToGroupingMap(String string) {
        return Arrays.stream(string.replaceAll("[^1-9]", "").split(""))
                .filter(s -> !s.isEmpty())
                .map(Integer::parseInt)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }
}
