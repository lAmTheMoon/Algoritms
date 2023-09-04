package yandex.Item2.sprint4.tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.Set;

public class D {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int num = Integer.parseInt(reader.readLine());
            Set<String> hobbies = new LinkedHashSet<>();
            for (int i = 0; i < num; i++) {
                hobbies.add(reader.readLine());
            }

            StringBuilder sb = new StringBuilder();
            hobbies.forEach(hobbie -> sb.append(hobbie).append("\n"));
            System.out.println(sb);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
