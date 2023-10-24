package yandex.Item2.sprint8.tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class A {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            List<String> worlds = getListFromStrings(reader.readLine());
            System.out.println(gerReverseText(worlds));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String gerReverseText(List<String> worlds) {
        StringBuilder bf = new StringBuilder();
        for (int i = worlds.size() - 1; i >= 0; i--) {
            bf.append(worlds.get(i)).append(" ");
        }
        return bf.toString();
    }

    private static List<String> getListFromStrings(String input) throws IOException {
        return Arrays.stream(input.split(" "))
                .collect(Collectors.toList());
    }
}
