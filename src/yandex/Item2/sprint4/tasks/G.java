package yandex.Item2.sprint4.tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class G {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine());
            if (n == 0) {
                System.out.println(n);
                return;
            }

            List<Integer> array = parseString(reader.readLine());

            Map<Integer, List<Integer>> indexesByPrefixSum  = new HashMap<>();
            int sum = 0;
            List<Integer> indexes = new ArrayList<>();
            indexes.add(sum);
            indexesByPrefixSum.put(sum, indexes);
            for (int i = 0; i < n; i++) {
                sum = array.get(i) + sum;
                if (indexesByPrefixSum.containsKey(sum)) {
                    indexesByPrefixSum.get(sum).add(i + 1);
                } else {
                    indexes = new ArrayList<>();
                    indexes.add(i + 1);
                    indexesByPrefixSum.put(sum, indexes);
                }
            }

            int max = Integer.MIN_VALUE;

            for (Map.Entry<Integer, List<Integer>> entry : indexesByPrefixSum.entrySet()) {
                indexes = entry.getValue();
                int difference = indexes.get(indexes.size() - 1) - indexes.get(0);
                if (max < difference) {
                    max = difference;
                }
            }

            System.out.println(max);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<Integer> parseString(String string) {
        return Arrays.stream(string.split(" "))
                .map(Integer::parseInt)
                .map(i -> i == 0 ? -1 : 1)
                .collect(Collectors.toList());
    }
}
