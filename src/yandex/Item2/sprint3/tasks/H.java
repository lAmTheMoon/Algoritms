package yandex.Item2.sprint3.tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class H {

    private static final StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int count = Integer.parseInt(reader.readLine());
            String[] array = reader.readLine().split(" ");

            sortArray(count, array);

            for (int i = count - 1; i >= 0; i--) {
                sb.append(array[i]);
            }
            System.out.println(sb);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void sortArray(int count, String[] array) {
        for (int i = count - 1; i > 0; i--) {
            boolean flag = false;
            for (int j = 0; j < i; j++) {
                int o1 = 0;
                int o2 = 0;
                while (o1 <= o2) {
                    o1 = array[j].charAt(0);
                    o2 = array[j + 1].charAt(0);
                }
                if (o1 > o2) {
                    String temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    flag = true;
                }
            }
            if (!flag) {
                return;
            }
        }
    }
}
