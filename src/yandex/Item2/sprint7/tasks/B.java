package yandex.Item2.sprint7.tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.*;

public class B {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int length = Integer.parseInt(reader.readLine());
            List<Pair> pairs = new ArrayList<>(length);
            for (int i = 0; i < length; i++) {
                String[] input = reader.readLine().split(" ");
                pairs.add(new Pair(new BigDecimal(input[0]), new BigDecimal(input[1])));
            }

            Collections.sort(pairs);
            List<Pair> schedule = getSchedule(pairs, length);
            printResult(schedule);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<Pair> getSchedule(List<Pair> pairs, int length) {
        List<Pair> schedule = new ArrayList<>();
        schedule.add(pairs.get(0));
        for (int i = 1; i < length; i++) {
            if (pairs.get(i).start.compareTo(schedule.get(schedule.size() - 1).end) >= 0) {
                schedule.add(pairs.get(i));
            }
        }
        return schedule;
    }

    private static void printResult(List<Pair> pairs) {
        StringBuilder sb = new StringBuilder();
        sb.append(pairs.size()).append("\n");
        for (Pair pair : pairs) {
            sb.append(pair.start).append(" ").append(pair.end).append("\n");
        }
        System.out.println(sb);
    }


    static class Pair implements Comparable<Pair> {
        BigDecimal start;
        BigDecimal end;

        public Pair(BigDecimal start, BigDecimal end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Pair o) {
            int signum = this.end.subtract(o.end).signum();
            if (signum == 0) {
                return this.start.subtract(o.start).signum();
            }
            return signum;
        }
    }
}
