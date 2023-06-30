package yandex.Item2.sprint4.finalTasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class A {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int firstCount = Integer.parseInt(reader.readLine());
            StringBuilder pages = new StringBuilder(firstCount);
            for (int i = 0; i < firstCount; i++) {
                pages.append(reader.readLine());
            }
            int secondCount = Integer.parseInt(reader.readLine());
            StringBuilder questions = new StringBuilder(firstCount);
            for (int i = 0; i < secondCount; i++) {
               questions.append(reader.readLine());
            }
            Map<String, List<Integer>> dictionary = new HashMap<>();
            Arrays.stream(pages.toString().split(" "))
                    .forEach(dictionary.merge());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
