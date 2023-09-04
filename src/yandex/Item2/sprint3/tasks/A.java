package yandex.Item2.sprint3.tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A {

    private static final StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int count = Integer.parseInt(reader.readLine());
            int check = 0;
            getBrackets(count, count, check, "");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void getBrackets(int first, int second, int check, String brackets) {
        if (first == 0 && second == 0) {
            System.out.println(brackets);
        } else {
            if (first > 0) {
                getBrackets(first - 1, second, check + 1, brackets + ('('));
            }
            if (check > 0 && second > 0) {
                getBrackets(first, second - 1, check - 1, brackets + (')'));
            }
        }
    }
}
