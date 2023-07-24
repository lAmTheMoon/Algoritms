package yandex.Item2.sprint3.tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class A {

    private static final StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int count = Integer.parseInt(reader.readLine());
            char[] brackets = getBrackets(count);
            reverseSort(count, brackets);
            System.out.println(sb);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static char[] getBrackets(int count) {
        char[] brackets = new char[count * 2];
        for (int i = 0; i < count; i++) {
            brackets[i] = 'A';
            brackets[brackets.length - 1 - i] = 'B';
        }
        sb.append(brackets).append("\n");

        return brackets;
    }

    private static void reverseSort(int count, char[] brackets) {
        sort(brackets);
        if (count > 1) {
            reverseSort(count - 1, brackets);
            reverseSort(count - 1, brackets);
        }
    }

    private static void sort(char[] brackets) {
        for (int j = 1; j < brackets.length - 1; j++) {
            if (brackets[j] < brackets[j + 1]) {
                char temp = brackets[j];
                brackets[j] = brackets[j + 1];
                brackets[j + 1] = temp;
                sb.append(brackets).append("\n");
                break;
            }
        }
    }

    // AAAABBBB
    // AAABABBB
    // AAABBABB
    // AAABBBAB
    // AABAABBB
    // AABABABB
    // AABABBAB
    // AABBAABB
    // AABBABAB
    // ABAAABBB
    // ABAABABB
    // ABAABBAB
    // ABABAABB
    // ABABABAB

}
