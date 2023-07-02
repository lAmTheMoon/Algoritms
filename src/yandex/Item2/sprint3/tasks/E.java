package yandex.Item2.sprint3.tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class E {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int sum = Integer.parseInt(reader.readLine().split(" ")[1]);
            int[] costs = parseString(reader.readLine());
            System.out.println(houseCount(sum, costs));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int houseCount(int sum, int[] costs) {
        int count = 0;
        for (int i : costs) {
            if (i <= sum) {
                count++;
                sum = sum - i;
            }
        }
        return count;
    }

    private static int[] parseString(String string) {
        return Arrays.stream(string.split(" "))
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();
    }
}
