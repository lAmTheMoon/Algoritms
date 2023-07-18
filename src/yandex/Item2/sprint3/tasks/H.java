package yandex.Item2.sprint3.tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class H {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int count = Integer.parseInt(reader.readLine());
            List<String> array = Arrays.stream(reader.readLine().split(" ")).collect(Collectors.toList());

            sortArray(count, array);

            array.forEach(System.out::print);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void sortArray(int size, List<String> array) {
        for (int i = 0; i < size; i++) {
            String num = array.get(i);
            int j = i;
            while (j > 0 && compare(num, array.get(j - 1))) {
                array.set(j, array.get(j - 1));
                j--;
                array.set(j, num);
            }
        }
    }

    private static boolean compare(String obj1, String obj2) {
        return (obj1 + obj2).compareTo(obj2 + obj1) > 0;
    }
}
