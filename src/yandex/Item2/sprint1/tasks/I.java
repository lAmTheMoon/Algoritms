package yandex.Item2.sprint1.tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class I {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int number = Integer.parseInt(reader.readLine());
            System.out.println(isNumberInFourthPow(number));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String isNumberInFourthPow(int number) {
        int numInPow = 1;
        int pow = 4;
        do {
            if (number == numInPow) {
                return "True";
            }
            numInPow *= pow;
        } while (number >= numInPow);

        return "False";
    }
}
