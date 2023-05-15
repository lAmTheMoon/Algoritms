package yandex.Item2.sprint1.tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;

public class F {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            char[] words = reader.readLine().toLowerCase(Locale.ROOT)
                    .replaceAll("[^a-z]", "").toCharArray();
            System.out.println(checkIsPalindrom(words) ? "True" : "False");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean checkIsPalindrom(char[] words) {
        if (words.length == 0) {
            return false;
        }

        int rightPoint = words.length - 1;
        for (int leftPoint = 0; leftPoint < words.length / 2; leftPoint++) {
            if (words[leftPoint] == words[rightPoint]) {
                rightPoint--;
            } else {
                return false;
            }
        }
        return true;
    }
}
