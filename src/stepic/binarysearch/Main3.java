package stepic.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main3 {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            List<Integer> lengths = parseStringToIntList(reader.readLine());
            List<Integer> firstList = parseStringToIntList(reader.readLine());
            List<Integer> secondList = parseStringToIntList(reader.readLine());
            printNumberPosition(lengths, firstList, secondList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printNumberPosition(List<Integer> lengths,
                                            List<Integer> firstList,
                                            List<Integer> secondList) {
        for (int i = 0; i < lengths.get(1); i++) {
            int left = 0;
            int right = lengths.get(0);
            while (left + 1 < right) {
                int middle = left + ((right - left) / 2);

                if (firstList.get(middle) <= secondList.get(i)) {
                    left = middle;
                } else {
                    right = middle;
                }
            }
            if (Objects.equals(firstList.get(left), secondList.get(i))) {
                System.out.println(left + 1);
            } else {
                System.out.println(0);
            }
        }
    }

    private static List<Integer> parseStringToIntList(String string) throws IOException {
        return Arrays.stream(string.split(" "))
                .map(Main3::parseStringToInteger)
                .collect(Collectors.toList());
    }

    private static Integer parseStringToInteger(String string) {
        return Integer.parseInt(string);
    }
}
