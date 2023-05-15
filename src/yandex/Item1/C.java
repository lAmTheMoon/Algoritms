package yandex.Item1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class C {

    private static List<Double> movingAverage(int n, List<Integer> arr, int windowSize) {
        List<Double> avgList = new ArrayList<>();
        double firstAvg = getFirstAvg(arr, windowSize);
        avgList.add(firstAvg / windowSize);
        for (int i = 0; i < n - windowSize; i++) {
            firstAvg = firstAvg - arr.get(i) + arr.get(i + windowSize);
            avgList.add(firstAvg / windowSize);
        }
        return avgList;
    }

    private static double getFirstAvg(List<Integer> arr, int windowSize) {
        double firstAvg = 0;
        for (int i = 0; i < windowSize; i++) {
            firstAvg += arr.get(i);
        }
        return firstAvg;
    }


    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int n = readInt(reader);
            List<Integer> arr = readList(reader);
            int windowSize = readInt(reader);
            List<Double> result = movingAverage(n, arr, windowSize);
            for (double elem : result) {
                writer.write(elem + " ");
            }
        }
    }


    private static int readInt(BufferedReader reader) throws IOException {
        return Integer.parseInt(reader.readLine());
    }

    private static List<Integer> readList(BufferedReader reader) throws IOException {
        return Arrays.asList(reader.readLine().split(" "))
                .stream()
                .map(elem -> Integer.parseInt(elem))
                .collect(Collectors.toList());
    }
}