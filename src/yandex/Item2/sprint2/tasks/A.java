package yandex.Item2.sprint2.tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class A {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int stringCount = Integer.parseInt(reader.readLine());
            int columnsCount = Integer.parseInt(reader.readLine());
            int[] matrix = new int[stringCount * columnsCount];
            for (int i = 0; i < stringCount; i++) {
                int[] str = parseString(reader.readLine());
                for (int j = 0; j < columnsCount; j++) {
                    matrix[j * stringCount + i] = str[j];
                }
            }
            printMatrix(matrix, stringCount);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printMatrix(int[] matrix, int count) {
        for (int i = 0; i < matrix.length; i++) {
            System.out.print(matrix[i] + " ");
            if ((i + 1) % count == 0) {
                System.out.println();
            }
        }
    }

    static int[] parseString(String string) {
        return Arrays.stream(string.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
