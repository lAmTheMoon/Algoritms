package yandex.Item2.sprint1.tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class D {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int lengthArray = Integer.parseInt(reader.readLine());
            int[] degrees = parseString(reader.readLine());
            System.out.println(getChaos(lengthArray, degrees));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int getChaos(int lengthArray, int[] degrees) {
        if (lengthArray == 1) {
            return 1;
        }

        int chaosCount = 0;
        for (int i = 0; i < lengthArray; i++) {
            if (i == 0) {
                chaosCount += pharseToInt(degrees[i] > degrees[i + 1]);
                continue;
            }
            if (i == lengthArray - 1) {
                chaosCount += pharseToInt(degrees[i] > degrees[i - 1]);
                continue;
            }

            chaosCount += pharseToInt(degrees[i] > degrees[i - 1] && degrees[i] > degrees[i + 1]);
        }
        return chaosCount;
    }

    private static int pharseToInt(boolean condition) {
        return condition ? 1 : 0;
    }

    private static int[] parseString(String string) {
        return Arrays.stream(string.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
