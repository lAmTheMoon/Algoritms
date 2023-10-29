package yandex.Item2.sprint8.tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;


public class F {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int count = Integer.parseInt(reader.readLine());
            Map<String, Integer> worlds = new HashMap<>();
            for (int i = 0; i < count; i++) {
                String imput = reader.readLine();
             if (worlds.get(imput) == null) {
                 worlds.put(imput, 1);
             } else {
                 worlds.merge(imput, 1, Integer::sum);
             }
            }
            List<Map.Entry<String, Integer>> entries = worlds.entrySet().stream()
                    .sorted(Map.Entry.comparingByValue())
                    .collect(Collectors.toList());

            Set<String> w = new HashSet<>();
            for (int i = entries.size() - 1; i > 0; i--) {
                if (entries.get(i).getValue() > entries.get(i - 1).getValue()) {
                    w.add(entries.get(i).getKey());
                    break;
                } else if (Objects.equals(entries.get(i).getValue(), entries.get(i - 1).getValue())) {
                    w.add(entries.get(i).getKey());
                }
            }

            System.out.println(w.stream().sorted().findFirst().get());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
