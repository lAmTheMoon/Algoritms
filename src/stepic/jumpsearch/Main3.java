package stepic.jumpsearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main3 {

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int[] lenghts = parseString(reader.readLine());
            int[] firstList = parseString(reader.readLine());
            int[] secondList = parseString(reader.readLine());
            printNumInList(lenghts, firstList, secondList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printNumInList(int[] lenghts, int[] firstList, int[] secondList) {
        for (int i = 0; i < lenghts[1]; i++) {
            int step = (int) Math.sqrt(lenghts[0]);
            int start = 0;
            int end = step - 1;

            while (firstList[end] < secondList[i] &&
                    end < lenghts[0] - 1 && firstList[end + 1] <= secondList[i]) {
                start = Math.min(lenghts[0] - 1, start + step);
                end = Math.min(lenghts[0] - 1, end + step);
            }

            int result = 0;

            if (secondList[i] <= firstList[end]) {
                for (int j = end; j >= start; j--) {
                    if (secondList[i] == firstList[j]) {
                        result = j + 1;
                        break;
                    }
                }
            }

            System.out.println(result);
        }
    }

    static int[] parseString(String string) {
        return Arrays.stream(string.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
