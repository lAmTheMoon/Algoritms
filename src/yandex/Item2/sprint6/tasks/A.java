package yandex.Item2.sprint6.tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class A {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] input = reader.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int m = Integer.parseInt(input[1]);
            Map<Integer, List<Integer>> map = new HashMap<>();
            for (int i = 1; i <= n; i++) {
                map.put(i, new ArrayList<>());
            }
            for (int i = 0; i < m; i++) {
                input = reader.readLine().split(" ");
                List<Integer> list = map.get(Integer.parseInt(input[0]));
                list.add(Integer.parseInt(input[1]));
            }
            System.out.println(getEdges(map));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static StringBuilder getEdges(Map<Integer, List<Integer>> map){
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            List<Integer> list = entry.getValue();
            int count = list.size();
            sb.append(count);
            if (count > 0) {
                list.forEach(num -> sb.append(" ").append(num));
            }
            sb.append("\n");
        }
        return sb;
    }
}
