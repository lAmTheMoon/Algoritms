package yandex.Item2.sprint3.tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class C {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            char[] subString = reader.readLine().toCharArray();
            char[] bigString = reader.readLine().toCharArray();
            System.out.println(isSubstring(subString, bigString));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String isSubstring(char[] substring, char[] bigString) {
        int j = 0;
        for (char c : bigString) {
            if (substring[j] == c) {
                if (j == substring.length - 1) {
                    return "True";
                }
                j++;
            }
        }
        return "False";
    }
}
