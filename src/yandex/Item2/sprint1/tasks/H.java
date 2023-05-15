package yandex.Item2.sprint1.tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class H {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int[] firstNumber = parseString(reader.readLine());
            int[] secondNumber = parseString(reader.readLine());
            System.out.println(sumNumbers(firstNumber, secondNumber));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String sumNumbers(int[] firstNumber, int[] secondNumber) {
        int length = Math.max(firstNumber.length, secondNumber.length);
        int memory = 0;
        int i = 1;
        int first = 0;
        int second = 0;
        int result = 0;

        StringBuilder sb = new StringBuilder();
        while (length != 0) {
            first = firstNumber.length - i >= 0 ? firstNumber[firstNumber.length - i] : 0;
            second = secondNumber.length - i >= 0 ? secondNumber[secondNumber.length - i] : 0;
            i++;
            length--;
            result = first + second + memory;

            if(result <= 1) {
                sb.append(result);
                memory = 0;
            }
            if(result == 2) {
                sb.append(0);
                memory = 1;
            }
            if(result == 3) {
                sb.append(1);
                memory = 1;
            }
        }
        if (memory == 1) {
            sb.append(1);
        }
        return sb.reverse().toString();
    }

    static int[] parseString(String string) {
        return Arrays.stream(string.split(""))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
