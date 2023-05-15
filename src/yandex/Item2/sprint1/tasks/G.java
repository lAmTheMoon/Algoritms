package yandex.Item2.sprint1.tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class G {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int number = Integer.parseInt(reader.readLine());
            System.out.println(parseToBinry(number));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String parseToBinry(int number) {
        StringBuilder sb = new StringBuilder();
        do {
            sb.append(number % 2);
            number = number / 2;
            if (number == 1) {
                sb.append(number);
                break;
            }
        } while (number != 0);

        return sb.reverse().toString();
    }
}
