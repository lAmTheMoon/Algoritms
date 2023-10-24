package yandex.Item2.sprint8.tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class E {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] word = reader.readLine().split("");
            int count = Integer.parseInt(reader.readLine());

            for (int i = 0; i < count; i++) {
                String[] input = reader.readLine().split(" ");
                int n = Integer.parseInt(input[1]) - 1;
                if (n == -1) {
                    word[0] = input[0] + word[0];
                } else {
                    word[n] = word[n] + input[0];
                }
            }
            StringBuilder sb = new StringBuilder();
            for (String s : word) {
                sb.append(s);
            }

            System.out.println(sb);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
