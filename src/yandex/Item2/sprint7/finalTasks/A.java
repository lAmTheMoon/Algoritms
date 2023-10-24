package yandex.Item2.sprint7.finalTasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.List;

/**
 * ID посылки 94617232
 *
 * Чтобы подсчитать минимальное количество правок будем использовать метод динамического программирования,
 * для этого нам потребуется два массива, в которых мы будем записывать предыдущие эл-ты и текущие,
 * а ответ будет находиться в предпоследней ячейке текущего массива,
 *
 * Временная сложность - O(N*M), где N - длина первой строки, а M - длина второй строки
 * Временная и пространственная сложность - O(K), где К эо длина наименьшей строки
 */

public class A {

    private static final int SHIFT = 1;

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String first = reader.readLine();
            String second = reader.readLine();

            System.out.println(getLevenshteinDistance(first, second));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int getLevenshteinDistance(String first, String second) {
        if (first.length() > second.length()) {
            String swap = first;
            first = second;
            second = swap;
        }
        int minLength = first.length() + SHIFT;
        int[] previous = new int[minLength];

        for (int i = 0; i <= second.length(); i++) {
            int[] current = new int[minLength];
            for (int j = 0; j < minLength; j++) {
                if (i == 0) {
                    current[j] = j;
                } else if (j == 0) {
                    current[j] = i;
                } else {
                    int c = isEqualsChars(second.charAt(i - 1), first.charAt(j - 1));
                    current[j] = getMin(previous, current, j, c);
                }
            }
            previous = current;
        }

        return previous[minLength - 1];
    }

    private static int getMin(int[] previous, int[] current, int j, int c) {
        List<Integer> counts = List.of(previous[j] + 1, current[j - 1] + 1, previous[j - 1] + c);
        return counts.stream()
                .min(Comparator.naturalOrder()).get();
    }

    private static int isEqualsChars(char first, char second) {
        return first == second ? 0 : 1;
    }
}
