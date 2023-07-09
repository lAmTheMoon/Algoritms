package yandex.Item2.sprint3.tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class G {

    private static final StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int k = 3;
            int[] counts = new int[k];
            int n = Integer.parseInt(reader.readLine());
            int[] array = parseString(reader.readLine());

            if (array.length == 0) {
                return;
            }

            for (int i = 0; i < n; i++) {
                int x = array[i];
                counts[x] = counts[x] + 1;
            }

            for (int i = 0; i < k; i++) {
                for (int j = 0; j < counts[i]; j++)
                {
                    sb.append(i).append(" ");
                }
            }
            System.out.println(sb);
        } catch (IOException e) {
            e.printStackTrace();
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
