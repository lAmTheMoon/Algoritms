package yandex.Item2.sprint3.tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class J {

    private static final StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int count = Integer.parseInt(reader.readLine());
            int[] array = parseString(reader.readLine());

            if (array.length == 0) {
                return;
            }

            sortArray(count, array);

            System.out.println(sb);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void sortArray(int count, int[] array) {
        for (int i = count - 1; i > 0; i--) {
            boolean flag = false;
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    flag = true;
                }
            }
            if (!flag && i != count - 1) {
                return;
            }
            for (int n : array) {
                sb.append(n).append(" ");
            }
            sb.append("\n");
        }
    }

    private static int[] parseString(String string) {
        if (string.isEmpty()) {
            return new int[0];
        }
        return Arrays.stream(string.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
