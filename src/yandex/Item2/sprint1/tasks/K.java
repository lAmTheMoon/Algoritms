package yandex.Item2.sprint1.tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

public class K {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int lengthArray = Integer.parseInt(reader.readLine());
            BigDecimal firstNumber = new BigDecimal(reader.readLine().replaceAll("[\\s]", ""));
            BigDecimal secondNumber = new BigDecimal(reader.readLine());
            getSum(firstNumber, secondNumber);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void getSum(BigDecimal firstNumber, BigDecimal secondNumber) {
        char[] array = String.valueOf(firstNumber.add(secondNumber)).toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char c : array) {
            sb.append(c).append(" ");
        }
        System.out.println(sb);
    }
}
