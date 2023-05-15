package stepic.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main5 {

    public static void main(String[] args) {

        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int firstLenght = Integer.parseInt(reader.readLine());
            int[] firstList = parseString(reader.readLine());
            int secondLenght = Integer.parseInt(reader.readLine());
            int[] secondList = parseString(reader.readLine());
            printCountNumInList(firstLenght, firstList, secondLenght, secondList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printCountNumInList(int firstLenght, int[] firstList,
                                            int secondLenght, int[] secondList) {
        for (int i = 0; i < secondLenght; i++) {
            int leftF = -1;
            int rightF = firstLenght - 1;

            while (leftF + 1 < rightF) {
                int middle = leftF + ((rightF - leftF) / 2);

                if (firstList[middle] < secondList[i]) {
                    leftF = middle;
                } else {
                    rightF = middle;
                }
            }

            if (firstList[rightF] != secondList[i]) {
                System.out.print(0 + " ");
                continue;
            }

            int leftS = rightF;
            int rightS = firstLenght;

            while (leftS + 1 < rightS) {
                int middle = leftS + ((rightS - leftS) / 2);

                if (firstList[middle] <= secondList[i]) {
                    leftS = middle;
                } else {
                    rightS = middle;
                }
            }
            if (firstList[leftS] == secondList[i]) System.out.print(leftS - leftF + " ");
        }
    }

    static int[] parseString(String string) {
        return Arrays.stream(string.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
