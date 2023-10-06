package yandex.Item2.sprint6.tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class E {

    private static List<Integer> color;
    private static int componentNum;

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] input = reader.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int m = Integer.parseInt(input[1]);
            Map<Integer, List<Integer>> map = new HashMap<>(n);
            for (int i = 0; i <= n; i++) {
                map.put(i, new ArrayList<>());
            }
            for (int i = 1; i <= m; i++) {
                input = reader.readLine().split(" ");
                int key = Integer.parseInt(input[0]);
                int value = Integer.parseInt(input[1]);
                List<Integer> listk = map.get(key);
                listk.add(value);
                List<Integer> listv = map.get(value);
                listv.add(key);
            }
            initializeColor(n);
            for (int i = 1; i <= n; i++) {
                if (color.get(i) == -1) {
                    componentNum++;
                    DFS(i, map);
                }
            }
            fillInfoAndPrint(n);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void fillInfoAndPrint(int n) {
        StringBuilder sb = new StringBuilder();
        Map<Integer, List<Integer>> map = new TreeMap<>();
        for (int i = 1; i <= n; i++) {
            int colorN = color.get(i);
            if (map.containsKey(colorN)) {
                List<Integer> list = map.get(colorN);
                list.add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(colorN, list);
            }
        }

        sb.append(map.size()).append("\n");

        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            List<Integer> list = entry.getValue();
            list.forEach(v -> sb.append(v).append(" "));
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static void initializeColor(int numVertices) {
        int size = numVertices + 1;
        color = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            color.add(-1);
        }
    }

    private static void DFS(int v, Map<Integer, List<Integer>> map) {
        color.set(v, 0);
        List<Integer> outgoingEdges = map.get(v);
        Collections.sort(outgoingEdges);

        for (int w : outgoingEdges) {
            if (color.get(w) == -1) {
                DFS(w, map);
            }
        }

        color.set(v, componentNum);
    }
}
