package yandex.Item2.sprint1.tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int[] numbers = parseString(reader.readLine());
            System.out.println(isWin(numbers) ? "WIN" : "FAIL");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean isWin(int[] numbers) {
        int sum = 0;
        for (int num : numbers) {
            if (num % 2 == 0) {
                sum++;
            } else {
                sum--;
            }
        }
        return Math.abs(sum) == numbers.length;
    }

    private static int[] parseString(String string) {
        return Arrays.stream(string.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
