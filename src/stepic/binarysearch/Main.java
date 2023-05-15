package stepic.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int number = parseStringToInteger(reader.readLine());
            System.out.println(needQuestions(number));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int needQuestions(int number) {
        int count = 0;
        int sum = 1;
        while (sum < number) {
            sum = sum * 2;
            count++;
        }
        return count;
    }

    private static Integer parseStringToInteger(String string) {
        return Integer.parseInt(string);
    }
}
