package yandex.Item2.sprint1.tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class A {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int[] numbers = parseString(reader.readLine());
            System.out.println(getFunctionValueAtX(numbers[0], numbers[1], numbers[2], numbers[3]));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int getFunctionValueAtX(int a, int x, int b, int c) {
        return (a * (x * x)) + (b * x) + c;
    }

    static int[] parseString(String string) {
        return Arrays.stream(string.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
