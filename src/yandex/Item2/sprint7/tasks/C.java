package yandex.Item2.sprint7.tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class C {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int maxWeight = Integer.parseInt(reader.readLine());
            int count = Integer.parseInt(reader.readLine());
            List<Pair> pairs = new ArrayList<>(count);
            for (int i = 0; i < count; i++) {
                String[] input = reader.readLine().split(" ");
                pairs.add(new Pair(Integer.parseInt(input[0]), Integer.parseInt(input[1])));
            }
            pairs.sort(Collections.reverseOrder());

            BigInteger maxCost = BigInteger.ZERO;
            for (Pair value : pairs) {
                if (maxWeight == 0) {
                    break;
                }
                if (maxWeight >= value.count) {
                    maxCost = maxCost.add(BigInteger.valueOf(value.cost).multiply(BigInteger.valueOf(value.count)));
                    maxWeight -= value.count;
                } else {
                    maxCost = maxCost.add(BigInteger.valueOf(value.cost).multiply(BigInteger.valueOf(maxWeight)));
                    maxWeight = 0;
                }
            }
            System.out.println(maxCost);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class Pair implements Comparable<Pair> {
        private final int cost;
        private final int count;

        public Pair(int cost, int count) {
            this.cost = cost;
            this.count = count;
        }

        @Override
        public int compareTo(Pair o) {
            return (this.cost - o.cost);
        }
    }
}
