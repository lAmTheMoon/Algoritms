package yandex.Item2.sprint6.tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class G {

    private static List<Color> color;
    private static List<Integer> distance;
    private static int lastN;

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
            int startN = Integer.parseInt(reader.readLine());
            initializeLists(n);
            BFS(startN, map);
            System.out.println(getMax());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Integer getMax() {
        return distance.get(lastN);
    }

    private static void initializeLists(int numVertices) {
        int size = numVertices + 1;
        color = new ArrayList<>(size);
        distance = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            color.add(Color.WHITE);
            distance.add(0);
        }
    }

    private static void BFS(int s, Map<Integer, List<Integer>> map) {
        color.set(s, Color.GRAY);
        Queue<Integer> planned = new LinkedList<>();
        planned.add(s);
        distance.add(0);

        while (!planned.isEmpty()) {
            int u = planned.poll();
            List<Integer> outgoingEdges = map.get(u);
            Collections.sort(outgoingEdges);
            for (int v : outgoingEdges) {
                if (Color.WHITE == color.get(v)) {
                    distance.set(v, distance.get(u) + 1);
                    color.set(v, Color.GRAY);
                    planned.add(v);
                }
            }

            lastN = u;
        }

        color.set(s, Color.BLACK);
    }

    enum Color {
        WHITE("WHITE"),
        GRAY("GRAY"),
        BLACK("BLACK");

        Color(String title) {
        }
    }
}
