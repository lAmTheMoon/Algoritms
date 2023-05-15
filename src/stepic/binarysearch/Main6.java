package stepic.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main6 {

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
            int leftF = -1;
            int rightF = lenghts[0] - 1;

            while (leftF + 1 < rightF) {
                int middle = leftF + ((rightF - leftF) / 2);

                if (firstList[middle] < secondList[i]) {
                    leftF = middle;
                } else {
                    rightF = middle;
                }
            }
            if (firstList[rightF] == secondList[i]) {
                System.out.println(firstList[rightF]);
            } else {
                if (leftF != -1) {
                    int num = Math.abs(secondList[i] - firstList[leftF])
                            <= Math.abs(secondList[i] - firstList[rightF]) ? leftF : rightF;
                    System.out.println(firstList[num]);
                } else {
                    System.out.println(firstList[rightF]);
                }
            }
        }
    }

    static int[] parseString(String string) {
        return Arrays.stream(string.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
