package yandex.Item2.sprint1.tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class J {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int number = Integer.parseInt(reader.readLine());
            System.out.println(getMultipliers(number));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static String getMultipliers(int number) {
        int maxStep = (int) Math.sqrt(number);
        int divisible = number;
        int divider = 2;
        StringBuilder sb = new StringBuilder();
        while (divider <= divisible) {
            if (divider > maxStep) {
                break;
            }

            if (divisible % divider != 0) {
                divider++;
                continue;
            }
            sb.append(divider).append(" ");
            divisible /= divider;
        }

        if (divisible != 1) {
            sb.append(divisible).append(" ");
        }

        return sb.toString();
    }
}
