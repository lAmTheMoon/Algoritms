package yandex.Item2.sprint3.tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class D {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int kidsCount = Integer.parseInt(reader.readLine());
            Integer[] kidAngryLine = parseString(reader.readLine());
            int cookiesCount = Integer.parseInt(reader.readLine());
            Integer[] cookiesSize = parseString(reader.readLine());
            System.out.println(happyKidsCount(kidsCount, cookiesCount, kidAngryLine, cookiesSize));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int happyKidsCount(int kidsCount, int cookiesCount, Integer[] kidAngryLine, Integer[] cookiesSize) {
        int happyKidCount = 0;
        for (int kid : kidAngryLine) {
            if (happyKidCount < cookiesCount && kid <= cookiesSize[happyKidCount]) {
                happyKidCount++;
            }
        }
        return happyKidCount;
    }

    private static Integer[] parseString(String string) {
        return Arrays.stream(string.split(" "))
                .map(Integer::parseInt)
                .sorted(Collections.reverseOrder())
                .toArray(Integer[]::new);
    }
}
