package yandex.Item2.sprint3.tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int count = Integer.parseInt(reader.readLine());

            getGrackets(count);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void getGrackets(int count) {
        
    }
}
